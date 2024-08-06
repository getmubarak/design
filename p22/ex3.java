class Shape{
   virtual fun(){} \\1
};
class Rect extends Shape {
   fun(){} \\2
}
class Square extends Rect {
   fun(){} \\3  
};

class Util{
  void fun(Shape shape){} //1
  void fun(Rect rect){} //2
  void fun(Square square){} //3
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
  Util util; 
  util.fun(shape);
  util.fun(rect);
  util.fun(square); 
}
//3.2.1. //3.3.3. //1.1.1
