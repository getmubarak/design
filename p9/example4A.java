class CA{}
class CB exends CA{}
class CC exends CA{}

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
do(CA a, CX x){
  if(a is instanceof(CC))
    x.fCC(); 
  else if(a is instanceof(CB))
    x.fCB();   
  else
    x.fCA(); 
}
