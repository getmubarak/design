class CA{
}
class CB extends CA {
}
class CC extends CB {
}
class CX{
  void f(CA a) {} //1
  void f(CB b) {} //2
  void f(CC c) {} //3 
}
void Main(){
  do( ? );
}
void do( CA a){
  CX x = new CX();
  if(a isInstanceof CB)
      x.f((CB) a); 
  else if(a isInstanceof CC)
      x.f((CC) a); 
  else
      x.f(a);
}
