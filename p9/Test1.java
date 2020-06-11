class CA{}
class CB extends CA {}
class CC extends CB {}
class Util
{
  void f(CA a) {} //1
  void f(CB b) {} //2
  void f(CC c) {} //3 
}
void Main(){
  CC c = new CC();
  CB b = c;
  CA a = b;
  Util util = new Util();
  util.f(a);
  util.f(b);
  util.f(c);
}
