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

        void Register(string key,LAMBDA fo){
          lookup.add(key,fo);
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
    DialogFactory factory = new DialogFactory();
    foreach(Class in ClassConfig){
        factory.register(Class.name, ()=> Class.create() );
    }


		Account account = new SA();
    Dialog dlg = factory.createUI(account);
		dlg.Display();
		
	}
}
