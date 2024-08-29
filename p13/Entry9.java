class NaturalObjectCollusionHandlers{
     public void AestroidCommetCollide(GameObject go1,GameObject go2) {}
     ...
}
class ManMadeCollusionHandlers{
     public void ShipStationCollide(GameObject go1,GameObject go2) {}
     public void AestroidStationCollide(GameObject go1,GameObject go2) {}
     public void CommetStationCollide(GameObject go1,GameObject go2) {}
     public void CommetShipCollide(GameObject go1,GameObject go2) {}
}

class Handler
{
     map<key,Lamda> vtable =new map<key,Lamda>();
     void Init() { 
      ManMadeCollusionHandlers handler = new ManMadeCollusionHandlers();
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
