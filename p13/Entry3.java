class Handler
{
     public void Collide(Ship go1,Station go2) {}
     public void Collide(Aestroid go1,Station go2) {}
     public void Collide(Commet go1,Station go2) {}
     public void Collide(Commet go1,Ship go2) {}
     ....
}

     public void Invoke(GameObject go1,GameObject go2)
     {
        Handler handler = new Handler();
        if(go1 instanceod(Ship) && go2 instanceof(Statio))
          handler.Collide((Ship)go1,(Station)go2);
        ...  
     }
