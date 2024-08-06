class Shape{
   virtual fun(){} \\1
};
class Rect extends Shape {
   fun(){} \\2
}
class Square extends Rect {
   fun(){} \\3  
};

void main(){
  Square square = new Square();
  Rect rect = square; 
  Shape shape = rect; 
  shape.fun();
  rect.fun();
  square.fun();
}
//3.2.1. //3.3.3. //1.1.1
