
public class StockTradeNotifier {
	double rate;
	LAMDA trade;
	void SetBroker(LAMDA trade){
		this.trade = trade;
	}
	public void changeRate(double newRate) {
		rate = newRate;
		if(IsGoodTimeTrade()){
			trade();
		}
	}
	public bool IsGoodTimeTrade(){
		// domain rules
		...		
	}
}
//*************************************
Class Broker{
   void tradeWithCare(){
       ...
   }
   void tradeWithRisk(){
       ....
   }
}
//**************************************
Consumer

StockTradeNotifier notifier = new StockTradeNotifier();
Broker broker = new Borker();
notifier.setBroker(()-> broker.tradeWithCare() );

....
