class Shape{}
class Rect extends Shape {}
class Square extends Rect {}

class Util{
  void fun(Shape shape){} //1
  void fun(Rect rect){} //2
  void fun(Square square){} //3
};


void DoJob(Shape shape){
  Util util = new Util();
  util.fun(shape);
}

void main(){
  DoJob(new Square());
}
//1. //2 //3
