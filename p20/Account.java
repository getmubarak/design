

class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     void Save()
     {
          ... common save logic 1 
          if(this instanceof SA)
             ... additional save logic specificaly for SA
        
          if(this instanceof CA)
             ... additional save logic specificaly for CA
          
          ... common save logic 2         
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
