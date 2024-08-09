package problem9;

interface Account{}
class CA : Account{}
class SA : Account{}

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

public class DialogFactory{
	public Dialog CreateUI(Account account){
		Dialog dlg=null;
		
		if(account instanceof SA) {
			dlg = new SADialog();
		}else if(account instanceof CA) {
			dlg = new CADialog();
		}else{
                    throw new InvalidDomainObjectExpection();
                }

		return dlg;
	}
}

public class Entry {
	static void main(){
		Account account = new SA();
		DialogFactory factory = new DialogFactory();
		Dialog dlg=factory.createUI(account);
		dlg.Display();			
	}
}
