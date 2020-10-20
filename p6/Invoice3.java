package problem6;

interface Tax
{
 	double compute(double amount);
}
public class Invoice {
	private Tax tax;	

	public void setTaxType(Tax tax) {
		this.tax = tax;
	}	
	public double getTotal()
	{
		
		double amount = getSubtotal();
	        amount += tax.Compute(amount);
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
class TaxImp  implements Tax
{ 
   int taxType;

  public TaxImp(int taxType)
  {
        this.taxType = taxType;
  }
  public double compute(double amount){
      double taxAmount =0;
  
      switch(taxType)
      {
        case 1:
          taxAmount = amount * 0.05;
          break;
        case 2:
          taxAmount= amount * 0.025 + 500;
          break;
        case 3:
          taxAmount= (amount- 5000) * 0.3;
          break;
      }
      return taxAmount;
  }
  
}

