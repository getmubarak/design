#1 
class Account{
     open() { ... }
     close() { ... }
     public abstract save();
}
#2 - inheritance
class Account{
     protected abstract persist();   
     public void save(){
          … open
          persist(); <-- hollywood style
          … close         
     }
}
#3 - aggregation
interface Dao{
  abstract persist();  
}
class Account{
     Dao dao; 
     Account(Dao dao); //<--di 
     public void save(){
          … open
          dao.persist();
          … close         
     }
}

