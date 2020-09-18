interface Plugin
{
  void do(CA);
  void do(SA);
}
clasa Account{
  abstract void invoke(Plugin p);
}
-------------------------------------
class SA extends Account{
 void invoke(Plugin p){
    p.do(this);
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
  public void do(SA a)
  {
    dlg= new SADialog();
  }
  public void do(CA a)
  {
    dlg= new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();
                
		account.invoke(factory);
		
		factory.dlg.Display();				
	}
	static void main()
	{
		Account account = new SA();
		ShowUI(account);
	}
}
