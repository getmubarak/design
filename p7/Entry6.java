interface EligibilityCheck {
    boolean evaluate(Customer c);
}
class CreditScoreCheck implements EligibilityCheck {
   boolean evaluate(Customer c){
           ... evaluation logic...
  }
}
class AdditionalCheck implements EligibilityCheck {
  EligibilityCheck ref;
  AdditionalCheck(EligibilityCheck ref){ this.ref = ref; } 
}
class KYCCheck extends AdditionalCheck { 
        boolean evaluate(Customer c){
           if(!ref.evaluate(c))
              return false;
           ... evaluation logic...
        }
}
class SalarySlipCheck extends AdditionalCheck { ... }
class CollateralCheck extends AdditionalCheck { ... }
class AadhaarCheck extends AdditionalCheck { ... }
class SSNCheck extends AdditionalCheck { ... }

class EligibilityEngine {
    EligibilityCheck checks= new AadhaarCheck(
     new CollateralCheck(
       new SalarySlipCheck(
         new KYCCheck(
           new CreditScoreCheck()))));
    boolean evaluate(Customer c) {
        return checks.evaluate(c);
    }
}
