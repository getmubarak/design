Enum TransactionType{
  Deposit=1,
  Withdraw=2 
}

class Operation
{
  public TransactionType type;
  public double amount; 
}

class AccountService //<-- root entity
{
  Stack<Operation> stack = new Stack<Operation>(); //< value object
  Account acc = new Account(); //<-- entity
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    stack.push(new Operation(TransactionType.Withdraw,amount));
  }
  
  public void deposit(double amount){
    acc.deposit(amount);
    stack.push(new Operation(TransactionType.Deposit,amount))
  }
  
  public void undo(){
    Operation op = stack.pop();
    if(op.Type == TransactionType.Withdraw)
      acc.deposit(op.amount);
    if(op.Type == TransactionType.Deposit)
      acc.withdraw(op.amount);
      
  }
  
}
