package com.pattern.parkinglot;

import lombok.Data;

@Data
public class Vehicle {

    private String registrationNumber;
    private long entryTime;
    private long exitTime;

    private VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
}
