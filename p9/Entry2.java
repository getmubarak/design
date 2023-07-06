package problem9;

interface Account{}
class CA : Account{}
class SA : Account{}

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

//--------------------
public class Factory
{
  public Dialog get(SA a){
    return new SADialog();
  }
  public Dialog get(CA a){
    return new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();
                Dialog dlg=factory.get(account);	
		dlg.Display();			
	}
	static void main(){
		Account account = new SA();
		ShowUI(account);
	}
}
