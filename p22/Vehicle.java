for(Vehicle vehicle : vehicles) {
    switch(vehicle.getType()) {
        case CAR:
            vehicle.lock();
            vehicle.go();
            break;
        case SHIP:
            vehicle.balance();
            vehicle.swim();
            break;
        case AIRPLANE:
            vehicle.go();
            vehicle.fly();
            break;
        case TANK:
            vehicle.move();
            vehicle.stop();
            vehicle.fire();
            break;
    }
    vehicle.stop();    
}
