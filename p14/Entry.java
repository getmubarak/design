
interface CA{
  void f1();
  void f2();
}
class CB implements CA{
  void f1(){} //1B
  void f2(){} //2B
}
class CC implements CA{
  void f1(){} //1C
  void f2(){} //2C
}
//==========================

void doJob(CA a){
  a.f1(); <--1? B|C
  a.f2(); <--2? B|C
  if(type(a) == type(CB))
    //3B
  if(type(a) == type(CC))
    //3C  
}

doJob(new ?); <-- CB | CC
