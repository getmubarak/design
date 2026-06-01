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

public class DialogFactory implements Visitor
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
  Dialog getDialog()
  {
    return d;
  }
}
public class Entry {
	static void main(){
		Account account = new SA();

		DialogFactory factory = new DialogFactory();
		account.accept(factory);

		Dialog dlg=factory.getDialog();
		dlg.Display();			
	}
}
