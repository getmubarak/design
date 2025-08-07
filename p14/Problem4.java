#### Drawing Library  ####
interface Visitor{
  void visitRect();
  void visitEllipse();
}

interface Shape{
  void draw();
  void fill();
  void accept(Visitor v);
}
class Rect extends Shape{
  void draw(){} //1
  void fill(){} //2
  void accept(Visitor v){
    v.visitRect();
  }
}
class Ellipse extends Shape{
  void draw(){} //3
  void fill(){} //4
  void accept(Visitor v){
    v.visitEllipse();
  }
}
####  Client ####
class Rotate implements Plugin
{
  void visitRect() {} //5
  void visitEllipse() {} //6
}

void do(Shape obj){
  obj.draw(); //<- logic 1 | logic 3 
  obj.fill(); //<- logic 2 | logic 4 
  
  Rotate rotate = new Rotate();
  rotate.visitXXX();  //<- error
  obj.accept(rotate);  //<- logic 5 | logic 6
}

