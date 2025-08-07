interface Account{}
class CA : Account{}
class SA : Account{}

interface Dialog {
	void Display();
}
class SADialog : Dialog {}
class CADialog : Dialog {}

public class DialogFactory{
        Map<string,Lambda> lookup = new Map<string,Lambda>();

        public DialogFactory(){
                lookup.add(SA.getName(),()->new SADialog());
                lookup.add(CA.getName(),()->new CADialog());
        }
	public Dialog CreateUI(Account account){
		Dialog dlg=null;
		string key = account.getName();
                if (!lookup.exist(key))
			 throw new InvalidDomainObjectExpection();
		Lambda creatorMethod =lookup.get(key);
                return creatorMethod();
	}
}

public class Entry {
 
	static void main()
	{
		Account account = new SA();
                DialogFactory factory = new DialogFactory();
		Dialog dlg = factory.createUI(account);
		dlg.Display();
		
	}
}
