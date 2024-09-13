package com.pattern.parkinglot;

public class ParkingDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingLevel level1 = new ParkingLevel(1, 100);
        ParkingLevel level2 = new ParkingLevel(2, 80);

        parkingLot.addLevel(level1);
        parkingLot.addLevel(level2);


        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Bike("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(car);

        // Display updated availability
        parkingLot.displayAvailability();

    }
}
