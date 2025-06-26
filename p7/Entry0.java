class LoanEligibility {
    boolean isEligible(Customer c) {
        return true; // Default always eligible
    }
}

class HomeLoanEligibility extends LoanEligibility {
    @Override
    boolean isEligible(Customer c) {
        return checkKYC(c) && checkCreditScore(c) && checkCollateral(c);
    }

    boolean checkKYC(Customer c) { ... }
    boolean checkCreditScore(Customer c) { ... }
    boolean checkCollateral(Customer c) { ... }
}

class PersonalLoanEligibility extends LoanEligibility {
    @Override
    boolean isEligible(Customer c) {
        return checkKYC(c) && checkCreditScore(c) && checkIncome(c);
    }

    boolean checkIncome(Customer c) { ... }
}

class HomeLoanEligibilityUS extends HomeLoanEligibility {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkSocialSecurityNumber(c);
    }

    boolean checkSocialSecurityNumber(Customer c) { ... }
}

class HomeLoanEligibilityIndia extends HomeLoanEligibility {
    @Override
    boolean isEligible(Customer c) {
        return super.isEligible(c) && checkAadhaar(c);
    }

    boolean checkAadhaar(Customer c) { ... }
}

