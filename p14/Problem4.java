#### Drawing Library  ####
interface Plugin{
  void visit(Rect rect);
  void visit(Ellipse ellipse);
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
    p.do(this);
  }
}
class Ellipse extends Shape{
  void draw(){} //3
  void fill(){} //4
  void call(Plugin p){
    p.do(this);
  }
}
####  Client ####
class Rotate implements Plugin
{
  void visit(Rect a) {} //5
  void visit(Ellipse b) {} //6
}

void do(Shape obj){
  obj.draw(); //<- logic 1 | logic 3 
  obj.fill(); //<- logic 2 | logic 4 
  
  Rotate rotate = new Rotate();
  rotate.logic(obj);  //<- error
  obj.visit(rotate);  //<- logic 5 | logic 6
}

