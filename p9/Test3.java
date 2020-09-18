class CA{
}
class CB extends CA {
}
class CC extends CB {
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
class CZ extneds CY{
  void f(CA a) {} //7
  void f(CB b) {} //8
  void f(CC c) {} //9 
}
void Main(){
  CX x = new CZ();
  CY y = new CZ();
  CZ z = new CZ();
  
  CC c = new CC();
  CB b = c;
  CA a = b;
  x.f(a); 
  x.f(b); 
  x.f(c); 

  y.f(a); 
  y.f(b); 
  y.f(c); 

  z.f(a); 
  z.f(b); 
  z.f(c); 
}
