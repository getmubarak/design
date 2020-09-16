do(Car v){
    vehicle.lock();
    vehicle.go();
}
do(Ship v){
     vehicle.balance();
     vehicle.swim();
}
do(Airplane v){
     vehicle.go();
     vehicle.fly();
}
do(Tank v){
     vehicle.move();
     vehicle.stop();
     vehicle.fire();
}

execute(List<Vehicle> vehicles){
    for(Vehicle vehicle : vehicles) {
        if(vehicle.instanceof(Car))
            do((Car) vehicle)
        if(vehicle.instanceof(Tank))
            do((Tank) vehicle)
            
        ....
    }
}
