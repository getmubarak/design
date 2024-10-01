class AccountCompensation{
  public void withdrawUndo(double amount){
    acc.deposit(amount);
  }
  public void depositUndo(double amount){
    acc.withdraw(amount);
  }
}
class AccountService
{
  Stack<Lamda> stack = new Stack<Lamda>();
  Account acc = new Account();
  AccountCompensation compensation = new AccountCompensation();
  public void withdraw(double amount){
    acc.withdraw(amount);
    stack.push(()->compensation.withdrawUndo(amount));
  }
  public void deposit(double amount){
    acc.deposit(amount);
    stack.push(()->compensation.depositUndo(amount));
  }
  public void undo(){
    Lamda fun = stack.pop();
    fun();
  }
}
