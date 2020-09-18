class CA{
  void fun(){
       //logic1
       //logic2 <-- can be changed later
       //logic3
  }
}
-------------------------------
template method pattern (extends- is a)

class CA{
  void logic2(){
       //logic2 
  }
  void fun(){<-- template method
       //logic1
       logic2(); <-- can be changed later
       //logic3
  }
}
-------------------------------
staergy pattern (interface, has a)

interface IX{
    void logic2();
}
class CA{
  IX ref;
  void fun(){<-- template method
       //logic1
       ref.logic2(); <-- can be changed later
       //logic3
  }
}
*******************************
class CX implements IX
 void logic2(){
       //logic2 
  }
}
-------------------------------
function objects (Lamda )

class CA{
  Lamda logic2;
  void fun(){<-- template method
       //logic1
       logic2(); <-- can be changed later
       //logic3
  }
}
