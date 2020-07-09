package problem10;

public class Account {
	double balance;
	boolean email=false;
	boolean sms=false;
	boolean otp=false;
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

Authentication
otp
secret
rsa

Notification:
Email
SMS
whats App
phone
