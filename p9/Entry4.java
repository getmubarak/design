
clasa Account{
  abstract void invoke(Factory f);
}
-------------------------------------
class SA extends Account{
 void invoke(Factory f){
    f.do(this);
  }
}
class CA extends Account{
 void invoke(Factory f){
    f.do(this);
  }
}
-------------------------------------

public class Factory 
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
