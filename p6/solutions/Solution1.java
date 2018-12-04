public class Invoice {
	private int taxType;	
	
	int getTaxType() {
		return taxType;
	}
	void setTaxType(int taxType) {
		this.taxType = taxType;
	}
	public double getTotal(){
		
		double amount = getSubtotal();
		Tax tax = new Tax();
		amount += tax.compute(amount,taxType); 
		return amount;
	}
	double getSubtotal(){
		double subtotal = 0;
		/* foreach(lineItem in Items)
		 * {
		 * 		subtotal += lineItem.getPrice() * lineItem.Qty()
		 * } */
		return subtotal;
	}
}
class Tax
{
	public double compute(double amount, int taxType)
     {
		double taxAmount = 0;
		switch(taxType)
		{
			case 1:
				taxAmount = amount * 0.05;
				break;
			case 2:
				taxAmount = amount * 0.025 + 500;
				break;
			case 3:
				taxAmount = (amount- 5000) * 0.3;
				break;
		}
		return taxAmount;
	} 
} 

