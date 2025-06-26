interface Visitor{
   rectFun();
   ellipseFun();
}
interface Shape{
   draw();
   accept(Visitor v);
}
class Rect implements Shape{
   draw(){...} //1
   accept(Visitor v){
     v.rectFun();
   }
}
class Ellipse implements Shape{
   draw(){...} //2
   accept(Visitor v){
     v.ellipseFun();
   }
}
----------------------------------

void DoJob(Shape shape){
   shape.draw(); // 1 | 2
   FillShape fill = new FillShape();
   fill.?
   shape.accept(fill); // 5 | 6
   if(typeof(shape) == typeof(Rect)){
      //rotate logic for RECT  3
   }
   if(typeof(shape) == typeof(Ellipse)){
      //rotate logic for ELLIPSE 4
   }
}

class FillShape implements Visitor{
   rectFun(){
      //fill logic for RECT 5
   }
   ellipseFun(){
      //fill logic for ELLIPSE 6
   }
}
