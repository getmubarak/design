import java.util.HashMap;
import java.util.Map;

public class NetworkTrafficHandler {
    private String matchingStrategy; // "Exact", "HeaderAware", "BodyHash"
    private String trafficData;      // Simulates stored mock rule format

    public NetworkTrafficHandler(String matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public String getReplayedResponse() {
        return processIncomingRequest(trafficData);
    }

    public void setTrafficData(String rawTraffic) {
        this.trafficData = matchAndRecord(rawTraffic);
    }

    // SIMULATED RECORDING / RULE COMPILATION STEP
    private String matchAndRecord(String data) {
        if (matchingStrategy.equalsIgnoreCase("Exact")) {
            System.out.println("Processing recording using Exact String Matching...");
            
            // Real Logic: Split simple payload into key components
            // Expected input format: "METHOD|PATH|BODY" -> e.g., "POST|/api/user|{'id':1}"
            String[] parts = data.split("\\|", 3);
            String path = parts[1];
            
            // Returns a hardcoded route configuration string
            return "ROUTE:" + path + "->HTTP_200_OK";
        } 
        else if (matchingStrategy.equalsIgnoreCase("HeaderAware")) {
            System.out.println("Processing recording using Header-Aware Matching...");
            
            // Real Logic: Parse a pseudo header string "Key:Value,Key:Value"
            Map<String, String> simulatedHeaders = new HashMap<>();
            String[] pairs = data.split(",");
            for (String pair : pairs) {
                String[] kv = pair.split(":");
                if (kv.length == 2) simulatedHeaders.put(kv[0].trim(), kv[1].trim());
            }
            
            // Returns a rule tied tightly to an authorization state
            return "AUTH_REQUIRED:" + simulatedHeaders.getOrDefault("Authorization", "MISSING");
        }
        else if (matchingStrategy.equalsIgnoreCase("BodyHash")) {
            System.out.println("Processing recording using Body MD5/SHA Hash Matching...");
            
            // Real Logic: Generate a deterministic Hash Code of the payload string
            int hash = data.hashCode();
            
            // Returns a mapping linked solely to the unique payload fingerprint
            return "HASH_RULE:" + hash + "->MOCK_PAYLOAD";
        }
        
        return data;
    }

    // SIMULATED REPLAY / EXECUTION STEP
    private String processIncomingRequest(String compiledData) {
        if (matchingStrategy.equalsIgnoreCase("Exact")) {
            System.out.println("Replaying response for Exact Match rule...");
            
            if (compiledData != null && compiledData.startsWith("ROUTE:")) {
                String targetRoute = compiledData.substring(6);
                return "{ \"status\": \"Success\", \"matchedOn\": \"" + targetRoute + "\" }";
            }
            return "{ \"error\": \"Exact route mismatch\" }";
        } 
        else if (matchingStrategy.equalsIgnoreCase("HeaderAware")) {
            System.out.println("Replaying response for Header-Aware rule...");
            
            if (compiledData != null && compiledData.contains("MISSING")) {
                return "{ \"httpStatus\": 401, \"error\": \"Unauthorized Context Found\" }";
            }
            return "{ \"httpStatus\": 200, \"data\": \"Secure Virtualized Data\" }";
        }
        else if (matchingStrategy.equalsIgnoreCase("BodyHash")) {
            System.out.println("Replaying response for Body Hash rule...");
            
            if (compiledData != null && compiledData.startsWith("HASH_RULE:")) {
                // Extracts the computed hash identifier back out
                String systemHash = compiledData.split("->")[0];
                return "{ \"cachedId\": \"" + systemHash + "\", \"bodyMatch\": true }";
            }
            return "{ \"error\": \"Payload body altered, hash validation failed\" }";
        }
        
        return "{ \"httpStatus\": 404, \"message\": \"Strategy Not Supported\" }";
    }     

    // Demo/Verification execution
    public static void main(String[] args) {
        System.out.println("--- TESTING EXACT MATCH SMELL ---");
        NetworkTrafficHandler exactHandler = new NetworkTrafficHandler("Exact");
        exactHandler.setTrafficData("POST|/api/v1/payments|{}");
        System.out.println("Result: " + exactHandler.getReplayedResponse() + "\n");

        System.out.println("--- TESTING HEADER AWARE SMELL ---");
        NetworkTrafficHandler headerHandler = new NetworkTrafficHandler("HeaderAware");
        headerHandler.setTrafficData("Authorization:BearerExpiredToken,Content-Type:application/json");
        System.out.println("Result: " + headerHandler.getReplayedResponse() + "\n");

        System.out.println("--- TESTING BODY HASH SMELL ---");
        NetworkTrafficHandler hashHandler = new NetworkTrafficHandler("BodyHash");
        hashHandler.setTrafficData("{ \"user\": \"alice\", \"action\": \"login\" }");
        System.out.println("Result: " + hashHandler.getReplayedResponse());
    }
}
