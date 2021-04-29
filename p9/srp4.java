class CA{
    void do() {} //1
    void invoke(Util u){  u.doCA();  }
}
class CB extends CA{
   void do() {} //2
   void invoke(Util u){  u.doCB();  }
}
class CC extends CB{
  void do() {} //3
  void invoke(Util u){  u.doCC();  }
}
class Util{
  void doCA(){} //1
  void doCB(){} //2
  void doCC(){} //3
}

void fun(CA a){
  a.do();
  //uitl.do?();
  a.invoke(util);
  
}

void Main(){
  fun(new CA/CB/CC);
}
