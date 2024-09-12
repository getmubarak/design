class AccountService:
    def __init__(self):
        self.stack = Stack()
        self.acc = Account()

    def withdraw(self, amount):
        self.acc.withdraw(amount)
        self.stack.push(lambda acc: acc.deposit(amount))

    def deposit(self, amount):
        self.acc.deposit(amount)
        self.stack.push(lambda acc: acc.withdraw(amount))

    def undo(self):
        op = self.stack.pop()
        op(self.acc)
