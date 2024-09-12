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

class TaxImp:
    def __init__(self, tax_type):
        self.tax_type = tax_type

    def compute(self, amount):
        tax_amount = 0

        if self.tax_type == 1:
            if amount > 1000:
                tax_amount = amount * 0.05
        elif self.tax_type == 2:
            tax_amount = amount * 0.025 + 500
        elif self.tax_type == 3:
            if amount < 1000:
                tax_amount = (amount - 5000) * 0.3
            else:
                tax_amount = (amount - 5000) * 0.4
        
        return tax_amount
