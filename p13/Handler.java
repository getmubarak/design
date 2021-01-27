


class Handler
{
     public void Collide(GameObject go1,GameObject go2)
     {
          if(type(go1)==type(Ship) && type(go2)==type(Station))
          {
            //logic1
          }
           if(type(go1)==type(Station) && type(go2)==type(Aestroid))
          {
            //logic2
          }
           if(type(go1)==type(Ship) && type(go2)==type(Commet))
          {
            //logic3
          }
     }
}
