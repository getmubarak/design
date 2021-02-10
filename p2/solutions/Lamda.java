class AccountService
{
  Stack<Lamda> stack = new Stack<Lamda>();
  Account acc = new Account();
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    stack.push(()->acc.deposit(amount));
  }
  public void deposit(double amount){
    acc.deposit(amount);
    stack.push(()->acc.withdraw(amount));
  }
  public void undo(){
    Lamda fun = stack.pop();
    fun();
  }
}
