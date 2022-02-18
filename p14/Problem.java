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
  obj.f1(); //<- logic 1 | logic 3 | logic 5
  obj.f2(); //<- logic 2 | logic 4 | logic 6
  if(obj instanceof(CA))
    ...f3 logic for CA f3
  if(obj instanceof(CB))
    ...f3 logic for CB f3
  if(obj instanceof(CC))
    ...f3 logic for CC f3
    
}
