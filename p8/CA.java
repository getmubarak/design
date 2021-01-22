class CA{
   void f(int x){
      if(x > 100){ <-- pre condition
        ...logic
      }
      else
        throw ...;
   }
}
class CB extends CA{
   void f(int x){
      if(x > 1000){ <-- pre condition
        ... changed logic
      }
      else
        throw ...;
   }
}
void do(CA obj){
  obj.f(200);
}
