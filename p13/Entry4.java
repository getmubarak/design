
class Ship extends GO{
  void Collide(GameObject go2){
    //go1 is ship
    if(go2 is instanceof(Station))
      ...logic of ship with station
    ...
  }
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Collide(go2);
     }
}
