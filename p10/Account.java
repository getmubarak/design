package problem10;

public class Account {
	double balance;
	boolean email=false;
	boolean sms=false;
	boolean otp=false;
	boolean secretQuestion=false;
	double limit=0;
    	
	public void withDraw(double amount) {
		
		if(otp) {
			//logic
		}
		if(secretQuestion) {
			//logic
		}
		
		balance-=amount;
		
		if(email) {
			//logic
		}
		if(sms) {
			//logic
		}
	}
}
