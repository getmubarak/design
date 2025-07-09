# broker library
public class Broker {
	public void trade() {
		System.out.println("trading ..");
	}
}
# stock library
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
		if(.. > .. && ... < ...)
		   return true;
		else
		   return false;		
	}
}
