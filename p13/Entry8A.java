interface Action{
  void Collide(GameObject go1,GameObject go2);
}
class ShipCommet implements Action{
  static{
     vtable.add("ShipCommet", new  ShipCommet());
  }
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
class ShipStation implements Action{
   static{
     vtable.add("ShipStation", new  ShipStation());
  }
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
class CometStation implements Action{
   static{
     vtable.add("CometStation", new  CometStation());
  }
  void Collide(GameObject go1,GameObject go2){
    ... logic
  }
}
....
class Handler
{
     map<key,Action> vtable =new map<key,Action>();
     void Init() { 
        for(...)
          Class.forName(className);
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         string key = go1.getclassName() + go2.getclassName();
         if(! vtable.find(key))
             throw new CollisionHandlerNotFoundException();
         Action action = vtable.get(key);
         action.Collide(go1,go2);
     }
}
