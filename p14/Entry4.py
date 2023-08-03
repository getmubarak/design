class CB{
  void f1(){} //1B
  void f2(){} //2B
  void invoke(p){
    p.doCB();
  }
}
class CC{
  void f1(){} //1C
  void f2(){} //2C
  void invoke(p){
    p.doCC();
  }
}
//==========================
class F3Imp{
  void doCB(){}//3B
  void doCC(){}//3C  
}
class F4Imp{
  void doCB(){}//4B
  void doCC(){}//4C  
}
void doJob(a){
  a.f1(); <--1? B|C. 
  a.f2(); <--2? B|C  
    
  F3Imp f3 = new F3Imp();
  a.invoke(f3);<--3? B|C. 
  
  F4Imp f4 = new F4Imp();
  a.invoke(f4);<--4? B|C.
}

doJob(new ?); <-- CB | CC
