class CA{
    void invoke(Util u){  u.do(this);  }
}
class CB extends CA{
   void invoke(Util u){  u.do(this);  }
}
class CC extends CB{
  void invoke(Util u){  u.do(this);  }
}
class Util{
  void do(CA){} //1
  void do(CB){} //2
  void do(CC){} //3
}


CC c = new CC();
CB b = c; <--upcast
CA a = c; <--upcast

Util util = new Util();
//uitl.f(a);<--1
a.invoke(util);<--3

//uitl.f(b);<--2
b.invoke(util);<--3

//uitl.f(c);<--3
c.invoke(util);<--3
