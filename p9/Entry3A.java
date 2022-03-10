
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
