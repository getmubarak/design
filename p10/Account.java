package problem10;

public class Account {
	double balance;
	boolean email=false;
	boolean sms=false;
	boolean otp=false;
	double limit=0;
    //rsa
	//secret question
	
	public void withDraw(double amount) {
		
		if(otp) {
			//logic
		}
		if(limit > 0) {
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
