package problem6;

public class Entry {
	public static void main()
	{
		Invoice inv = new Invoice();
		inv.setTaxType(2);
		//inv.add(new LineItem(101,3));
		//inv.add(new LineItem(102,2));
		//inv.add(new LineItem(103,3));
		//inv.add(new LineItem(104,1));
		double total = inv.getTotal();
	}
}
