//***************************  domain ***********************

interface Account{}
class CA : Account{}
class SA : Account{}

//***************************  User interface ***********************

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

public class DialogFactory{
	Map<string,Dialog> lookup = new Map<string,Dialog>();
	public DialogFactory(){
		lookup.add(SA.getName(),new SADialog());
		lookup.add(CA.getName(),new CADialog());
	}
	public Dialog CreateUI(Account account){
		return =lookup.get(account.getName()).clone();;
	}
}

public class Entry {
	static void main(){
		Account account = new SA();
		DialogFactory factory = new DialogFactory();
		Dialog dlg=factory.createUI(account);
		if(dlg!=null) {
			dlg.Display();			
		}		
}
