class LoanType{
    boolean isEligible(Customer c);
}
class HomeLoan extends LoanType {
    @Override
    boolean isEligible(Customer c) {
        return checkCollateral(c);
    }
    boolean checkCollateral(Customer c) { ... }
}

class PersonalLoan  extends LoanType {
    @Override
    boolean isEligible(Customer c) {
        return checkIncome(c);
    }
    boolean checkIncome(Customer c) { ... }
}

class Eligibility {
    LoanType loanType;
    void Eligibility( LoanType loanType){
      this.loanType = loanType;
    }
    boolean isEligible(Customer c){
        return checkKYC(c) && checkCreditScore(c) && loanType.isEligible(c);
    }
    
    boolean checkKYC(Customer c) { ... }
    boolean checkCreditScore(Customer c) { ... }
}

class EligibilitySalaried extends LoanEligibility {
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkSalarySlips(c);
    }
    boolean checkSalarySlips(Customer c) { ... }
}

class EligibilitySelfEmployed extends LoanEligibility {
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkBusinessDocuments(c);
    }
    boolean checkBusinessDocuments(Customer c) { ... }
}



Eligibility eligibility = new EligibilitySelfEmployed(new PersonalLoan());
result = eligibility.isEligible(c);


