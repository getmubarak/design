class CA{
     accept(CX x){
          x.fCA();
     }
}
class CB : CA{
     accept(CX x){
          x.fCB();
     }
}
class CC : CA{
     accept(CX x){
          x.fCB();
     }
}
//----------------
class CX{
     void fCA() {}1
     void fCB() {}2
     void fCC() {}3
}
class CY : CX{
     void fCA() {}4
     void fCB() {}5
     void fCC() {}6
}
class CZ : CX{
     void fCA() {}7
     void fCB() {}8
     void fCC() {}9
}
//-----------------

CA a = new ?; CA/CB/CC
CX x = new ?; CX/CY/CZ

a.accept(x); 1..9
