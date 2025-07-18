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

class PersonalLoanEligibilitySalaried extends LoanEligibilitySalaried {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkIncome(c);
    }
    boolean checkIncome(Customer c) { ... }
}
class PersonalLoanEligibilitySelfEmployed extends LoanEligibilitySelfEmployed {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkIncome(c);
    }
    boolean checkIncome(Customer c) { ... }
}

class HomeLoanEligibilitySalariedUS extends HomeLoanEligibilitySalaried {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkSocialSecurityNumber(c);
    }

    boolean checkSocialSecurityNumber(Customer c) { ... }
}
class HomeLoanEligibilitySelfEmployedUS extends LoanEligibilitySelfEmployed {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkSocialSecurityNumber(c);
    }

    boolean checkSocialSecurityNumber(Customer c) { ... }
}

class HomeLoanEligibilitySalariedIndia extends HomeLoanEligibilitySalaried {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkAadhaar(c);
    }

    boolean checkAadhaar(Customer c) { ... }
}
class HomeLoanEligibilitySelfEmployedIndia extends HomeLoanEligibilitySelfEmployed {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkAadhaar(c);
    }

    boolean checkAadhaar(Customer c) { ... }
}
