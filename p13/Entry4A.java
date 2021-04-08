@Author: Yash

class Ship extends GO{
  void Collide(GameObject go2){
    go2.collide(this);
  }
  void Collide(Station go2){
    // logic to  collide ship and station
  }
}

class Station extends GO{
  void Collide(GameObject go2){
    go2.collide(this);
  }
  void Collide(Ship go2){
    // logic to  collide ship and station
  }
}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          go1.Collide(go2);
     }
}
