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
void do(CA obj){
  obj.f1(); //<- 1 | 3 | 5
  obj.f2(); //<- 2 | 4 | 6
  if(obj instanceof(CA))
    ...f3 CA
  if(obj instanceof(CB))
    ...f3 CB
  if(obj instanceof(CC))
    ...f3 CC
    
}
