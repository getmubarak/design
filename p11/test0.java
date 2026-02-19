//***** broker library (dll/jar) *******
interface Broker{
   void trade();
}
class BrokerImp implements Broker{
   void trade(){ ... logic ... }
}
class BrokerFactory{
  Broker getInstance(){
    return new BrokerImp();
  }
}
//**** notifier library (dll/jar) ****************
public class StockTradeNotifier {
	double rate;
	Broker broker;
	StockTradeNotifier(){
		BrokerFactory f = new BrokerFactory();
		this.broker = f.getInstance();
	}
	public void changeRate(double newRate) {
		rate = newRate;
		if(IsGoodTimeTrade()){
			broker.trade();
		}
	}
	public bool IsGoodTimeTrade(){
		// domain rules
		...		
	}
}
