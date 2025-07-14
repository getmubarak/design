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
// static / compile time/ over loading
  Util util = new Util(); 
  util.fun(shape);
  util.fun(rect);
  util.fun(square); 
}
//A1A2A3 //A3A3A3 //A1A1A1
//B1B2B3 //B3B3B3 //B1B1B1
