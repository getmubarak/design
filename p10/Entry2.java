package problem10;

//vertical
interface Account{
	void withDraw(double amount);
}
class AccountImp implements Account {
	double balance;
	double limit=0;
	
	public void withDraw(double amount) {
		balance-=amount;<-- 5
	}
}
class AccountEmailNotify implements Account {
	Account ref;
	
	public void withDraw(double amount) {
		ref.withDraw(amount);<-- 4
		//email <-- 6
	}
}
class AccountOtpAuth implements Account {
	Account ref;
	
	public void withDraw(double amount) {
		//otp<-- 2
		ref.withDraw(amount);<-- 3
	}
}

void Main(){
	Account acc = new AccountOtpAuth(new AccountEmailNotify(new AccountSmsNotify(new AccountImp())));
	acc.withdraw(100); <-- 1
}

