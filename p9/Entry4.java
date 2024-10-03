Entry2 + Srp2 = Entry4

class Account{
  abstract void handle(Factory f);
}
-------------------------------------
class SA extends Account{
 void handle(Factory f){
    f.doSA(this);
  }
}
class CA extends Account{
 void handle(Factory f){
    f.doCA(this);
  }
}
-------------------------------------
public class Factory {
  Dialog dlg;
  public void doSA(SA a){
    dlg= new SADialog();
  }
  public void doCA(CA a){
    dlg= new CADialog();
  }
}
public class Entry {
	public static void ShowUI(Account account) {
		Factory factory = new Factory();            
		account.invoke(factory);
		factory.dlg.Display();				
	}
	static void main(){
		Account account = new SA();
		ShowUI(account);
	}
}
