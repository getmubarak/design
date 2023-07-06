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
		Dialog dlg=null;
		Factory factory = new Factory();
                if(account instanceof SA) {
			dlg = factory.get((SA)account);
		}
		if(account instanceof CA) {
                        dlg = factory.get((CA)account);
		}
		if(dlg!=null) {
			dlg.Display();			
		}			
	}
	static void main(){
		Account account = new SA();
		ShowUI(account);
	}
}
