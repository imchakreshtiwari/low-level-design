package com.pattern.parkinglot;

import lombok.Data;

@Data
public class ParkingSpot {

    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicleType = VehicleType.CAR;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == vehicleType) {
            parkedVehicle = vehicle;
        } else {
            System.out.println("No Space or unmatched vehicle type");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

}
