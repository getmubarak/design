Design by contract

fun(){
 1. contract
 2. logic
}
Types of Contract
# 1. pre condition <-- expectation from caller (eg, input > 1000)
# 2. post condition <-- what caller can expect (eg, return > 0)  
# 3. invariant <-- what will not change (input will be const)

class CurrentAccount{
  void withdraw(int amount){
    if(amount < 500) <-- pre condition
      throw new InvalidTransactionException();
      
      //logic for withdrawl
  }
}
class OverDraftAccount extends CurrentAccount{
  void withdraw(int amount){
    if(amount < 800)<-- pre condition
      throw new InvalidTransactionException();
      
      //logic for withdrawl
  }
}


do(CurrentAccount a){
   a.withdraw(600);
}
