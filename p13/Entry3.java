class Handler
{
     public void Invoke(Ship go1,Station go2) {}
     public void Invoke(Aestroid go1,Station go2) {}
     public void Invoke(Commet go1,Station go2) {}
     public void Invoke(Commet go1,Ship go2) {}
     ....


     public void Collide(GameObject go1,GameObject go2)
     {
        Handler handler = new Handler();
        if(go1 instanceod(Ship) && go2 instanceof(Station))
          handler.Invoke((Ship)go1,(Station)go2);
        if(go1 instanceod(Aestroid) && go2 instanceof(Station))
          handler.Invoke((Aestroid)go1,(Station)go2);
        ...  
     }
}
