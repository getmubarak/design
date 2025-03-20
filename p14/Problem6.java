interface Plugin{
  void doCA();
  void doCB();
  void doCC();
}
class CA{
  void f1(){} //1
  void f2(){} //2
  void call(Plugin p){
    p.doCA();
  }
}
class CB extends CA{
  void f1(){} //3
  void f2(){} //4
  void call(Plugin p){
    p.doCB();
  }
}
class CC extends CA{
  void f1(){} //5
  void f2(){} //6
  void call(Plugin p){
    p.doCC();
  }
}
//----------------------------------
class F3 implements Plugin
{
  void doCA() {} //7
  void doCB() {} //8
  void doCC() {} //9
}
class F4 implements Plugin
{
  void doCA() {} //10
  void doCB() {} //11
  void doCC() {} //12
}
class F5 implements Plugin
{
  int x;
  int y;
  int result;
  F5(int x,int y){
    this.x =x; this.y = y;
  }
  void doCA() { result = x+ y; } //10
  void doCB() { result = x - y; } //11
  void doCC() { result = x * y; } //12
  
  int getResult(){
     return z;
  }
}
//----------------------------------
void do(CA obj){
  obj.f1(); //<- 1 | 3 | 5
  obj.f2(); //<- 2 | 4 | 6
    
  F6 f6 = new F6(10,20);
  obj.call(f6); //<- 7| 8 | 9
  int ans = f6.getResult();
  
  //int ans = obj.f6(10,20);
  
  F3 f3 = new F3();
  obj.call(f3); //<- 7| 8 | 9
  
  F4 f4 = new F4();
  obj.call(f4); //<- 10| 11 | 12
}
