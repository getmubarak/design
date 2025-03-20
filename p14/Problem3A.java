
class CA{
  void f1(){} //1
  void f2(){} //2
  void call(CX x){ // 10
    x.f3CA();
  }
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
  void call(CX x){ // 11
    x.f3CB();
  }
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
  void call(CX x){ // 12
    x.f3CC();
  }
}
//----------------------------------
class CX
{
  void f3CA() {} //7
  void f3CB() {} //8
  void f3CC() {} //9
}

//----------------------------------
void do(CA obj){
  obj.f1(); 
  obj.f2(); 
  
  CX x = new CX();
  x.? 
  obj.call(x);
}
