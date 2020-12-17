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

void Main(){
  CX x = new CX();
  CA a = new CC();
 
  x.f(a); 
}
  
