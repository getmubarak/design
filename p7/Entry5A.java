interface EligibilityCheck {
    boolean evaluate(Customer c);
}

class KYCCheck implements EligibilityCheck { ... }
class CreditScoreCheck implements EligibilityCheck { ... }
class SalarySlipCheck implements EligibilityCheck { ... }
class CollateralCheck implements EligibilityCheck { ... }
class AadhaarCheck implements EligibilityCheck { ... }
class SSNCheck implements EligibilityCheck { ... }

//*******************************************************************************
Config
<Checks>
  <check name"KYC"/>
  <check name"CreditScore"/>
  ...
</checks>  
  
class Factory{
    Lookup lookup = new Lookup();
    Factory(){
        lookup.add("KYC",new KYCCheck() );
        lookup.add("CreditScore",new CreditScoreCheck() );
        ....
      }
    public getElibilitieChecks(Config config){
        List<EligibilityCheck> checks = new EligibilityCheck();
        foreach(Item item in config){
          checks.add(lookup.get(item));
        }
        return checks;
    }
}

class Client{
    void Main()
    {
        Customer customer ...;
        Factory factory = new Factory();
        List<EligibilityCheck> checks= factory.getElibilitieChecks(config);
        bool resutl= checks.stream().allMatch(check -> check.evaluate(c));
    }
}
