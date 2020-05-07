class CA{
  void fun(int i){
    if(i > 20){   <-- pre condition
      .. logic ..
    }else{
      throw ...
    }
  }
}
class CB extends CA{
  void fun(int i){
    if(i > 30){   <-- pre condition
      .. logic2 ..
    }else{
      throw ...
    }
  }
}
do(CA o){
  o.fun(25);
}

