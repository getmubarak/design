interface Bird{
  Chirp
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
}

fun(? bird)
{
   bird.layEggs();
   bird.fly();
}
