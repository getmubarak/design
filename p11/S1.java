package problem11;

interface Broker{
  void trade();
}
public class Stock {
	double rate;
	
	public void changeRate(double newRate) {
		rate = newRate;
		if(IsGoodTimeTrade()){
			Broker broker = new BrokerImp();
			broker.trade();
		}
	}
	public bool IsGoodTimeTrade(){
		// domain rules
		...		
	}
}
