class CA{
    void invoke(CX x){
      x.fCA();
    }
}
class CB exends CA{
    void invoke(CX x){
      x.fCB();
    }
}
class CC exends CA{
    void invoke(CX x){
      x.fCC();
    }
}
//----------------------------------
class CX{
  void fCA() {}//1
  void fCB() {}//2
  void fCC() {}//3
}
class CY. extends CX {
  void fCA() {}//4
  void fCB() {}//5
  void fCC() {}//6
}
class CZ. extends CX {
  void fCA() {}//7
  void fCB() {}//8
  void fCC() {}//9
}
//----------------------------------
CA a = new CC();
CX x = new CZ();
x.f ??                  
a.invoke(x);       //9 
