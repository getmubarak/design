interface Plugin{
  void do(CB cb);
  void do(CA ca);
}
interface IA{
  void f1();
  void f2();
  void invoke(Plugin p);
};
class CB implemens IA{
  void f1() {}  //1
  void f2() {}  //2
  void invoke(Plugin p) { p.do(this); }
};
class CC implemens IA{
  void f1() {}  //3 
  void f2() {}  //4  
  void invoke(Plugin p) { p.do(this); }
};
//**************************************
class f3Imp implements Plugin{
  void do(CB cb) {} // 5 ... f3.. CB
  void do(CA ca) {} //  6... f3 ... CA 
} 
class f4Imp implements Plugin{
  void do(CB cb) {} // 7 ... f4.. CB
  void do(CA ca) {} //  8... f4 ... CA 
} 
do(IA a){
  a.f1();  //1 | 3
  a.f2();  //2 | 4
  f3Imp f3 = new f3Imp();
  a.invoke(f3); // 5 | 6
  f4Imp f4 = new f4Imp();
  a.invoke(f4); // 7 | 8
}

do(new ?);  //CB or CC
