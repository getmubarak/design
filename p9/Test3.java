class CA{
}
class CB extends CA {
}
class CC extends CA {
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
void do(CX x, CA a){
  x.f(a); 
}
