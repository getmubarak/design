interface Vehicle{
  do();
  stop();
}
class Car implements Vehicle{
  do(){
     lock();
     go();
  }
  ...
}
class Ship implements Vehicle{
  do(){
     balance();
     swim();
  }
  ...
}
class Airplane implements Vehicle{
  do(){
     go();
     fly();
  }
  ...
}
class Tank implements Vehicle{
  do(){
     move();
     stop();
     fire();
  }
  ...
}

execute(List<Vehicle> vehicles){
    for(Vehicle vehicle : vehicles) {
        vehicle.do();
        vehicle.stop();
    }
}
