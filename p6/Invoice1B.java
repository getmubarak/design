
public class Invoice {

    public enum TaxType {
        KST,
        CST,
        GST
    }

    private TaxType taxType;

    // KST constants
    private static final double KST_RATE = 0.05;
    private static final double KST_THRESHOLD = 1000;

    // CST constants
    private static final double CST_RATE = 0.025;
    private static final double CST_FIXED_FEE = 500;

    // GST constants
    private static final double GST_THRESHOLD = 5000;
    private static final double GST_RATE_BELOW_THRESHOLD = 0.3;
    private static final double GST_RATE_ABOVE_THRESHOLD = 0.4;

    void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    boolean isKSTApplicable(double amount) {
        return amount > KST_THRESHOLD;
    }

    boolean isBelowGSTThreshold(double amount) {
        return amount < GST_THRESHOLD;
    }

    public double getTotal() {
        double amount = getSubtotal();

        switch (taxType) {
            case KST:
                if (isKSTApplicable(amount)) {
                    amount += amount * KST_RATE;
                }
                break;

            case CST:
                amount += amount * CST_RATE + CST_FIXED_FEE;
                break;

            case GST:
                if (isBelowGSTThreshold(amount)) {
                    amount += (amount - GST_THRESHOLD) * GST_RATE_BELOW_THRESHOLD;
                } else {
                    amount += (amount - GST_THRESHOLD) * GST_RATE_ABOVE_THRESHOLD;
                }
                break;
        }

        return amount;
    }

    double getSubtotal() {
        double subtotal = 0;

        for (LineItem lineItem : Items) {
            subtotal += lineItem.getPrice() * lineItem.getQty();
        }

        return subtotal;
    }
}
