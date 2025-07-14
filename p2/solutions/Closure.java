
# high order fun

Lamda fun(int x){
  int z =  x + 5;
  
 
  
  return (y)-> x + y; 
  /* object{
         data: x,z      # x,z is the clousre
         f(y){
            return x+ y + z;
         }
    }
  */
}

void main(){
  Lamda f1 = fun(10);  
  //f1{x:10,z:15,f(y)}
  
  Lamda f2 = fun(20);
  //f2{x:20,z:25,f(y)}
  
  int res = f1(5); #30
  res = f2(2); #47
  
}
  
