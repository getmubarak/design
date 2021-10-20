class AccountService:
  def __init__(self):
    self.stack = Stack()
    self.acc = Account()

  def withdraw(self, amount):
    acc.withdraw(amount)
    op = WithdrawOperation(amount)
    stack.push(op)
  def deposit(amount):
    acc.deposit(amount)
    op = DepositOperation(amount)
    stack.push(op)
  def undo():
    op = stack.pop();
    op.undo(acc);


class WithdrawOperation:
  def __init__(self,amount):
    self.amount = amount
  def undo(self,acc):
    acc.deposit(self.amount)

class DepositOperation:
  def __init__(self,amount):
    self.amount = amount
  def undo(self,acc):
    acc.withdraw(self.amount)
