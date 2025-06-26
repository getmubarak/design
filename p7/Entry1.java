interface EligibilityCheck {
    boolean evaluate(Customer customer);
}

class KYCCheck implements EligibilityCheck { ... }
class CreditScoreCheck implements EligibilityCheck { ... }
class CollateralCheck implements EligibilityCheck { ... }
class AadhaarCheck implements EligibilityCheck { ... }
class SSNCheck implements EligibilityCheck { ... }


List<EligibilityCheck> indiaHomeLoanChecks = List.of(
    new KYCCheck(),
    new CreditScoreCheck(),
    new CollateralCheck(),
    new AadhaarCheck()
);

List<EligibilityCheck> usHomeLoanChecks = List.of(
    new KYCCheck(),
    new CreditScoreCheck(),
    new CollateralCheck(),
    new SSNCheck()
);
