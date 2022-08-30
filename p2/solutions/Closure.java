
# high order fun

Lamda fun(int x){
  int z =  x + 5;
  
  # x,z is the clousre
  
  return (y)-> x + y; 
  /* object{
         data: x,z
         f(y){
            return x+ y;
         }
    }
  */
}

void main(){
  Lamda f1 = fun(10);  
  //f1{x:10,z:15,f(y)}
  
  Lamda f2 = fun(20);
  //f2{x:20,z:25,f(y)}
  
  int res = f1(15); #25
  res = f2(10); #30
  
}
  
