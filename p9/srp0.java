class CA{}
class CB extends CA{}
class CC extends CB{}
class Util{
  void f(CA){} //1
  void f(CB){} //2
  void f(CC){} //3
}
CC c = new CC();
CB b = c; <--upcast
CA a = c; <--upcast

Util util = new Util();
uitl.f(a);
uitl.f(b);
uitl.f(c);

1,1,1.     1,2,3.    3,3,3.



class CX{
  void f() {}//1
}
class CY. extends CX {
  void f() {}//2
}
class CZ. extends CY {
  void f() {}//3
}

CZ z = new CZ();
CY y = z;
CX x = y;

x.f();
y.f();
z.f();

1,1,1.     1,2,3.    3,3,3.
