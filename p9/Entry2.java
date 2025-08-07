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
public class DialogFactory
{
  public Dialog createUI(SA a){
    return new SADialog();
  }
  public Dialog createUI(CA a){
    return new CADialog();
  }
}
public class Entry {
	static void main(){
		Account account = new SA();
		Factory factory = new Factory();
                Dialog dlg=factory.createUI(account);	
		dlg.Display();			
	}
}
