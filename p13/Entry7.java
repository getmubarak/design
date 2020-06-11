interface Visitor{
  void visit(CA);
  void visit(CB);
  void visit(CC);
}
class CA {
  void accept(visitor v){  v.visit(this);  }
}
class CB extends CA{
  void accept(visitor v){  v.visit(this);  }
}
class CC extends CA{
  void accept(visitor v){  v.visit(this);  }
}
//----------------------
class CX : Visitor{
  void visit(CA) { ... } <-- CX,CA
  void visit(CB) { ... } <-- CX,CB
  void visit(CC) { ... }
}
class CY extends CX{
  void visit(CA) { ... }
  void visit(CB) { ... }
  void visit(CC) { ... }
}
class CZ extends CX{
  void visit(CA) { ... }
  void visit(CB) { ... }<-- CZ,CB
  void visit(CC) { ... }
}
//-----------------------

CA o1 = new ?;
CX o2 = new ?;

o1.accept(o2);
