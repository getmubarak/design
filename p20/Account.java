

class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     void Save()
     {
          if(this instanceof SA)
             //save logic for SA
        
          if(this instanceof CA)
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
