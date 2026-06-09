package problem5;

// ==================== CORE PROXY DOMAIN LAYER ====================
interface NetworkPayload {
    void parseHeaders();
    void extractBodyText();
}

class JsonPayload implements NetworkPayload {
    public void parseHeaders() { System.out.println("Reading JSON Content-Type headers."); }
    public void extractBodyText() { System.out.println("Extracting raw flat JSON payload body string."); }
}

class XmlPayload implements NetworkPayload {
    public void parseHeaders() { System.out.println("Reading XML SOAPAction headers."); }
    public void extractBodyText() { System.out.println("Extracting structured XML DOM node payload."); }
}

// ==================== COUPLING CLIENT LAYER ====================
class SecurityComplianceScanner {
    // Overloaded method tailored specifically for JSON data parsing structures
    void scanTraffic(JsonPayload json) { 
        System.out.println("[Security Engine]: Executing OWASP JSON injection threat checks."); 
    }
    
    // Overloaded method tailored specifically for XML data parsing structures
    void scanTraffic(XmlPayload xml) { 
        System.out.println("[Security Engine]: Executing XML External Entity (XXE) vulnerability checks."); 
    }
}

// ==================== CORE GATEWAY ROUTER ====================
public class ProxyGateway {
    
    void processIncomingTraffic(NetworkPayload payload) {
        payload.parseHeaders();     // Works perfectly via single polymorphism
        payload.extractBodyText();  // Works perfectly via single polymorphism
        
        SecurityComplianceScanner scanner = new SecurityComplianceScanner();
        
        // COMPILE ERROR POINT: The compiler only knows that 'payload' is a generic NetworkPayload.
        // It cannot automatically guess whether to invoke scanTraffic(JsonPayload) or scanTraffic(XmlPayload).
        // scanner.scanTraffic(payload); 
    }
}
