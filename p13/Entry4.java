interface GO{
  void Collide(GameObject go2);
}

class Ship extends GO{
  void Collide(GameObject go2){
    //this is ship
    if(go2 is instanceof(Station))
      ...logic of ship with station
    if(go2 is instanceof(Commet))
      ...logic of ship with commet
    if(go2 is instanceof(Aestroid))
      ...logic of ship with aestroid
  }
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Collide(go2);
     }
}
