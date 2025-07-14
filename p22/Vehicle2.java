do(Car car){
    car.lock();
    car.go();
}
do(Ship ship){
     ship.balance();
     ship.swim();
}
do(Airplane airplane){
     airplane.go();
     airplane.fly();
}
do(Tank tank){
     tank.move();
     tank.stop();
     tank.fire();
}

execute(List<Vehicle> vehicles){
    for(Vehicle vehicle : vehicles) {
        do(vehicle);
        vehicle.stop();
    }
}
