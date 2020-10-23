interface Account{
    void withDraw(double amount);
}
public class AccountImp implements Account{
	double balance;
  
	public void withDraw(double amount) {
		balance-=amount;
	}
}

void Main(){
  Account acc = new Otp(
                new SecretQuestion(
                new EmailNotification(
                new SmsNotification(new AccountImp()))));
  acc.withdraw(345);
}

class Otp implements Account{
  Account ref;
  public void withDraw(double amount) {
		//... otp logic
    ref.withDraw(amount);
	}
}
class SecretQuestion implements Account{
  Account ref;
  public void withDraw(double amount) {
		//... SecretQuestion logic
    ref.withDraw(amount);
	}
}
class EmailNotification implements Account{
  Account ref;
  public void withDraw(double amount) {
    ref.withDraw(amount);
    //... EmailNotification logic
	}
}
class SmsNotification implements Account{
  Account ref;
  public void withDraw(double amount) {
    ref.withDraw(amount);
    //... SmsNotification logic
	}
}

