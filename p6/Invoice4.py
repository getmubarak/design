class Invoice:
    def __init__(self):
        self.tax = None

    def set_tax(self, tax):
        self.tax = tax

    def get_total(self):
        if self.tax is None:
            raise ValueError("Tax type not set")
        amount = self.get_subtotal()
        amount += self.tax.compute(amount)
        return amount

    def get_subtotal(self):
        subtotal = 0
        # Placeholder for actual line item processing
        # for line_item in self.items:
        #     subtotal += line_item.get_price() * line_item.qty()
        return subtotal

class KST:
    def compute(self, amount):
        if amount > 5000:
            return amount * 0.05
        else:
            return amount * 0.05 + 200

class GST:
    def compute(self, amount):
        return amount * 0.025 + 500

class CST:
    def compute(self, amount):
        return (amount - 5000) * 0.3 if amount > 5000 else 0

# Example usage
inv = Invoice()
inv.set_tax(GST())
amount = inv.get_total()
print(f"Total amount with GST: {amount}")
