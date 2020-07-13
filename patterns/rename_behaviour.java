class CA{
  public void b1(){
    //logic
  }
};
//1 has a <-- Adapter pattern (change interface)
class CB {
  CA ref = new CA();
  
  public void b2(){
    ref.b1();
  }
}
