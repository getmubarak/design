class AccountService:
  def __init__(self):
    self.stack = Stack()
    self.acc = Account()

  def withdraw(self, amount):
    self.acc.withdraw(amount)
    self.stack.push(WithdrawOperation(amount))
    
  def deposit(self, amount):
    self.acc.deposit(amount)
    self.stack.push(DepositOperation(amount))
    
  def undo():
    op = stack.pop();
    op.undo(self.acc);


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
