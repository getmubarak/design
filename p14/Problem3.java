
class CA{
  void f1(){} //1
  void f2(){} //2
  void call(CX x){ // 10
    x.f3(this);
  }
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
  void call(CX x){ // 11
    x.f3(this);
  }
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
  void call(CX x){ // 12
    x.f3(this);
  }
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
  obj.f1(); 
  obj.f2(); 
  
  CX x = new CX();
  obj.call(x);
}
