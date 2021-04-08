package problem9;

interface Plugin{
	void doSA();
	void doCA();
}

interface Account{
	void invoke(Plugin p);
}
class SA extends Account{
	void invoke(Plugin p){
		p.doSA();
	}
}
class CA extends Account{
	void invoke(Plugin p){
		p.doCA();
	}
}
//--------------------
class Dialog{
}
class SADilaog extends Dialog{
}
class CADialog extends Dialog{
}
//--------------------
public class Factory implements Plugin
{
  Dialog dialog;
  public void doSA()
  {
    dialog= new SADialog();
  }
  public void doCA()
  {
    dialog= new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();
		factory.do?();
		account.invoke(factory);
                Dialog dlg=factory.getDialog();	
		dlg.Display();			
	}
	static void main(){
		Account account = new SA();
		ShowUI(account);
	}
}
