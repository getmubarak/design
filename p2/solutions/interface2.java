interface Operation{
  undo(Account acc);
}
class DepositOp implements Operation{
   double amount; 
   DepositOp(amount){
      this.amount = amount;
   }
   public void do(Account acc){
     acc.Deposit(amount);
   }
   public void undo(Account acc){
     acc.withdraw(amount);
   }
}
class WithdrawOp implements Operation{
   double amount;
   WithdrawOp(amount){
      this.amount = amount;
   }
   public void do(Account acc){
     acc.withdraw(amount);
   }
   public void undo(Account acc){
     acc.deposit(amount);
   }
}
class AccountService 
{
  Stack<Operation> stack = new Stack<Operation>();
  Account acc = new Account(); 
  
  public void withdraw(double amount){
    Operation op = new WithDrawOp(amount);
    op.do(acc);
    stack.push(op);
  }
  public void deposit(double amount){
    Operation op = new DepositOp(amount);
    op.do(acc);
    stack.push(op)
  }
  public void undo(){
    Operation op = stack.pop();
    op.undo(acc);
  }
}
