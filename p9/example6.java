class CA{
    void invoke(Util u){  u.doCA();  }
}
class CB extends CA{
   void invoke(Util u){  u.doCB();  }
}
class CC extends CB{
  void invoke(Util u){  u.doCC();  }
}
class Util{
  void doCA(){} //1
  void doCB(){} //2
  void doCC(){} //3
}

void fun(CA a){
  
  //uitl.do?();
  a.invoke(util);
  
}

void Main(){
  fun(new CA/CB/CC);
}
