//AOP : Aspect oriented Programing
// poor mans decorator

class AccountImp  {
	double balance;
	double limit=0;
	
    	@ AccountEmailNotify
	@ AccountOtpAuth
	public void withDraw(double amount) {
		balance-=amount;
	}
        
}
class AccountEmailNotify implements AfterAdvice {
	public void do(AccountImp a) {
		//email 
	}
}
class AccountOtpAuth implements BeforeAdvice {
	public void do(AccountImp a) {
		//otp
	}
}
void Main(){
	Account acc = AopEngine.create<AccountImp>();
	
	acc.withdraw(100); 
}
