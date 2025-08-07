class Account
{
     public abstract withdraw(double amount);
     public abstract deposit(double amount);
     
     logic1() { ... }
     logic2() { ... }
     public abstract save();
}

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
