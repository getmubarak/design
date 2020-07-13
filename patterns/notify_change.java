
interface Listener{
  void notify();
}


class CA
{
  Listener listener;
  
  int data;
  
  
  void set_data(int data){
    this.data = data;
    listner.notify(); <-- callback
  }
}
