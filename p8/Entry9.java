class CA{
}
class CB{
}
//--------------------------------------
// 1. choose parent at runtime ? 
class CX extends <runtime> {
}
CX o1 = new CX<CA>();
CX o2 = new CX<CB>();

//-----------------------------------
// 2. lazy load parent
class CX extends CA(?){
}

//-----------------------------------
// 3. change parent at runtime
class CX extends CA{
   ...
   if(cond)
    parent = new CB();
   ....
}
//-----------------------------------
// 4. multiple parent
class CX extends CA, CB {
}

