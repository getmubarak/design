

class Ship extends GameObject{
  void Handle(GameObject go2){ //1
    go2.collideShip(this);
  }
  void CollideStation(Station go2){ //2
    // logic to  collide ship and station
  }
  void CollideCommet(Commet go2){ //3
    // logic to  collide ship and Commet
  }
  void CollideAestroid(Aestroid go2){ //4
    // logic to  collide ship and Aestroid
  }
  void CollideShip(Ship go2){ //5
    // logic to  collide ship and Ship
  }
}

class Comet extends GameObject{
  void Handle(GameObject go2){
    go2.collideCommet(this);
  }
  void CollideShip(Ship go2){
    // logic to  collide station and ship
  }
  void CollideStation(Station go2){
    // logic to  collide station and station
  }
  void CollideCommet(Commet go2){
    // logic to  collide station and Commet
  }
  void CollideAestroid(Aestroid go2){
    // logic to  collide station and Aestroid
  }
  
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Handle(go2);
     }
}
