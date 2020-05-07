class CA{
  void fun(int i){
    if(i > 20){
      .. logic ..
    }else{
      throw ...
    }
  }
}
class CB extends CA{
  void fun(int i){
    if(i > 30){
      .. logic2 ..
    }else{
      throw ...
    }
  }
}
