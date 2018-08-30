package problem2;

public class Account {
	double balance;
	
	public boolean withDraw(double amount)
	{
		if(amount > balance)
			return false;
		
		balance -= amount;
		return true;
	}
	public void deposit(double amount)
	{
		balance += amount;
	}
}
