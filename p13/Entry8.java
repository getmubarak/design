interface Action{
  void Collide(GameObject go1,GameObject go2);
}
class ShipCommet implements Action{
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
class ShipStation implements Action{
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
class CometStation implements Action{
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
....
class Handler
{
     map<key,Action> vtable =new map<key,Action>();
     void Init() { 
      vtable.add("ShipStation", new  ShipStation());
      vtable.add("ShipCommet", new  ShipCommet());
      ... 
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         Action action = vtable.get(go1.getclassName() + go2.getclassName());
         action.Collide(go1,go2);
     }
}
