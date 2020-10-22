
class CA{
  void f1(){} //1A
  void f2(){} //2A
}
class CB extends CA{
  void f1(){} //1B
  void f2(){} //2B
}
class CC extends CA{
  void f1(){} //1C
  void f2(){} //2C
}
//==========================

void doJob(CA a){
  a.f1(); <--1? A|B|C
  a.f2(); <--2? A|B|C
  if(type(a) == type(CA))
    //3A
  if(type(a) == type(CB))
    //3B
  if(type(a) == type(CC))
    //3C  
}

doJob(new ?); <-- CA | CB | CC
