interface Action{
  void Collide(GameObject go1,GameObject go2);
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
      ... 
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         Action action = vtable.get(go1.getKey() + go2.getKey());
         action.Collide(go1,go2);
     }
}
