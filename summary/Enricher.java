interface IX{
    void fun();
}
class CA implements IX{
  void fun(){    <-- add logic1 here
       //logic2
  } <-- add logic3 here
}
-------------------------------------------------------------------------
AOP

class Aspect{
    void before(){
       //logic1
    }
    void after(){
       //logic3
    }
}
IX obj = AOP.Engine<IX>(new CA(),new Aspect());
obj.fun();
-------------------------------------------------------------------------
proxy

class Wrapper implements IX{
  CA ref = new CA();
  void fun(){ 
     //logic1
     ref.fun();
     //logic3();
  } 
}

IX obj = new Wrapper();
obj.fun();
------------------------------------------------
Decorator (Linked list of Proxy)

class Enricher implements IX{
   IX ref;
   
   void fun(){ 
     //logic1
     ref.fun();
     //logic3();
  } 
}

IX obj = new Enricher2(new Enricher(new CA()));
obj.fun();

obj->Enricher2->Enricher->CA

------------------------------------------------
