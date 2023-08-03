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
	public Dialog CreateUI(){
		Dialog dlg=null;
		
		if(account instanceof SA) {
			dlg = new SADialog();
		}
		if(account instanceof CA) {
			dlg = new CADialog();
		}
		return new dlg;
	}
}

public class Entry {
	static void main(){
		Account account = new SA();
		DialogFactory factory = new DialogFactory();
		Dialog dlg=factory.createUI();
		if(dlg!=null) {
			dlg.Display();			
		}		
	}
}
