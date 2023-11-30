public class Stock {
    double rate;
    
    public void changeRate(double newRate,  callback: () => void ) {
        rate = newRate;
        if(IsGoodTimeTrade()){
            callback();
        }
    }
    public bool IsGoodTimeTrade(){
        // domain rules
        ...     
    }
}

const callback = () => {
    Broker broker = new Broker();
    broker.trade();
}
}
const stock = new Stock()
stock.changeRate(13.0, callback)
