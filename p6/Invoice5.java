package problem6;

public class Invoice {
	private Function tax; 
	
	public void setTaxType(Function tax) { //<-- DI
		this.tax = tax;
	}	
	public double getTotal()
	{	
		double amount = getSubtotal();
	        amount += tax(amount);
		return amount;
	}
	double getSubtotal(){
		...
	}	
}
class CentralTax 
{ 
  public double computeKST(double amount){
      return amount * 0.05;
  }
  public double computeGST(double amount){
     return amount * 0.025 + 500;
  }
  public double computeCST(double amount){
    	return (amount- 5000) * 0.3;
  }
}
class StateTax  
{ 
  ...
}
class InternationalTax  
{ 
  ...
}
Invoice inv = new Invoice();
CentralTax tax = new  CentralTax();
inv.setTax((amount)->tax.computeKST(amount));
...
amount = inv.getTotal();
