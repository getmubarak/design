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
  abstract void logic2();
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
  IX ref; <-- statergy (based on injected statergy logic2 changes)
  void fun(){
       //logic1
       ref.logic2(); <-- can be changed later
       //logic3
  }
}
-------------------------------
function objects (Lamda )

class CA{
  Lamda logic2; <-- function object(
  void fun(){
       //logic1
       logic2(); <-- can be changed later
       //logic3
  }
}
