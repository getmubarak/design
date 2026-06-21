import java.util.List;

// Represents a captured HTTP interaction inside the proxy engine
class TrafficLog {
    public String method;
    public String url;
    public int statusCode;
    public String responseBody;

    public TrafficLog(String method, String url, int statusCode, String responseBody) {
        this.method = method;
        this.url = url;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
}

public class ProxyStubExporter {
    // Protected internal document collection, matching your 'reportDocument'
    protected List<TrafficLog> capturedTraffic;

    public void captureSessionTraffic() {
        // ... Core logic that fetches recorded interactions from the in-memory engine cache
    }
        
    public String exportRecordings(String format) {
        switch(format.toLowerCase()) {
            case "json":
                StringBuilder json = new StringBuilder("[\n");
                for (TrafficLog log : capturedTraffic) {
                    json.append("  {\n")
                        .append("    \"request\": \"").append(log.method).append(" ").append(log.url).append("\",\n")
                        .append("    \"responseStatus\": ").append(log.statusCode).append("\n")
                        .append("  },\n");
                }
                json.append("]");
                return json.toString();

            case "yaml": 
                StringBuilder yaml = new StringBuilder("--- \nstubs:\n");
                for (TrafficLog log : capturedTraffic) {
                    yaml.append("  - request:\n")
                        .append("      method: ").append(log.method).append("\n")
                        .append("      url: ").append(log.url).append("\n")
                        .append("    response:\n")
                        .append("      status: ").append(log.statusCode).append("\n");
                }
                return yaml.toString();

            case "xml":
                StringBuilder xml = new StringBuilder("<mappings>\n");
                for (TrafficLog log : capturedTraffic) {
                    xml.append("  <stub>\n")
                       .append("    <url>").append(log.url).append("</url>\n")
                       .append("    <status>").append(log.statusCode).append("</status>\n")
                       .append("  </stub>\n");
                }
                xml.append("</mappings>");
                return xml.toString();
                
             case "csv":
                StringBuilder csv = new StringBuilder("Method,URL,StatusCode\n");
                for (TrafficLog log : capturedTraffic) {
                    csv.append(log.method).append(",")
                       .append(log.url).append(",")
                       .append(log.statusCode).append("\n");
                }
                return csv.toString();
        }
        throw new IllegalArgumentException("Unsupported proxy export format: " + format);
    }
}
