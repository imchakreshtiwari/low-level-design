package com.pattern.parkinglot;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLevel {

    private int floor;
    private List<ParkingSpot> parkingSpotList;

    public ParkingLevel(int floor, int numSpots) {
        this.floor = floor;
        parkingSpotList = new ArrayList<>(numSpots);
        for (int i = 0; i < numSpots; i++) {
            parkingSpotList.add(new ParkingSpot(i));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpotList) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));
        }
    }



}
