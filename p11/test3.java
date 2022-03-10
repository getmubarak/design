public class Stock {
	double rate;
	LAMDA trade;
	void SetBroker(LAMDA trade){
		this.trade = trade;
	}
	public void changeRate(double newRate) {
		rate = newRate;
		if(IsTimeToTrade(rate) && trade != null)
			trade();
	}
  bool IsTimeToTrade(double rate){ <-- specification
      if(condition)
        return true;
      else 
        return false;
  }
}
