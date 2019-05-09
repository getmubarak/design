
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
