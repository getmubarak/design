interface Parent{
}
class CA implements Parent{
}
class CB implements Parent{
}
// choose parent at runtime ? 
class CX  {
  Parent parent;
}
CX o1 = new CX(new CA);
CX o2 = new CX(new CB);

// lazy load parent
class CX {
  Parent parent;
  
  ....
    parent = new CA();
  ...
}

// change parent at runtime
class CX {
   Parent parent;
   ...
   if(cond)
    parent = new CB();
   ....
}

// multiple parent
class CX {
  List<Parent> parent;
}
