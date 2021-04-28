
# high order fun

Lamda fun(int x){
  int z =  x + 5;
  
  # x,z is the clousre
  
  return (y)-> x + y; 
}

void main(){
  Lamda f1 = fun(10);
  Lamda f2 = fun(20);
  
  int res = f1(15); #25
  res = f2(10); #30
  
}
  
