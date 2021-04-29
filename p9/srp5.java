interface Plugin{
  void doCA();
  void doCB();
  void doCC();
}
//-------------------------------------
class CA{
    void do() { .. logic ... } 
    void exe() { 
      Util u = new Util();
      u.doCA(); 
    }
    void invoke(Plugin p){  p.doCA();  }
}
class CB extends CA{
   void do() { .. logic ... } 
   void exe() { 
      Util u = new Util();
      u.doCB(); 
    }
   void invoke(Plugin p){  p.doCB();  }
}
class CC extends CB{
  void do() { .. logic ... } 
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
  a.do();// 1 ? 2 ? 3 (logic in the family
  a.exe();// 1 ? 2 ? 3 (logic delegated to util with coupling )
  Util util = new Util();
  a.invoke(util);// 1 ? 2 ? 3 
                 (logic delegated to util without coupling)
}

void Main(){
  fun(new CA/CB/CC);
}
