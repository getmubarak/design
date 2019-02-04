class Tax
{ 
     private int taxType;
	
	
     public int getTaxType() {
		return taxType;
     }

     public void setTaxType(int taxType) {
		this.taxType = taxType;
     }
	
      public double compute( double amount)
      {
	      double taxAmount =0;

	      switch(taxType)
	      {
		case 1:
		  taxAmount = amount * 0.05;
		  break;
		case 2:
		  taxAmount= amount * 0.025 + 500;
		  break;
		case 3:
		  taxAmount= (amount- 5000) * 0.3;
		  break;
	      }
	      return taxAmount;
      }
 
}
