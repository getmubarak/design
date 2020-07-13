class CA{
  void b1(data){ //logic }
}
class CB{
  void b1(data){ //logic }
}
class CC{
  void b1(data){ //logic }
}
//*********************
interface IX{
   void b1(data);
};
class CA implements IX{
  void b1(data){ //logic }
}
class CB implements IX{
  IX ref;
  void b1(data){ 
    if(!cond)
      return ref.b1(data);
    //logic 
  }
}
class CC implements IX{
  IX ref;
  void b1(data){ 
    if(!cond)
      return ref.b1(data);
    //logic 
  }
}
IX x = new CC(new CB(new CA()));
c.b1();
