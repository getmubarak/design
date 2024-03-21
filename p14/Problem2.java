class CA{
  void f1(){} //1
  void f2(){} //2
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
}
//----------------------------------
class CX
{
  void f3(CA a) {} //7
  void f3(CB b) {} //8
  void f3(CC c) {} //9
}

//----------------------------------
void do(CA obj){
  obj.f1(); //<- 1 | 3 | 5
  obj.f2(); //<- 2 | 4 | 6
  
  CX x = new CX();
  x.f3(obj); //<- ?
}
