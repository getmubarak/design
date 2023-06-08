interface Plugin{
  void doa();
  void dob();
  void doc();
}
class CA{
    void invoke(Plugin p){  p.doa();  }
}
class CB extends CA{
   void invoke(Plugin p){  p.dob();  }
}
class CC extends CB{
  void invoke(Plugin p){  p.doc();  }
}
//============================================
class Util implements Plugin{
  void doa(){} //1
  void dob(){} //2
  void doc(){} //3
}

void Main(){
   CC c = new CC(); 
   CB b = c; 
   CA a = b; 
   Util util = new Util()
   a.invoke(util);
}
