class LoanEligibility {
    boolean isEligible(Customer c){
        return checkKYC(c) && checkCreditScore(c);
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

class HomeLoanEligibilitySalaried extends LoanEligibilitySalaried {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkCollateral(c);
    }
    boolean checkCollateral(Customer c) { ... }
}
class HomeLoanEligibilitySelfEmployed extends LoanEligibilitySelfEmployed {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkCollateral(c);
    }
    boolean checkCollateral(Customer c) { ... }
}
