// Owned by the orchestrator side
interface ResponseInterceptor {
    ProxyResponse intercept(String requestPath, ProxyResponse response);
}

class ProxyTrafficOrchestrator {
    private final List<ResponseInterceptor> interceptors;

    ProxyTrafficOrchestrator(List<ResponseInterceptor> interceptors) {
        this.interceptors = List.copyOf(interceptors);
    }

    ProxyResponse handleIncomingTraffic(String path, ProxyResponse response) {
        ProxyResponse result = response;
        for (ResponseInterceptor interceptor : interceptors) {
            result = interceptor.intercept(path, result);
        }
        return result;
    }
}

// Fault component: implements the interface, knows nothing about the orchestrator
class FaultInjectionEngine implements ResponseInterceptor {
    FaultInjectionEngine(String faultRule, boolean enabled, String servicePattern) { ... }

    @Override
    public ProxyResponse intercept(String path, ProxyResponse response) {
        // existing processFaultRules logic
    }
}

// Composition root: the only place that knows both
FaultInjectionEngine engine = new FaultInjectionEngine("RATE_LIMITED", true, "/api/v1/banking");
ProxyTrafficOrchestrator proxy = new ProxyTrafficOrchestrator(List.of(engine));
