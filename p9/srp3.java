class CA{
    void invoke(Util u){  u.do(this);  }
}
class CB extends CA{
   void invoke(Util u){  u.do(this);  }
}
class CC extends CB{
  void invoke(Util u){  u.do(this);  }
}
class Util{
  void do(CA){} //1
  void do(CB){} //2
  void do(CC){} //3
}

void fun(CA a){
  
  //uitl.do(a);
  a.invoke(util);
  
}

void Main(){
  fun(new CA/CB/CC);
}
