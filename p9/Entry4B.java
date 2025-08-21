package problem9;
//-------------------- domain layer ------------------------------
interface Visitor{
 void visitSA();
 void visitCA();
}
interface Account{
	void accept(Visitor v);
}
class SA extends Account{
	void accept(Visitor v) { v.visitSA(); }
}
class CA extends Account{
	void accept(Visitor v) { v.visitCA(); }
}
//-------------------- boundary layer ---------------------------
class Dialog{
}
class SADilaog extends Dialog{
}
class CADialog extends Dialog{
}

public class Factory implements Visitor
{
  Dialog d;
  public void visitSA()
  {
     d = new SADialog();
  }
  public void visitCA()
  {
     d = new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {

		Factory factory = new Factory();
		account.accept(factory);

		Dialog dlg=factory.getDialog();
		dlg.Display();			
	}
	static void main(){
		Account account = new SA();
		ShowUI(account);
	}
}
