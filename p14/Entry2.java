interface Plugin{
  void do(CA);
  void do(CB); 
  void do(CC);  
}
class CA{
  void f1(){} //1A
  void f2(){} //2A
  void invoke(Plugin p){
    p.do(this);
  }
}
class CB extends CA{
  void f1(){} //1B
  void f2(){} //2B
  void invoke(Plugin p){
    p.do(this);
  }
}
class CC extends CA{
  void f1(){} //1C
  void f2(){} //2C
  void invoke(Plugin p){
    p.do(this);
  }
}
//==========================
class F3Imp implements Plugin{
  void do(CA){}//3A
  void do(CB){}//3B
  void do(CC){}//3C  
}

void doJob(CA a){
  a.f1(); <--1? A|B|C. (1B)
  a.f2(); <--2? A|B|C  (2B)
    
  F3Imp f3 = new F3Imp();
  a.invoke(f3);<--3? A|B|C. (CB::invoke(f3))-->(3B)
}

doJob(new ?); <-- CA | CB | CC
