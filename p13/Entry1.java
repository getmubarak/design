interface GameObject{ }
class Ship extends GameObject{}
class Station extends GameObject{}
class Commet extends GameObject{}
class Aestroid extends GameObject{}

class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          if(type(o1)==type(Ship) && type(o2)==type(Station))
          {
            //logic1
          }
           if(type(o1)==type(Station) && type(o2)==type(Aestroid))
          {
            //logic2
          }
           if(type(o1)==type(Ship) && type(o2)==type(Commet))
          {
            //logic3
          }
     }
}
