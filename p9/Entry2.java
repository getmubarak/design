package problem9;
class Account{
}
class SA extends Account{
}
class CA extends Account{
}
//--------------------
class Dialog{
}
class SADilaog extends Dialog{
}
class CADialog extends Dialog{
}
//--------------------
public class Factory
{
  public Dialog get(SA a)
  {
    return new SADialog();
  }
  public Dialog get(CA a)
  {
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
