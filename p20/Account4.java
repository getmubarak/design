class AccountRepository{
  protected abstract persist();   
  void save(){
          … logic 1
          persist(); <-- hollywood style
          … logic 2         
  }
}
class SARepository extends Repository{
    protected persist(){
       //logic
    }
}
class CARepository extends Repository{
    protected persist(){
       //logic
    }
}
//--------------------------------------
class Account{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
}
class SA extends Account{
     public withdraw(double amount){
        //logic 3
     }
     public deposit(double amount){
        //logic 4
     }
}
class CA extends Account{
     public withdraw(double amount){
        //logic 5
     }
     public deposit(double amount){
        //logic 6
     }
}
