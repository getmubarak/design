class AccountService:
    def __init__(self):
        self.stack = Stack()
        self.acc = Account()

    def withdraw(self, amount):
        self.acc.withdraw(amount)
        self.stack.push(lambda : withdrawUndo(amount))

    def deposit(self, amount):
        self.acc.deposit(amount)
        self.stack.push(lambda : depositUndo(amount))

    def undo(self):
        op = self.stack.pop()
        op()

    def withdrawUndo(self, amount):
        self.acc.deposit(amount)

    def depositUndo(self, amount):
        self.acc.withdraw(amount)
 
