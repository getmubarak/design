class CA{
  void f1(){ }
  void f2(){ }
}
class CB extens CA{
  void f1(){ }
  void f2(){ }
}
class CC extens CA{
  void f1(){ }
  void f2(){ }
}
//********************
interface Visitor{
  visit(CA);
  visit(CB);
  visit(CC);
}
class CA{
  void accept(Visitor v) { v.visit(this); }
  void f1(){ }
  void f2(){ }
}
class CB extens CA{
  void accept(Visitor v) { v.visit(this); }
  void f1(){ }
  void f2(){ }
}
class CC extens CA{
  void accept(Visitor v) { v.visit(this); }
  void f1(){ }
  void f2(){ }
}
//********************
class f3Visitor implments Visitor{
  visit(CA) { ... }
  visit(CB) { ... } 
  visit(CC) { ... }
}
