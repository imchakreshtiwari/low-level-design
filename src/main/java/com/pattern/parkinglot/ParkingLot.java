package com.pattern.parkinglot;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ParkingLot {

    private static volatile ParkingLot instance;
    private final List<ParkingLevel> parkingLevels;

    private ParkingLot() {
        parkingLevels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {

        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels) {
            if(level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : parkingLevels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingLevel level : parkingLevels) {
            level.displayAvailability();
        }
    }

    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public void addLevel(ParkingLevel level) {
        parkingLevels.add(level);
    }
}
