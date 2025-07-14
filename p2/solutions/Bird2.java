interface Bird{
  Chirp
  void* Query(id);
}
interface FlyingBird extends Bird{
  fly
}
interface NestBuildingBird extends Bird{
  buildNest
}
interface FemaleBird extends Bird {
  layEggs
}

class FemaleParrot implements FlyingBird, NestBuildingBird, FemaleBird{
   ...
   void* Query(int id){
       if (id == ID_FlyingBird)
         return (FlyingBird*) this;
       if (id == ID_NestBuildingBird)
         return (NestBuildingBird*) this;
       if (id == ID_FemaleBird)
         return (FemaleBird*) this;

       throw new InterfaceNotSupportedException();
   }
}

fun(FemaleBird bird)
{
   bird.layEggs();
   FlyingBird* flyingBird = (FlyingBird*) bird.Query(ID_FlyingBird)
   flyingBird.fly();
}
