interface Plugin{
  void doa();
  void dob();
  void doc();
}
class CA{
    void do1() {} //1a
    void do2() {} //2a
    void invoke(Plugin p){  u.doa();  }
}
class CB extends CA{
   void do1() {} //1b
   void do2() {} //2b 
   void invoke(Plugin p){  u.dob();  }
}
class CC extends CB{
  void do1() {} //1c
  void do2() {} //2c
  void invoke(Plugin p){  u.doc();  }
}
//============================================
class Ext3 implements Plugin{
  void doa(){} //3a
  void dob(){} //3b
  void doc(){} //3c
}
class Ext4 implements Plugin{
  void doa(){} //4a
  void dob(){} //4b
  void doc(){} //4c
}

void fun(CA a){
  a.do1(); <-- 1a | 1b | 1c
  a.do2(); <-- 2a | 2b | 2c
  Ext3 fun3 = new Ext3()
  a.invoke(fun3); <-- 3a | 3b | 3c
  Ext4 fun4 = new Ext4()
  a.invoke(fun4); <-- 4a | 4b | 4c
}

void Main(){
  fun(new CA/CB/CC);
}
