
class CurrentAccount{
  void withdraw(int amount){
    if(amount < 500)
      throw new InvalidTransactionException();
      
      //logicA for withdrawl
  }
}
class OverDraftAccount extends CurrentAccount{
  void withdraw(int amount){
    if(amount < 800)
      throw new InvalidTransactionException();
      
      //logicB for withdrawl
  }
}


do(CurrentAccount a){
   a.withdraw(600);
}

