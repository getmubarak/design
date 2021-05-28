class Handlers{
     public void ShipStationCollide(Ship go1,Station go2) {}
     public void AestroidStationCollide(Aestroid go1,Station go2) {}
     public void CommetStationCollide(Commet go1,Station go2) {}
     public void CommetShipCollide(Commet go1,Ship go2) {}
}

class Handler
{
     map<key,Lamda> vtable =new map<key,Lamda>();
     void Init() { 
      Handler handler = new Handler();
      vtable.add("ShipStation",(go1,go2)-> handler.ShipStationCollide(go1,go2) );
      vtable.add("ShipShip",(go1,go2)-> handler.ShipShipCollide(go1,go2));
      ...
     }
     public void Collide(GameObject go1,GameObject go2)
     {
         Lamda fun = vtable.get(go1.getKey() + go2.getKey());
         fun(go1,go2);
     }
}
