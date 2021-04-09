@Author :Ankur

//Horizontal

interface Enricher{	
	abstract void do(Account a);
}
class OTP implements Enricher{
	void do(Account a){ .. logic ...}
}
class SecretQuestion implements Enricher{
	void do(Account a){ .. logic }
}
class Email implements Enricher {
	void do(Account a){ .. logic }
}
class SMS implements Enricher {
	void do(Account a){ .. logic }
}
public class Account {
	double balance;
	double limit=0;
	List<Enricher> preEnrichers;
	List<Enricher> postEnrichers;
    	
	public void withDraw(double amount) {

		foreach enricher in preEnrichers{
			enricher.do(this);
		}
		balance-=amount;
		foreach enricher in postEnrichers{
			enricher.do(this);
		}
	}
}
