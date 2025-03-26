interface Plugin{
  void doSquare();
  void doElipse();
}
interface Shape {
  void draw();
  void call(Plugin p);
}
class Square extends Shape{
  void draw(){} //1
  void call(Plugin p){
    p.doSquare();
  }
}
class Elipse extends CA{
  void draw(){} //2
  void call(Plugin p){
    p.doElipse();
  }
}
//----------------------------------
class Rotate implements Plugin
{
  void doSquare() {} //3
  void doElipse() {} //4
}
//----------------------------------
void do(Shape obj){
  obj.draw(); //<- 1 |2
  
  Rotate rotate = new Rotate();
  obj.call(rotate); //<- 3 | 4
}
