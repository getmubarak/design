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
        if amount > KST_THRESHOLD:
            return amount * KST_RATE
        else:
            return amount * KST_RATE + KST_FIXED_AMOUNT

class GST:
    def compute(self, amount):
        return amount * GST_RATE + GST_FIXED_AMOUNT

class CST:
    def compute(self, amount):
        if amount > CST_THRESHOLD:
            return (amount - CST_THRESHOLD) * CST_RATE
        else:
            return 0
# Example usage
inv = Invoice()
inv.set_tax(GST())
amount = inv.get_total()
print(f"Total amount with GST: {amount}")
