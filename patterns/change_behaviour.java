class CA
{
  public void b1(){
    //logic
  }
};

//1 is a
class CB extends CA{
 public void b1(){
    //modified logic
  }
}

//2 has a
class CB {
 CA ref;
 
 public void b1(){
    //ref ?
    //modified logic
  }
}



