@Author : Amal

public class Account {
 double balance;
 private AccountType acctype=AccountType.SavingPlatinum;
 enum AccountType{
  SavingPlatinum , maxWithdrawalAmount = 20000, minAccountBalance = 5000
  SavingSilver , maxWithdrawalAmount = 10000, minAccountBalance = 5000
  CurrentPlatinum , maxWithdrawalAmount = 20000, minAccountBalance = 100000
  CurrentSilver , maxWithdrawalAmount = 10000, minAccountBalance = 100000
 }
 public boolean withDraw(double amount) {  
  newBalance = balance - amount 
  if amount < acctype.maxWithdrawalAmount  || newBalance < acctype.minAccountBalance
   return false
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
