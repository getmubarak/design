do(Car vehicle){
    vehicle.lock();
    vehicle.go();
}
do(Ship vehicle){
     vehicle.balance();
     vehicle.swim();
}
do(Airplane vehicle){
     vehicle.go();
     vehicle.fly();
}
do(Tank vehicle){
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
