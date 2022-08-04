
interface Account{}
class CA : Account{}
class SA : Account{}

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

public class Entry {
  Map<string,Dialog> lookup = new Map<string,Dialog>();
  public Entry(){
    lookup.add(SA.getName(),new SADialog());
    lookup.add(CA.getName(),new CADialog());
  }
	public static void ShowUI(Account account) {
		Dialog dlg=lookup.get(account.getName()).clone();
		dlg.Display();			
	}
	
	static void main()
	{
		Account account = new SA();
		ShowUI(account);
		
	}
}
