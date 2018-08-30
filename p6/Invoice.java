package problem6;

public class Invoice {
	private int taxType;
	
	
	int getTaxType() {
		return taxType;
	}

	void setTaxType(int taxType) {
		this.taxType = taxType;
	}
	
	public double getTotal()
	{
		
		double amount = getSubtotal();
		
		switch(taxType)
		{
			case 1:
				amount += amount * 0.05;
				break;
			case 2:
				amount += amount * 0.025 + 500;
				break;
			case 3:
				amount += (amount- 5000) * 0.3;
				break;
		}
		return amount;
	}
	double getSubtotal()
	{
		double subtotal = 0;
		/* 
		 * foreach(lineItem in Items)
		 * {
		 * 		subtotal += lineItem.getPrice() * lineItem.Qty()
		 * }
		 */
		return subtotal;
	}

	
}
