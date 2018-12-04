class Invoice:
	def __init__(self):
		self.taxType= 0

	def getTaxType():
		return taxType

	def setTaxType(taxType):
		self.taxType = taxType
	
	def getTotal():
		amount = getSubtotal();
		tax = new Tax();
		amount = amount + tax.compute(amount,taxType); 
		return amount
	
	def getSubtotal():
		subtotal = 0;
		‘’’ foreach(lineItem in Items)
		  {
		  		subtotal += lineItem.getPrice() * lineItem.Qty()
		  } 
          ‘’’
		return subtotal;

class Tax:
	def __init__(self):
		pass

	def compute(amount,taxType):
    		taxAmount = 0;
		if taxType == 1:
				taxAmount = amount * 0.05
		if taxType == 2:
				taxAmount = amount * 0.025 + 500
		if taxType == 3:
				taxAmount = (amount- 5000) * 0.3
		return taxAmount

