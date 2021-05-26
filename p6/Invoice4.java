package problem6;

interface Tax
{
 	double compute(double amount);
}
public class Invoice {
	private Tax tax; 
	
	public void setTaxType(Tax tax) { //<-- DI
		this.tax = tax;
	}	
	public double getTotal()
	{	
		double amount = getSubtotal();
	        amount += tax.Compute(amount);
		return amount;
	}
	double getSubtotal(){
		...
	}	
}
class KST  implements Tax
{ 
  public double compute(double amount){
      return amount * 0.05;
  }
}
class GST  implements Tax
{ 
   public double compute(double amount){
     return amount * 0.025 + 500;
  }
}
class CST  implements Tax
{ 
    public double compute(double amount){
    	return (amount- 5000) * 0.3;
  }
}

Invoice inv = new Invoice();
inv.setTax(new GST());
...
amount = inv.getTotal();
