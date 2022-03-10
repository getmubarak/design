APPROACH 1 - typecheck
  
class CX{
}
class CY extends CX{
}
class CZ extends CX{
}

void logic(CX obj){
  if(type(obj) == type (CZ))
    logic A
  if(type(obj) == type (CY))
    logic B
  if(type(obj) == type (CX))
    logic C 
}
CX x = new CZ();
logic(x);
==================================
APPROACH 2 - dynamic polymorphism

class CX{
  void logic(){
    logic C 
  }
}
class CY extends CX{
  void logic(){
    logic B
  }
}
class CZ extends CX{
  void logic(){
    logic A 
  }
}
CX x = new CZ();
x.logic();

==================================
APPROACH 3 - dynamic polymorphism + delegation

class CX{
  void logic(){
     CP p = new CP();
     p.logic();
  }
}
class CY extends CX{
  void logic(){
     CQ q = new CQ();
     q.logic();    
  }
}
class CZ extends CX{
  void logic(){
     CR r = new CR();
     r.logic();    
  }
}

class CP{
  void logic(){
    logic C 
  }
}
class CQ extends CP{
  void logic(){
    logic B
  }
}
class CR extends CP{
  void logic(){
    logic A 
  }
}
CX x = new CZ();
x.logic();
