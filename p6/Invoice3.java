package problem6;

interface Tax
{
 	double compute(double amount);
}
public class Invoice {
	private Tax tax= new TaxImp();
	
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
      return taxAmount;
  }
  
}

