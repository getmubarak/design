interface Operation{
  undo(Account acc);
}
class DepositOp implements Operation
   double amount; 
   public void undo(Account acc){
     acc.withdraw(amount);
   }
}
class WithdrawOp implements Operation
   double amount; 
   public void undo(Account acc){
     acc.deposit(amount);
   }
}
class AccountService 
{
  Stack<Operation> stack = new Stack<Operation>();
  Account acc = new Account(); 
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    Operation op = new WithDrawOp(amount);
    stack.push(op);
  }
  public void deposit(double amount){
    acc.deposit(amount);
    Operation op = new DepositOp(amount);
    stack.push(op)
  }
  public void undo(){
    Operation op = stack.pop();
    op.undo(acc);
  }
}
