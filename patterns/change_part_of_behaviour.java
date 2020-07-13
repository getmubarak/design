class CA{
  public void b1(){
    //part A logic
    //part B logic (modifiable)
    //part C logic    
  }
};
//1 is a
class CA{
  public void partB(){
    //part B logic (modifiable)
  }
  public void b1(){ <-- final/sealed
    //part A logic
    partB();
    //part C logic    
  }
};
class CB extends CA{
  public void partB(){
    //modify logic
  } 
};

//2 has a - interface
interface IX{
   void partB();
}
class CA{
  public void b1(IX ref){ 
    //part A logic
    ref.partB();
    //part C logic    
  }
};
class CB implements IX{
  public void partB(){
    //modify logic
  } 
};

//3 has a - Lamda
class CA{
  public void b1(Lamda partB){ 
    //part A logic
    partB();
    //part C logic    
  }
};
CA obj = new CA();
obj.b1(()=> modified logic );


