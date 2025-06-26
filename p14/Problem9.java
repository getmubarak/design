interface Shape{
   draw();
}
class Rect implements Shape{
   draw(){...} //1
}
class Ellipse implements Shape{
   draw(){...} //2
}
----------------------------------
class RectEx extends Rect{
   fill(){...} //5
}
class EllipseEx extends Rect{
   fill(){...} //6
}

void DoJob(Shape shape){
   shape.draw(); // 1 | 2
   Rect --> RectEx
   Ellipse --> EllipseEx
   
}

