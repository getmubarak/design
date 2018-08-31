package problem7;

public class Account {
	double balance;
	private AccountType acctype=AccountType.SavingPlatinum;
	
	public boolean withDraw(double amount) {		
		switch(acctype)
		{
			case SavingPlatinum:
				if(amount > 20000){
					return false; 
				}
				if((balance - amount) < 5000){
					return false;
				}
			break;
			case SavingSilver:
				if(amount > 10000){
					return false; 
				}
				if((balance - amount) < 5000){
					return false;
				}
			
			break;
			case CurrentPlatinum:
				if(amount > 20000){
					return false; 
				}
				if((balance - amount) < 100000){
					return false;
				}
			break;
			case CurrentSilver:
				if(amount > 10000){
					return false; 
				}
				if((balance - amount) < 100000){
					return false;
				}
				
			break;
		}
		balance-=amount;
		return true;
	}

	AccountType getType() {
		return acctype;
	}

	void setType(AccountType type) {
		this.acctype = type;
	}
}
