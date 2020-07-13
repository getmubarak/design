class CA{
  void f1() {}
  void f2() {}
}
class CB{
  void f3() {}
  void f4() {}
}
//*************
class Facade <-- gateway / controller
{
  void fun(){
    CA a = new CA();
     a.f1();
     a.f2();
    CB b = new CB();
     b.f3();
     b.f3();
     
  }
}
