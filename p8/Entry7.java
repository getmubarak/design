
class Rect{
   ....
}
class Square extends Rect{
   ....
}

void do(Rect rect){
  rect.setWidth(2);
  rect.setHeight(4);
  area = rect.getArea();
  assert(area, 8);
  ... 
}
