class CA{
  void f1(){} //1A
}
class CB extends CA{
  void f1(){} //1B
}
do(CA a){
  a.f1() <-- A | B | C 
}
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
class CA{
  CADao ref;
  void f1(){ ref->f1(); } 
}
class CADao{
  void f1(){} //1A
}
--------------------
class CB extends CA{
  CBDao ref;
  void f1(){ ref->f1(); } 
}
class CBDao{
  void f1(){} //1B
}
--------------------
do(CA a){
  a.f1() <-- A | B 
}
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
interface IX{
    void doCA() { f3 ca }
    void doCB() { f3 cb }
}
class CA{
  void call(IX f){ f.doCA();  }
}
class CB extends CA{
  void call(IX f){ f.doCB();  }
}
//==========================
class f3Fun implements IX
{
    void doCA() { f3 ca }
    void doCB() { f3 cb }
}
void doJob(CA a){
  f3Fun f3 = new f3Fun();
  a.call(f3); <-- 3 A|B|C.  looks like a.f3()
}
