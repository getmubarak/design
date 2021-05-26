class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     public abstract save();   
     void savedetails(){
          … logic 1
          save()
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
    public save(){
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
     public save(){
        //logic
     }
}
