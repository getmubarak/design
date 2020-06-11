class Handler
{
     map<key,Lamda> vtable =new map<key,Lamda>();
     void Init() { 
      vtable.add("ShipStation",()-> logic );
      vtable.add("ShipShip",()-> logic );
      ...
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         Action action = vtable.get(go1.getKey() + go2.getKey());
         action.Collide(go1,go2);
     }
}
