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

void do(Shape obj){
  obj.draw(); //<- logic 1 | logic 3 
  obj.fill(); //<- logic 2 | logic 4 
  if(obj instanceof(Rect))
    ...logic 5 : rotate logic for Rect 
  if(obj instanceof(Ellipse))
    ...logic 6 : rotate logic for Ellipse 
}
