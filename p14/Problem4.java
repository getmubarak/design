interface Plugin{
  void do(CA a);
  void do(CB b);
  void do(CC c);
}
class CA{
  void f1(){} //1
  void f2(){} //2
  void call(Plugin p){
    p.do(this);
  }
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
  void call(Plugin p){
    p.do(this);
  }
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
  void call(Plugin p){
    p.do(this);
  }
}
//----------------------------------
class F3 implements Plugin
{
  void do(CA a) {} //7
  void do(CB b) {} //8
  void do(CC c) {} //9
}
class F4 implements Plugin
{
  void do(CA a) {} //10
  void do(CB b) {} //11
  void do(CC c) {} //12
}
//----------------------------------
void do(CA obj){
  obj.f1(); //<- 1 | 3 | 5
  obj.f2(); //<- 2 | 4 | 6
  
  F3 f3 = new F3();
  obj.call(f3); //<- 7| 8 | 9
  
  F4 f4 = new F4();
  obj.call(f4); //<- 10| 11 | 12
  
}
