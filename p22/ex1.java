class CA{};
class CB : CA {};
class CC : CB {};

class Util{
  void fun(CA* ca){} //1
  void fun(CB* cb){} //2
  void fun(CC* cc){} //3
};
void main(){
  CC* cc = new CC;
  CB* cb = cc; <-- upcast
  CA* ca = cb; <-- upcast
  Util util;
  util.fun(cc);
  util.fun(cb);
  util.fun(ca);
}
//3.2.1. //3.3.3. //1.1.1
