package problem6;

class Tax
{ 
  public static double compute(int taxType, double amount){ 
      switch(taxType)
      {
	case 1:
		if(amount > 1000)
			amount += amount * 0.05;
		break;
	case 2:
		amount += amount * 0.025 + 500;
		break;
	case 3:
		if(amount < 1000)
			amount += (amount- 5000) * 0.3;
		else
			amount += (amount- 5000) * 0.4;
		break;
      }
      return amount;
  }
  
}

public class Invoice {
	private int taxType;
        private Items = List<InvoiceLineItem>();
	
	
	public int getTaxType() {
		return taxType;
	}

	public void setTaxType(int taxType) {
		this.taxType = taxType;
	}
	
	public double getTotal()
	{
		
		double amount = getSubtotal();
	        amount = Tax.compute(taxType,amount);
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
class InvoiceLineItem{
   ...
}
