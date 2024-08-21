package problem11;

public class Stock {
	double rate;
	
	public void changeRate(double newRate) {
		rate = newRate;
		if(IsGoodTimeTrade()){
			Broker broker = new Broker();
			broker.trade();
		}
	}
	public bool IsGoodTimeTrade(){
		// domain rules
		if.. > .. && ... < ...
		   ...		
	}
}
