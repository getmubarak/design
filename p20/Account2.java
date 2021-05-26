

class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     logic1() { ... }
     logic2() { ... }
     public abstract save();
}

class SA extends Account
{
     public void save(){
          logic1();
          ...
          logic2();
     }
     
     public withdraw(double amount)
     {
        //logic 3
     }
     public deposit(double amount)
     {
        //logic 4
     }
}

class CA extends Account
{
     public void save(){
          logic1();
          ...
          logic2();
     }
     public withdraw(double amount)
     {
        //logic 5
     }
     public deposit(double amount)
     {
        //logic 6
     }
}
