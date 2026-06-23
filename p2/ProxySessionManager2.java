import java.util.Stack;
/*
In real proxies, you often have to temporarily modify the state of the network engine (like opening connection pools, switching to SSL, or attaching authentication headers) 
and then perfectly revert those changes when a test session ends.
*/

interface MutationType{
    rollBack();
}
class BaseMutationType implements MutationType {
    protected String metadata; // Stores previous state or keys to reverse
    protected int originalTimeout;
    protected LiveNetworkEngine networkEngine;
    public BaseMutationType(LiveNetworkEngine networkEngine, String metadata, int originalTimeout) {
        this.networkEngine = networkEngine;
        this.metadata = metadata;
        this.originalTimeout = originalTimeout;
    }
}
class AttachSslCert extends BaseMutationType{
    void rollBack(){
        networkEngine.disableSsl();
    }
}
class AttachBearerToken extends BaseMutationType{
    void rollBack(){
        networkEngine.clearGlobalAuthHeader();
    }
}
class OverrideProxyRoute extends BaseMutationType{
    void rollBack(){
            // SMELL: Hardcoded "fix" or impossible reversal because we forgot to save 
            // the original route destination in our value object!
            System.out.println("CRITICAL ERROR: Cannot fully revert route mutation safely!");
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
    private final Stack<MutationType> stateHistory = new Stack<>();
    private final LiveNetworkEngine networkEngine = new LiveNetworkEngine();

    public void applySslConfiguration(String certificatePath) {
        networkEngine.enableSsl(certificatePath);
        stateHistory.push(new AttachSslCert(networkEngine,certificatePath, 0));
    }

    public void authorizeTestSession(String jwtToken) {
        networkEngine.injectGlobalAuthHeader(jwtToken);
        stateHistory.push(new AttachBearerToken(networkEngine, jwtToken, 0));
    }

    public void poisonRoutingTable(String maliciousIp) {
        networkEngine.rerouteTraffic(maliciousIp);
        stateHistory.push(new OverrideProxyRoute(networkEngine, maliciousIp, 0));
    }

    public void rollbackLastNetworkMutation() {
        if (stateHistory.isEmpty()) return;

        MutationType mutation = stateHistory.pop();
        mutation.rollback();
    }
}
