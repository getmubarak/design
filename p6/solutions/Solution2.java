interface Tax
{
	double compute(double amount)
}
public class Invoice {
	private Tax tax;
	private int itemCode;	
	private int qty;
	private double price;

	void setTax(Tax tax) {
		this.tax = tax;
	}
	void setItem(int code, int qty, double price){
		this.itemCode = code;
		this.qty = qty;
		this.price = price;
	}
	public double getTotal(){
		double amount = getSubtotal();
		amount += tax.compute(amount); 
		return amount;
	}
	private double getSubtotal(){		
		return qty * price; 
	}
}
class TaxStub implements Tax
{
	public double compute(double amount)
     {
		return 5.0;
	}
}
class InvoiceTest
{
	public void test1()
	{
		Tax tax = new TaxStub();
		Invoice invoice = new Invoice();
		invoice.setTax(tax); //<— di
		invoice.setItem(9,2,50.00);
		double amount = invoice.getTotal();
		assertTrue( amount == 105.0);
	}
} 

class TaxImp implements Tax
{
	private int taxType;
	
	public TaxImp(int taxType) {
		this.taxType = taxType;
	}

	public double compute(double amount)
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

Class TaxTest
{
	//unit test
	public void Tax1Test()
	{
		Tax t = new TaxImp(1);
		double taxAmount = t.compute(100); 
		assertTrue( taxAmount == 5.0);
	}
     //2 more test
}


class Entry
{
	public static void main(String args[])
	{
		Tax tax = new TaxImp(2);
		Invoice invoice = new Invoice();
		invoice.setTax(tax);//<— di
		invoice.setItem(101,2,50.50);
		double amount = invoice.getTotal();	
	}
}








