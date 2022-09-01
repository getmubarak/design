//***** library *******
interface Broker{
	void trade();
}
class BrokerImp{
 void trade(){ ... logic ... }
}
class BrokerFactory{
  Broker getInstance(){
    return new BrokerImp();
  }
}
//**** client ****************
public class Stock {
	double rate;
	Broker broker;
	Stock(){
                BrokerFactory f = new BrokerFactory();
		this.broker = f.getInstance();
	}
	public void changeRate(double newRate) {
		rate = newRate;
		//if(condition && broker != null)
			broker.trade();
	}
}
