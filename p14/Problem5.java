#### Drawing Library  ####
interface Plugin{
  void visitRect();
  void visitEllipse();
}

interface Shape{
  void draw();
  void fill();
  void call(Plugin plugin);
}
class Rect extends Shape{
  void draw(){} //1
  void fill(){} //2
  void call(Plugin p){
    p.visitRect();
  }
}
class Ellipse extends Shape{
  void draw(){} //3
  void fill(){} //4
  void call(Plugin p){
    p.visitEllipse();
  }
}
####  Client ####
class Rotate implements Plugin
{
  void visitRect() {} //5
  void visitEllipse() {} //6
}
class Zoom implements Plugin
{
  void visitRect() {} //7
  void visitEllipse() {} //8
}

void do(Shape obj){
  obj.draw(); //<- logic 1 | logic 3 
  obj.fill(); //<- logic 2 | logic 4 
  
  Rotate rotate = new Rotate();
  obj.call(rotate);  //<- logic 5 | logic 6

  Zoom zoom = new Zoom();
  obj.call(zoom);  //<- logic 7 | logic 8
}
