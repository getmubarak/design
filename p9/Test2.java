class CA{
  void f() { } //1
}
class CB extends CA {
    void f() { } //2

}
class CC extends CB {
    void f() { } //3
}

void Main(){
  CC c = new CC();
  CB b = c;
  CA a = b;
  a.f();
  b.f();
  c.f();

