class CA{
    void invoke(Util u){  u.f(this);  }
}
class CB extends CA{
   void invoke(Util u){  u.f(this);  }
}
class CC extends CB{
  void invoke(Util u){  u.f(this);  }
}
class Util{
  void f(CA){} //1
  void f(CB){} //2
  void f(CC){} //3
}
CC c = new CC();
CB b = c; <--upcast
CA a = c; <--upcast

Util util = new Util();
a.invoke(util);
b.invoke(util);
c.invoke(until);
1,1,1.     1,2,3.    3,3,3.

uitl.f(a);
uitl.f(b);
uitl.f(c);

