package problem9;

public class Entry {
	public static void ShowUI(Account account) {
		Dialog dlg=null;
		
		if(account instanceof SA) {
			dlg = new SADialog();
		}
		if(account instanceof CA) {
			dlg = new CADialog();
		}
		if(dlg!=null) {
			dlg.Display();			
		}
	}
	
	static void main()
	{
		Account account = new SA();
		ShowUI(account);
		
	}
}
