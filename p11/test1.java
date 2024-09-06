//**** stock library (dll/jar) ****************
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
		if(IsGoodTimeTrade()){
			broker.trade();
		}
	}
	public bool IsGoodTimeTrade(){
		// domain rules
		if(rate > ... && rate < ...)
			....
	}
}
//***** broker library (dll/jar) *******
class BrokerImp implements Broker{
   void trade(){ ... logic ... }
}

//***** client *******

BrokerImp brokerImp = new BrokerImp();
Stock stock =  new Stock();
stock.SetBroker(brokerImp);
...
stock.changeRate(4545);


