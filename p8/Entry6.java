class CA{
}
class CB{
}
// choose parent at runtime ? 
class CX extends <runtime> {
}
CX o1 = new CX<CA>();
CX o2 = new CY<CB>();

// lazy load parent
class CX extends CA(?){
}

// change parent at runtime
class CX extends CA{
   ...
   if(cond)
    parent = new CB();
   ....
}

// multiple parent
class CX extends CA, CB {
}

