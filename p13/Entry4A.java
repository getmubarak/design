@Author: Yash

class Ship extends GO{
  void Collide(GameObject go2){
    go2.collide(this);
  }
  void Collide(Station go2){
    // logic to  collide ship and station
  }
  void Collide(Commet go2){
    // logic to  collide ship and Commet
  }
  void Collide(Aestroid go2){
    // logic to  collide ship and Aestroid
  }
  void Collide(Ship go2){
    // logic to  collide ship and Ship
  }
}

class Comet extends GO{
  void Collide(GameObject go2){
    go2.collide(this);
  }
  void Collide(Ship go2){
    // logic to  collide station and ship
  }
  void Collide(Station go2){
    // logic to  collide station and station
  }
  void Collide(Commet go2){
    // logic to  collide station and Commet
  }
  void Collide(Aestroid go2){
    // logic to  collide station and Aestroid
  }
  
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Collide(go2);
     }
}
