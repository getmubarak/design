
class CurrentAccount{
  void withdraw(int amount){
    if(amount < 500)
      throw
      
    //logic
  }
}
class OverDraftAccount extends CurrentAccount{
  void withdraw(int amount){
    if(amount < 800)
      throw
      
    //logic2
  }
}


do(CurrentAccount a){
   a.withdraw(600);
}

