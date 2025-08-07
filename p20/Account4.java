interface Dao{
  abstract persist();  
}
class Account
{
     Dao dao;
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
      
     public void save(){
          … logic 1
          dao.persist();
          … logic 2         
     }
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
