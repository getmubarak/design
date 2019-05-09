
//changed code
interface Operation
{
  void Undo();
}
class WithDrawOp: Operation
{
  public Account acc;
  public double amount;
  public void Undo()
  {
      acc.Deposit(amount);
  }
}
class DepositOp: Operation
{
  public Account acc;
  public double amount;
  public void Undo()
  {
      acc.Withdraw(amount);
  }
}

Operation 
WithdrawOp : Operation 
DepositOp : Operation

class AccountService
{
  Stack<Operation> stack = new Stack<Operation>();
  
  Account acc = new Account();
  
  public void withdraw(double amount){
    acc.withdraw(amount);
    WithdrawOpn op = new WithdrawOpn;
    op.amount = amount;
    op.acc = acc;
    stack.push(op);
  }
  
  public void deposit(double amount){
    acc.deposit(amount);
     DepositOpn op = new DepositOpn;
    op.amount = amount;
    op.acc = acc;
    stack.push(op)
  }
  
  public void undo(){
    Operation op = stack.pop();
    op.undo();  
  }
  
}
