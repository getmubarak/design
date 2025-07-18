
interface LoanType{
   boolean isEligible(Customer c);
}
class HomeLoan extends LoanType {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkCollateral(c);
    }
    boolean checkCollateral(Customer c) { ... }
}

class PersonalLoan extends LoanType {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkIncome(c);
    }
    boolean checkIncome(Customer c) { ... }
}

class LoanEligibility {
    LoanType loanType;
   
    boolean isEligible(Customer c){
        return checkKYC(c) && checkCreditScore(c) & loanType.isEligible(c);
    }
    
    boolean checkKYC(Customer c) { ... }
    boolean checkCreditScore(Customer c) { ... }
}

class LoanEligibilitySalaried extends LoanEligibility {
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkSalarySlips(c);
    }
    boolean checkSalarySlips(Customer c) { ... }
}

class LoanEligibilitySelfEmployed extends LoanEligibility {
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkBusinessDocuments(c);
    }
    boolean checkBusinessDocuments(Customer c) { ... }
}

LoanEligibility lec = new LoanEligibilitySalaried(PersonalLoan());
bool eligiblity = lec.isEligible(customer);



