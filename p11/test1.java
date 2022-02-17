interface Broker{
	void trade();
}
public class Stock {
	double rate;
	Broker broker;
	void SetBroker(Broker broker){
		this.broker = broker;
	}
	public void changeRate(double newRate) {
		rate = newRate;
		//if(condition && broker != null)
			broker.trade();
	}
}
