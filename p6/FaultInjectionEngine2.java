package problem6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

// --- DOMAIN LAYER (Mocked Network Entities) ---
class ProxyResponse {
    private int statusCode = 200;
    private String body = "";
    private final Map<String, String> headers = new HashMap<>();

    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    public void setBody(String body) { this.body = body; }
    public void addHeader(String key, String value) { this.headers.put(key, value); }
    
    public int getStatusCode() { return statusCode; }
    public String getBody() { return body; }
    public Map<String, String> getHeaders() { return headers; }
}

class ErrorPayLoadBuilder 
{
    public String buildJsonErrorPayload(String errorCode, String message) {
        if (message == null) {
            message = "";
        }
        
        // Manual JSON serialization, escaping, and defensive formatting
        String escapedMessage = message
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"timestamp\": ").append(System.currentTimeMillis()).append(",\n");
        jsonBuilder.append("  \"status\": \"simulated_failure\",\n");
        jsonBuilder.append("  \"error\": {\n");
        jsonBuilder.append("    \"code\": \"").append(errorCode).append("\",\n");
        jsonBuilder.append("    \"description\": \"").append(escapedMessage).append("\"\n");
        jsonBuilder.append("  }\n");
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
//********************** Faults *********************
interface FaultType{
    ProxyResponse createResponse(ProxyResponse originalResponse);
}
class ServiceUnavailable implements FaultType{
    ProxyResponse createResponse(ProxyResponse originalResponse){
                originalResponse.setStatusCode(503);
                originalResponse.addHeader("Content-Type", "application/json");
                originalResponse.setBody(errorPayLoadBuilder.buildJsonErrorPayload("ERR_SYS_503", "Target upstream service cluster is temporarily overloaded under high simulation load."));
                return  originalResponse;                
    }
}
....RATE_LIMITED, BAD_GATEWAY
//********************** Engine **************************
public class FaultInjectionEngine {
    private static final Logger LOGGER = Logger.getLogger(FaultInjectionEngine.class.getName());
    
    private FaultType activeFaultRule; // e.g., "SERVICE_UNAVAILABLE", "RATE_LIMITED", "BAD_GATEWAY"
    private boolean isInjectionEnabled;
    private String targetedServicePattern;

    public void initializeConfiguration(FaultType faultRule, boolean enabled, String servicePattern) {
        this.activeFaultRule = Objects.requireNonNull(faultRule, "Fault rule cannot be null");
        this.isInjectionEnabled = enabled;
        this.targetedServicePattern = servicePattern;
        LOGGER.log(Level.INFO, "Fault Engine reloaded: Rule={0}, Enabled={1}, Target={2}", 
            new Object[]{faultRule, enabled, servicePattern});
    }

    public ProxyResponse processFaultRules(ProxyResponse originalResponse, String inboundRequestPath) {
        ErrorPayLoadBuilder errorPayLoadBuilder = new ErrorPayLoadBuilder();
        if (!isInjectionEnabled || isRouteMatchingGuardClause(targetedServicePattern)) {
            return originalResponse;
        }
        LOGGER.log(Level.WARNING, "Intercepting matching traffic! Applying active simulation rule: {0}", activeFaultRule);
        return faultType.createResponse(originalResponse);
    }
    bool isRouteMatchingGuardClause(String inboundRequestPath){
      if (inboundRequestPath == null || !inboundRequestPath.contains(targetedServicePattern)){ 
         LOGGER.log(Level.FINE, "Request path {0} bypassed fault injection rules.", inboundRequestPath);
         return true;
      }
      else{
        return false;
      } 
    }
}

public class ProxyTrafficOrchestrator {
    private final FaultInjectionEngine faultEngine;

    public ProxyTrafficOrchestrator() {
        // The core orchestrator instantiates the engine
        this.faultEngine = new FaultInjectionEngine();
        
        // Configured with rules loaded from a control plane, DB, or JSON file
        this.faultEngine.initializeConfiguration("RATE_LIMITED", true, "/api/v1/banking");
    }

    // Invoked for every incoming network request/response cycle
    public ProxyResponse handleIncomingTraffic(String currentPath, ProxyResponse interceptedResponse) {
        
        // Orchestrator coordinates the lifecycle and passes execution to the engine
        ProxyResponse finalizedResponse = faultEngine.processFaultRules(interceptedResponse, currentPath);
        
        return finalizedResponse;
    }
}
