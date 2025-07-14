class AccountService //<-- root entity
{
  Stack<Operation> stack = new Stack<Operation>(); //< value object
  Account acc = new Account(); //<-- entity
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    stack.push(new Operation(1,amount));
  }
  
  public void deposit(double amount){
    acc.deposit(amount);
    stack.push(new Operation(2,amount))
  }
  
  public void undo(){
    Operation op = stack.pop();
    if(op.Type == 1)
      acc.deposit(op.amount);
    if(op.Type == 2)
      acc.withdraw(op.amount);
      
  }
  
}
