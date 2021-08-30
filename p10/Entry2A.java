
//vertical
interface Account{
	void withDraw(double amount);
}
public interface Verifier {
 void verify();
}
public interface Notifier {
 void notify();
}
class AccountImp implements Account {
	double balance;
	double limit=0;
	List<Notifier> notifiers;
  List<Verifiers> verifiers;
  
	public void withDraw(double amount) {
    for(auto verifier: verifiers)
      verifier.verifiy();
		balance-=amount;
    for(auto notifier: notifiers)
      notifier.notify();
	}
}
//------------------------------------------

class AccountEmailNotify implements Notifier {
	Account ref;
	
	public void notify() {
		//email
	}
}
//------------------------------------------
class AccountOtpAuth implements Verifier {
	Account ref;
	
	public void verify() {
		//otp
	}
}

void Main(){
	Account acc = new AccountImp();
  acc.addVerifier(new AccountOtpAuth());
  acc.addNotifier(new AccountEmailNotify());
  acc.addNotifier(new AccountSmsNotify());
	acc.withdraw(100);
}
