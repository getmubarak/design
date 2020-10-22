class CA{
    void invoke(CX x){
      x.f(this);
    }
}
class CB exends CA{
    void invoke(CX x){
      x.f(this);
    }
}
class CC exends CA{
    void invoke(CX x){
      x.f(this);
    }
}

class CX{
  void f(CA) {}//1
  void f(CB) {}//2
  void f(CC) {}//3
}
class CY. extends CX {
  void f(CA) {}//4
  void f(CB) {}//5
  void f(CC) {}//6
}
class CZ. extends CX {
  void f(CA) {}//7
  void f(CB) {}//8
  void f(CC) {}//9
}
do(CA a, CX x){
   a.invoke(x); //1|2|3|4|5|6|7|8|9 
}
