#### Drawing Library  ####

interface Shape{
  void draw();
  void fill();
}
class Rect extends Shape{
  void draw(){} //1
  void fill(){} //2
}
class Ellipse extends Shape{
  void draw(){} //3
  void fill(){} //4
}
####  Client ####
class Rotate
{
  void logic(Rect a) {} //5
  void logic(Ellipse b) {} //6
}

void do(Shape obj){
  obj.draw(); //<- logic 1 | logic 3 
  obj.fill(); //<- logic 2 | logic 4 
  Rotate rotate = new Rotate()
  rotate.logic(obj);  //<- ?
}
