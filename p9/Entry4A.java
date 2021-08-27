interface Plugin{
  void do(CA);
  void do(SA);
}
class Account{
  abstract void invoke(Plugin p);
}
-------------------------------------
class SA extends Account{
 void invoke(Plugin p){
    p.do(this);//4
  }
}
class CA extends Account{
 void invoke(Plugin p){
    p.do(this);
  }
}
-------------------------------------

public class Factory implements Plugin
{
  Dialog dlg;
  public void do(SA a){
    dlg= new SADialog();//5
  }
  public void do(CA a){
    dlg= new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();
		factory.do(account)<-- error
     		account.invoke(factory);//3
		factory.dlg.Display();				
	}
	static void main()
	{
		Account account = new SA();//1
		ShowUI(account);//2
	}
}
