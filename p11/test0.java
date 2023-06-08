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
//**** stock library (dll/jar) ****************
public class Stock {
	double rate;
	Broker broker;
	Stock(){
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
