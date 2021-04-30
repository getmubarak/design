Design by contract
# pre condition
# post condition
# invariant

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
