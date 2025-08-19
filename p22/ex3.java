class Shape{
   virtual rotate(){} \\A1
};
class Rect extends Shape {
   rotate(){} \\A2
}
class Square extends Rect {
   rotate(){} \\A3  
};

class Util{
  void fill(Shape shape){} //B1
  void fill(Rect rect){} //B2
  void fill(Square square){} //B3
};
void main(){
  Square square = new Square();
  Rect rect = square; 
  Shape shape = rect; 
// dynamic / runtime / over riding
  shape.rotate();
  rect.rotate();
  square.rotate();
// static / compile time/ over loading
  Util util = new Util(); 
  util.fill(shape);
  util.fill(rect);
  util.fill(square); 
}
//A1A2A3 //A3A3A3 //A1A1A1
//B1B2B3 //B3B3B3 //B1B1B1
