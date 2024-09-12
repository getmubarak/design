class Invoice:
    def __init__(self):
        self.tax_type = 0

    def set_tax_type(self, tax_type):
        self.tax_type = tax_type

    def get_total(self):
        amount = self.get_subtotal()
        if self.tax_type == 1:
            if amount > 1000:
                amount += amount * 0.05
        elif self.tax_type == 2:
            amount += amount * 0.025 + 500
        elif self.tax_type == 3:
            if amount < 1000:
                amount += (amount - 5000) * 0.3
            else:
                amount += (amount - 5000) * 0.4
        return amount

    def get_subtotal(self):
        subtotal = 0
        # The following is a placeholder for actual line item processing
        # for line_item in self.items:
        #     subtotal += line_item.get_price() * line_item.qty()
        return subtotal
