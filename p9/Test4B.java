class CA{
    void call(CX x){
        x.f(this);
    }
}
class CB extends CA {
    void call(CX x){
       x.f(this);
    }
}
class CC extends CB {
    void call(CX x){
       x.f(this);
    }
}
class CX{
  void f(CA a) {} //1
  void f(CB b) {} //2
  void f(CC c) {} //3 
}

void Main(){
  CX x = new CX();
  CA a = new CC();
 
  //x.f(a); <-- 1
  a.call(x); <-- 3
}
  
