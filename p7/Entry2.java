
interface AccountType{
  void IsWithdrawInLimit(amount);
}
class Platinum implements AccountType{
   void IsWithdrawInLimit(amount){
      if(amount > 20000){
            throw; 
       }
    }
}
class Silver implements AccountType{
    void IsWithdrawInLimit(amount){
      if(amount > 10000){
            throw; 
       }
    }
}
//====================================================

class Account{
    double balance;
    AccountType type;
    
    void setType(AccountType type) {
		  this.type = type;
	  }
    
    abstract void IsSufficientBalance(amount);
    
    public void withDraw(double amount) {		
	        type. IsWithdrawInLimit(amount);
          IsSufficientBalance(amount);
          ...
    }
}
class SA implements Account{
    void IsSufficientBalance(amount){
       if((balance - amount) < 5000){
					throw;
			  }
    }
}
class CA implements Account{
    void IsSufficientBalance(amount){
       if((balance - amount) < 100000){
					throw;
			  }
    }
}
