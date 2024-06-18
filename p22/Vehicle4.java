doCar(Vehicle vehicle){
    vehicle.lock();
    vehicle.go();
}
doShip(Vehicle vehicle){
     vehicle.balance();
     vehicle.swim();
}
doAirplane(Vehicle vehicle){
     vehicle.go();
     vehicle.fly();
}
doTank(Vehicle vehicle){
     vehicle.move();
     vehicle.stop();
     vehicle.fire();
}

execute(List<Vehicle> vehicles){
    for(Vehicle vehicle : vehicles) {
        if(vehicle.instanceof(Car))
            doCar( vehicle)
        if(vehicle.instanceof(Tank))
            doTank(vehicle)
            
        ....
    }
}
