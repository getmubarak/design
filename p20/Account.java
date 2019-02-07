

class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     void Save(Account a)
     {
          if(a instanceof SA)
             //save logic for SA
        
          if(a instanceof CA)
             //save logic for CA
             
     }
}

class SA extends Account
{
     public withdraw(double amount)
     {
        //logic
     }
     public deposit(double amount)
     {
        //logic
     }
}

class CA extends Account
{
     public withdraw(double amount)
     {
        //logic
     }
     public deposit(double amount)
     {
        //logic
     }
}
