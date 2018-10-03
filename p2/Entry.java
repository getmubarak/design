package problem2;

public class Entry {
	public static void main()
	{
		AccountService a = new AccountService();
		a.withDraw(500);
		a.deposit(7000);
		a.withDraw(567);
		a.deposit(6784);
		a.withDraw(23);
		a.withDraw(34);
		a.undo();
		a.undo();
	}
}
