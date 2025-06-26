interface EligibilityCheck {
    boolean evaluate(Customer c);
}

class KYCCheck implements EligibilityCheck { ... }
class CreditScoreCheck implements EligibilityCheck { ... }
class SalarySlipCheck implements EligibilityCheck { ... }
class CollateralCheck implements EligibilityCheck { ... }
class AadhaarCheck implements EligibilityCheck { ... }
class SSNCheck implements EligibilityCheck { ... }


List<EligibilityCheck> checks = List.of(
    new KYCCheck(),
    new CreditScoreCheck(),
    new SalarySlipCheck(),
    new CollateralCheck(),
    new AadhaarCheck()
);

class EligibilityEngine {
    List<EligibilityCheck> checks;
    boolean evaluate(Customer c) {
        return checks.stream().allMatch(check -> check.evaluate(c));
    }
}
