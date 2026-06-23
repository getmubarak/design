import java.util.Stack;
/*
In real proxies, you often have to temporarily modify the state of the network engine (like opening connection pools, switching to SSL, or attaching authentication headers) 
and then perfectly revert those changes when a test session ends.
*/

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
    private final Stack<Lambda> stateHistory = new Stack<>();
    private final LiveNetworkEngine networkEngine = new LiveNetworkEngine();

    public void applySslConfiguration(String certificatePath) {
        networkEngine.enableSsl(certificatePath);
        stateHistory.push(lambda networkEngine: networkEngine.disableSsl());
    }

    public void authorizeTestSession(String jwtToken) {
        networkEngine.injectGlobalAuthHeader(jwtToken);
        stateHistory.push(lambda networkEngine:  networkEngine.clearGlobalAuthHeader());
    }

    public void poisonRoutingTable(String maliciousIp) {
        networkEngine.rerouteTraffic(maliciousIp);
        stateHistory.push(lambda networkEngine:System.out.println("CRITICAL ERROR: Cannot fully revert route mutation safely!") );
    }

    public void rollbackLastNetworkMutation() {
        if (stateHistory.isEmpty()) return;

        Lambda rollback = stateHistory.pop();
        rollback();
    }
}
