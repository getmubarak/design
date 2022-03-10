public class StockSpec{
  static bool IsTimeToTrade(double rate){ <-- specification
      if(condition)
        return true;
      else 
        return false;
  }
}
public class Stock {
	double rate;
	LAMDA trade;
	void SetBroker(LAMDA trade){
		this.trade = trade;
	}
	public void changeRate(double newRate) {
		rate = newRate;
		if(StockSpec.IsTimeToTrade(rate) && trade != null)
			trade();
	}
  
}
