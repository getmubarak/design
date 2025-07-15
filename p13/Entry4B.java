interface GameObject{
  void Handle(GameObject go2);
  void CollideStation(GameObject go2);
  void CollideCommet(GameObject go2);
  void CollideAestroid(GameObject go2);
  void CollideShip(GameObject go2);
}


class Ship extends GameObject{
  void Handle(GameObject go2){ //1
    go2.collideShip(this);
  }
  void CollideStation(GameObject go2){ //2
    // logic to  collide ship and station
  }
  void CollideCommet(GameObject go2){ //3
    // logic to  collide ship and Commet
  }
  void CollideAestroid(GameObject go2){ //4
    // logic to  collide ship and Aestroid
  }
  void CollideShip(GameObject go2){ //5
    // logic to  collide ship and Ship
  }
}

class Comet extends GameObject{
  void Handle(GameObject go2){
    go2.collideCommet(this);
  }
  void CollideShip(GameObject go2){
    // logic to  collide commet and ship
  }
  void CollideStation(GameObject go2){
    // logic to  collide commet and station
  }
  void CollideCommet(GameObject go2){
    // logic to  collide commet and Commet
  }
  void CollideAestroid(GameObject go2){
    // logic to  collide commet and Aestroid
  }
  
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Handle(go2);
     }
}
