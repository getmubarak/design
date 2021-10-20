class AccountService:
  def __init__(self):
    self.stack = Stack()
    self.acc = Account()
  
  def withdraw(self, amount):
    acc.withdraw(amount)
    op = Operation(1,amount)
    stack.push(op)
 
  def deposit(amount):
    acc.deposit(amount)
    op = Operation(2,amount)
    stack.push(op)

  def undo():
    op = stack.pop();
    if(op.Type == 1):
      acc.deposit(op.amount)
    if(op.Type == 2):
      acc.withdraw(op.amount)
