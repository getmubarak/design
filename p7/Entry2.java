
interface AccountType{
  void IsWithdrawInLimit(amount);
}
class Platinum implements AccountType{
   void IsWithdrawInLimit(amount){
      if(amount > 20000)
            throw; 
    }
}
class Silver implements AccountType{
    void IsWithdrawInLimit(amount){
      if(amount > 10000)
            throw; 
    }
}
//====================================================
interface Account{
    void IsSufficientBalance(amount);
    void withDraw(double amount);
    void setType(AccountType type);
}
class AccountBase implments Account{
    double balance;
    AccountType type;
    
    void setType(AccountType type) {
		  this.type = type;
    }
    public void withDraw(double amount) {		
	  type. IsWithdrawInLimit(amount);
          IsSufficientBalance(amount);
          ...
    }
}
class SA extends AccountBase{
    void IsSufficientBalance(amount){
       if((balance - amount) < 5000)
		throw;
    }
}
class CA extends AccountBase{
    void IsSufficientBalance(amount){
       if((balance - amount) < 100000)
		throw;
    }
}
