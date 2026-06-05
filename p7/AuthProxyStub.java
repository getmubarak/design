// Root Base matching your LoanEligibility
class BaseAuthProxyStub {
    boolean validateIdentityContext(Request req) {
        return verifyGatewaySignature(req) && checkIpAllowlist(req);
    }
    boolean verifyGatewaySignature(Request req) { return true; }
    boolean checkIpAllowlist(Request r) { return true; }
}

// --- DIMENSION 1: IDENTITY PROVIDER TYPE ---
class OktaAuthStub extends BaseAuthProxyStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && verifyOktaTenant(req);
    }
    boolean verifyOktaTenant(Request req) { return true; }
}

class PingIdentityAuthStub extends BaseAuthProxyStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && verifyPingDomain(req);
    }
    boolean verifyPingDomain(Request req) { return true; }
}

// --- DIMENSION 2: SECURITY TOKEN FORMAT ---
class OktaJwtAuthStub extends OktaAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && parseAndVerifyJwt(req);
    }
    boolean parseAndVerifyJwt(Request req) { return true; }
}
class PingIdentityJwtAuthStub extends PingIdentityAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && parseAndVerifyJwt(req);
    }
    boolean parseAndVerifyJwt(Request req) { return true; }
}

class OktaSaml2AuthStub extends OktaAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && validateSamlAssertion(req);
    }
    boolean validateSamlAssertion(Request req) { return true; }
}
class PingIdentitySaml2AuthStub extends PingIdentityAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && validateSamlAssertion(req);
    }
    boolean validateSamlAssertion(Request req) { return true; }
}

// --- DIMENSION 3: COMPLIANCE POLICIES ---
class OktaJwtHipaaAuthStub extends OktaJwtAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && enforcePhiEncryption();
    }
    boolean enforcePhiEncryption() { return true; }
}
class PingIdentityJwtHipaaAuthStub extends PingIdentityJwtAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && enforcePhiEncryption();
    }
    boolean enforcePhiEncryption() { return true; }
}

class OktaJwtPciAuthStub extends OktaJwtAuthStub {
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && maskCreditCardData();
    }
    boolean maskCreditCardData() { return true; }
}
// SMELL: Copy-paste inheritance error!
// The developer accidentally inherited from the "Okta" tree while defining PingIdentity!
class PingIdentityJwtPciAuthStub extends OktaJwtAuthStub { 
    @Override
    boolean validateIdentityContext(Request req) {
        return super.validateIdentityContext(req) && maskCreditCardData();
    }
    boolean maskCreditCardData() { return true; }
}
