interface Plugin
{
  void do(CA ca);   //doCA();
  void do(CB cb);   //doCB();
  void do(CC cc);   //doCC();
}
class CA{
  void f1(){} //1
  void f2(){} //2
  void invoke(Plugin p){
    p.do(this);    //p.doCA();
  }
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
  void invoke(Plugin p){
    p.do(this);    //p.doCB();
  }
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
  void invoke(Plugin p){
    p.do(this);    //p.doCC();
  }
}
//----------------------------------
class F3Impl implements Plugin
{
  void do(CA ca){
    ...f3 CA
  }
  void do(CB cb){
    ...f3 CB
  }
  void do(CC cc){
    ...f3 CC
  }
}
void do(CA obj){
  obj.f1(); //<- 1 | 3 | 5
  obj.f2(); //<- 2 | 4 | 6
 
  F3Impl f3 = new F3Impl();
  obj.invoke(f3); //<-- ? | ? | ?
    
    
}
