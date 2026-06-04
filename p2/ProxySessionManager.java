import java.util.Stack;
/*
In real proxies, you often have to temporarily modify the state of the network engine (like opening connection pools, switching to SSL, or attaching authentication headers) 
and then perfectly revert those changes when a test session ends.
*/

enum ProxyStateMutation {
    ATTACH_SSL_CERT,
    ATTACH_BEARER_TOKEN,
    OVERRIDE_PROXY_ROUTE
}

class NetworkConfigMutation {
    public ProxyStateMutation mutationType;
    public String metadata; // Stores previous state or keys to reverse
    public int originalTimeout;

    public NetworkConfigMutation(ProxyStateMutation type, String metadata, int originalTimeout) {
        this.mutationType = type;
        this.metadata = metadata;
        this.originalTimeout = originalTimeout;
    }
}

// Low-level network adapter managing the actual proxy engine state
class LiveNetworkEngine {
    public void enableSsl(String certPath) { System.out.println("SSL Encrypted with: " + certPath); }
    public void disableSsl() { System.out.println("SSL Downgraded back to HTTP"); }
    public void injectGlobalAuthHeader(String token) { System.out.println("Forcing Authorization Header: Bearer " + token); }
    public void clearGlobalAuthHeader() { System.out.println("Cleared global Auth headers"); }
    public void rerouteTraffic(String targetIp) { System.out.println("Rerouting upstream traffic to: " + targetIp); }
}

// The Root Entity managing the life-cycle of a test execution
public class ProxySessionManager {
    private final Stack<NetworkConfigMutation> stateHistory = new Stack<>();
    private final LiveNetworkEngine networkEngine = new LiveNetworkEngine();

    public void applySslConfiguration(String certificatePath) {
        networkEngine.enableSsl(certificatePath);
        stateHistory.push(new NetworkConfigMutation(ProxyStateMutation.ATTACH_SSL_CERT, certificatePath, 0));
    }

    public void authorizeTestSession(String jwtToken) {
        networkEngine.injectGlobalAuthHeader(jwtToken);
        stateHistory.push(new NetworkConfigMutation(ProxyStateMutation.ATTACH_BEARER_TOKEN, jwtToken, 0));
    }

    public void poisonRoutingTable(String maliciousIp) {
        networkEngine.rerouteTraffic(maliciousIp);
        stateHistory.push(new NetworkConfigMutation(ProxyStateMutation.OVERRIDE_PROXY_ROUTE, maliciousIp, 0));
    }

    // THE CRITICAL UNDO METHOD
    // If a new mutation type is added to the proxy, but forgotten here, 
    // network security or routes leak permanently into the next running test suite!
    public void rollbackLastNetworkMutation() {
        if (stateHistory.isEmpty()) return;

        NetworkConfigMutation mutation = stateHistory.pop();

        if (mutation.mutationType == ProxyStateMutation.ATTACH_SSL_CERT) {
            networkEngine.disableSsl();
        }
        
        if (mutation.mutationType == ProxyStateMutation.ATTACH_BEARER_TOKEN) {
            networkEngine.clearGlobalAuthHeader();
        }

        if (mutation.mutationType == ProxyStateMutation.OVERRIDE_PROXY_ROUTE) {
            // SMELL: Hardcoded "fix" or impossible reversal because we forgot to save 
            // the original route destination in our value object!
            System.out.println("CRITICAL ERROR: Cannot fully revert route mutation safely!");
        }
    }
}
