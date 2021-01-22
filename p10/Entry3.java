
class AccountImp  {
	double balance;
	double limit=0;
	
  //<-- inject all beforeadvice
	public void withDraw(double amount) {
		balance-=amount;
	}
  //<-- inject all afteradvice
}
class AccountEmailNotify implements AfterAdvice {
	public void withDraw(double amount) {
		//email 
	}
}
class AccountOtpAuth implements BeforeAdvice {
	public void withDraw(double amount) {
		//otp
	}
}
void Main(){
	Account acc = AopEngine.create<AccountImp>();
	acc.withdraw(100); 
}
