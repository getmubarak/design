
class CA{
  int data;

  void set(int newData){
    data = newData; <-- notify change
  }
}
//----------------------------------------
interface INotify{
  void notify();
}
class CA{
  int data;
  INotify subsciber;
  
  void set(int newData){
    data = newData; 
    if(subsciber != null)
        subsciber.notify();<-- notify change
  }
}
