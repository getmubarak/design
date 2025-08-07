interface Account{}
class CA : Account{}
class SA : Account{}

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

public class Entry {
  Map<string,Lambda> lookup = new Map<string,Lambda>();
  public Entry(){
    lookup.add(SA.getName(),()->new SADialog());
    lookup.add(CA.getName(),()->new CADialog());
  }
	public static void ShowUI(Account account) {
		Lambda creatorMethod =lookup.get(account.getName());
                Dialog d = creatorMethod();
		dlg.Display();			
	}
	
	static void main()
	{
		Account account = new SA();
		ShowUI(account);
		
	}
}
