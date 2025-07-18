class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     protected abstract persist();   
     public void save(){
          … logic 1
          persist(); <-- hollywood style
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
    protected persist(){
       //logic
    }
}
class CA extends Account{
     public withdraw(double amount){
        //logic 5
     }
     public deposit(double amount){
        //logic 6
     }
     protected persist(){
        //logic
     }
}
