APPROACH 4 - dynamic polymorphism + delegation + interface
[When SRP is borken and coupling is not allowed]

interface IA{
  logicCX();
  logicCY();
  logicCZ();
}
class CX{
  void logic(IA a){
     a.logicCX();
  }
}
class CY extends CX{
  void logic(IA a){
     a.logicCY();
  }
}
class CZ extends CX{
  void logic(IA a){
     a.logicCZ();
  }
}
- --  -   - - - --  -   - -
class CP implements IX{
  void logicCX(){
    logic C 
  }
  void logicCY(){
    logic B
  }
  void logicCZ(){
    logic A 
  }
}
CX x = new CZ();
IA a = new CP();
x.logic(a);
