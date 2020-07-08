

class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     void Save()
     {
          ... logic 1 
          if(this instanceof SA)
             ... save logic for SA
        
          if(this instanceof CA)
             ... save logic for CA
          
          ... logic 2         
     }
}

class SA extends Account
{
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
     public withdraw(double amount)
     {
        //logic 5
     }
     public deposit(double amount)
     {
        //logic 6
     }
}
