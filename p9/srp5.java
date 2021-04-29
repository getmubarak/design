interface Plugin{
  void doCA();
  void doCB();
  void doCC();
}
//-------------------------------------
class CA{
    void do() {} 
    void exe() { 
      Util u = new Util();
      u.doCA(); 
    }
    void invoke(Plugin p){  p.doCA();  }
}
class CB extends CA{
   void do() {} 
   void exe() { 
      Util u = new Util();
      u.doCB(); 
    }
   void invoke(Plugin p){  p.doCB();  }
}
class CC extends CB{
  void do() {} 
  void exe() { 
      Util u = new Util();
      u.doCC(); 
    }
  void invoke(Plugin p){  p.doCC();  }
}
//*************************************
class Util implements Plugin{
  void doCA(){} //1
  void doCB(){} //2
  void doCC(){} //3
}

void fun(CA a){
  a.do();
  a.exe();
  Util util = new Util();
  a.invoke(util);
}

void Main(){
  fun(new CA/CB/CC);
}
