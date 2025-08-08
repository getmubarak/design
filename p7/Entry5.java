interface EligibilityCheck {
    boolean evaluate(Customer c);
}

class KYCCheck implements EligibilityCheck { ... }
class CreditScoreCheck implements EligibilityCheck { ... }
class SalarySlipCheck implements EligibilityCheck { ... }
class CollateralCheck implements EligibilityCheck { ... }
class AadhaarCheck implements EligibilityCheck { ... }
class SSNCheck implements EligibilityCheck { ... }

class Factory{
    DecisionTable table = new DecisionTable();
    Factory(){
        table.add(LoanType.HomeLoan, IncomeType.Salaried, getElibilitiesForHomeLoanSalaried());
        table.add(LoanType.HomeLoan, IncomeType.Business, getElibilitiesForHomeLoanBusiness());
        table.add(LoanType.PersonelLoan, IncomeType.Salaried, getElibilitiesForPersonelLoanSalaried());
        table.add(LoanType.PersonelLoan, IncomeType.Business, getElibilitiesForPersonelLoanBusiness());
    }
    public getElibilitieChecks(LoanType, IncomeType){
        return table.get(LoanType,IncomeType);
    }
    private List<EligibilityCheck> getElibilitiesForHomeLoanSalaried(){
        return List.of(
            new KYCCheck(),
            new CreditScoreCheck(),
            new SalarySlipCheck(),
            new AadhaarCheck()
        );
    }
    private List<EligibilityCheck> getElibilitiesForHomeLoanBusiness(){    
        return List.of(
            new KYCCheck(),
            new CreditScoreCheck(),
            new CollateralCheck(),
            new AadhaarCheck()
        );
     }
    private List<EligibilityCheck> getElibilitiesForPersonelLoanBusiness();
}

class Client{
    void Main()
    {
        Customer customer ...;
        LoanRequest loanRequet = ...
        Factory factory = new Factory();
        List<EligibilityCheck> checks= factory.getElibilitieChecks(loanRequet.LoanType, customer.IncomeType);
        
        bool resutl= checks.stream().allMatch(check -> check.evaluate(c));
    }
}
