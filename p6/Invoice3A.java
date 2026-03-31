package problem6;

interface Tax
{
 	double compute(double amount);
}

public class Invoice {
	Tax tax;
    private Items = List<InvoiceLineItem>();

	public Invoice(Tax tax){
		this.tax = tax;
	}
	
	public double getTotal()
	{
		double amount = getSubtotal();
	    double taxAmount = tax.compute(taxType,amount);
		return amount + taxAmount;
	}
	double getSubtotal()
	{
		double subtotal = 0;
		 
		foreach(lineItem in Items)
		{
				subtotal += lineItem.getPrice() * lineItem.Qty()
		}
		return subtotal;
	}

	
}
class InvoiceLineItem{
   ...
}
//****************************************************************

public enum TaxType {
        KST,
        CST,
        GST
}
class TaxImp implements Tax
{ 
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
    
	private TaxType taxType;
	public void Tax(TaxType taxType) {
		this.taxType = taxType;
	}
	boolean isKSTApplicable(double amount) {
        return amount > KST_THRESHOLD;
    }

    boolean isBelowGSTThreshold(double amount) {
        return amount < GST_THRESHOLD;
    }
    public double compute(int taxType, double amount){ 
		double taxAmount=0;
        switch (taxType) {
            case KST:
                if (isKSTApplicable(amount)) {
                    taxAmount= amount * KST_RATE;
                }
                break;

            case CST:
                taxAmount= amount * CST_RATE + CST_FIXED_FEE;
                break;

            case GST:
                if (isBelowGSTThreshold(amount)) {
                    taxAmount += (amount - GST_THRESHOLD) * GST_RATE_BELOW_THRESHOLD;
                } else {
                    taxAmount += (amount - GST_THRESHOLD) * GST_RATE_ABOVE_THRESHOLD;
                }
                break;
        }
		return taxAmount;
	}
}
