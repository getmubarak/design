class Handler
{
     map<key,Lamda> vtable =new map<key,Lamda>();
     void Init() { 
      vtable.add("ShipStation",()-> invoke logic );
      vtable.add("ShipShip",()-> invoke logic );
      ...
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         Lamda fun = vtable.get(go1.getKey() + go2.getKey());
         fun(go1,go2);
     }
}
