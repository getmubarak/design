class CA{}
class CB extends CA{}
class CC extends CB{}

class Util{
  void f(CA){} //1
  void f(CB){} //2
  void f(CC){} //3
}

do(CA a){  
  Util util = new Util();
  if(a isinstanceof CC)
    uitl.f((CC)a); 
  elseif (a isinstanceof CB)
     uitl.f((CB)a); 
  else
    uitl.f(a); 
}

do(new CC());
