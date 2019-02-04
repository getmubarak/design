package problem9;


public class Factory
{
  public Dialog get(SA a)
  {
    return new SADialog();
  }
  public Dialog get(CA a)
  {
    return new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();
    Dialog dlg=dlg.get(account);	
		dlg.Display();			
		
	}

	static void main()
	{
		Account account = new SA();
		ShowUI(account);
	}
}
