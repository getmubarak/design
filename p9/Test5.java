class CA{
  void invoke(CX x){
    x.f(this);
  }
}
class CB extends CA {
  void invoke(CX x){
    x.f(this);
 }
}
class CC extends CA {
  void invoke(CX x){
    x.f(this);
 }
}
class CX{
  void f(CA a) {} //1
  void f(CB b) {} //2
  void f(CC c) {} //3 
}
class CY extneds CX{
  void f(CA a) {} //4
  void f(CB b) {} //5
  void f(CC c) {} //6 
}
class CZ extneds CX{
  void f(CA a) {} //7
  void f(CB b) {} //8
  void f(CC c) {} //9 
}

do(CX x,CA a){
  a.invoke(x); // any of the 9 
}

void Main(){
  CX x= new CZ();
  CA a = new CC();
  a.invoke(x);
  x.f(a);
}
