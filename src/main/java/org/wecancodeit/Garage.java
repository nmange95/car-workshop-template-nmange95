package org.wecancodeit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Garage class represents a storage facility for vehicles. It allows the
 * buying and selling of vehicles,
 * and provides methods to retrieve information about the vehicles stored in the
 * garage.
 */

public class Garage {
    private int carCounter = 1;
    private Map<Integer, Vehicle> garageMap = new HashMap<>();

    /**
     * Buys a new vehicle and adds it to the garage.
     *
     * @param vehicle The vehicle to be purchased and added to the garage.
     */

    public void buyVehicle(Vehicle vehicle) {
        vehicle.setVehicleID(carCounter++);
        garageMap.put(vehicle.getVehicleID(), vehicle);
    }

    /**
     * Retrieves the map of vehicles stored in the garage.
     *
     * @return A map containing the vehicles stored in the garage, with their unique
     *         IDs as keys.
     */

    public Map<Integer, Vehicle> getGarageMap() {
        return garageMap;
    }

    /**
     * Sells a vehicle and removes it from the garage.
     *
     * @param vehicleId The unique ID of the vehicle to be sold and removed from the
     *                  garage.
     */

    public void sellVehicle(int vehicleId) {
        garageMap.remove(vehicleId);
    }

    /**
     * Returns the number of cars currently stored in the garage.
     *
     * @return The number of cars in the garage.
     */

    public int carsInGarage() {
        return garageMap.size();
    }

    /**
     * prints summary of vehicles stored in the garage
     * each line will display the ID which is the key and the vehicle type
     */
    public void garageSummary() {
        if (garageMap.size() > 0) {
            for (Vehicle vehicle : garageMap.values()) {
                System.out.println("ID: " + vehicle.getVehicleID() + " " + vehicle.vehicleType());
            }
        }
    }

}