//************ domain **************
class Account
{
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
//***************** Dao ********************
class Dao{
  abstract persist();  
  void save(){
        logic
        persist();
        logic
  }
}
class SADao implements Dao{
      protected persist(){
        //logic
     }
}
class CADao implements Dao{
    protected persist(){
       //logic
    }
}
