class Shape{
   virtual fun(){} \\A1
};
class Rect extends Shape {
   fun(){} \\A2
}
class Square extends Rect {
   fun(){} \\A3  
};

class Util{
  void fun(Shape shape){} //B1
  void fun(Rect rect){} //B2
  void fun(Square square){} //B3
};
void main(){
  Square square = new Square();
  Rect rect = square; 
  Shape shape = rect; 
// dynamic / runtime / over riding
  shape.fun();
  rect.fun();
  square.fun();
// static / coompile time/ over loading
  Util util = new Util(); 
  util.fun(shape);
  util.fun(rect);
  util.fun(square); 
}
//3.2.1. //3.3.3. //1.1.1
