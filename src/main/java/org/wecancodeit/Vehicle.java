package org.wecancodeit;

import java.util.Random;

/**
 * The Vehicle abstract class represents a general vehicle with common
 * properties and behaviors.
 */

public abstract class Vehicle {
    private Random random = new Random();
    private int maxSpeed;
    private int totalMileage = 0;
    private Manufacturer manufacturer;
    private int msrp;
    private BodyType bodyType;
    private Color color;
    private int maxRange;
    public boolean inGarage = true;
    private boolean running = false;
    private int currentDistance = 0;
    public String model;
    private int vehicleID;
    private VehicleType type;
    private boolean requiresMaintenance = false;
    private int timesReqMaint = 1;

    /**
     * Constructs a Vehicle object with initial properties.
     *
     * @param maxSpeed     The maximum speed of the vehicle.
     * @param totalMileage The total mileage of the vehicle.
     * @param manufacturer The manufacturer of the vehicle.
     * @param bodyType     The body type of the vehicle.
     * @param color        The color of the vehicle.
     * @param msrp         The Manufacturer's Suggested Retail Price (MSRP) of the
     *                     vehicle.
     * @param maxRange     The maximum range (for electric vehicles) of the vehicle.
     */

    public Vehicle(int maxSpeed, int totalMileage, Manufacturer manufacturer,
            BodyType bodyType, Color color, int msrp, int maxRange) {
        this.maxSpeed = maxSpeed;
        this.totalMileage = totalMileage;
        this.manufacturer = manufacturer;
        this.bodyType = bodyType;
        this.color = color;
        this.msrp = msrp;
        this.maxRange = maxRange;

    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public boolean isRequiresMaintenance() {
        return requiresMaintenance;
    }

    public int getTimesReqMaint() {
        return timesReqMaint;
    }

    public void setRequiresMaintenance(boolean requiresMaintenance) {
        this.requiresMaintenance = requiresMaintenance;
    }

    public void setTimesReqMaint(int timesReqMaint) {
        this.timesReqMaint = timesReqMaint;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setCurrentDistance(int d) {
        this.currentDistance = currentDistance + d;
    }

    public boolean isInGarage() {
        return inGarage;
    }

    public void outOfGarage() {
        this.inGarage = false;
    }

    public void inGarage() {
        this.inGarage = true;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMsrp() {
        return msrp;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(int n) {
        this.totalMileage += n;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public Color getColor() {
        return color;
    }

    public boolean isRunning() {
        return running;
    }

    public void startCar() {
        this.running = true;
    }

    public void turnOff() {
        this.running = false;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public abstract int maxDistance();

    public abstract void fillUp();

    public abstract void testDrive(int distance);

    public abstract String vehicleType();

    public abstract void vehicleMaintenance();

    public abstract void performMaintenance();

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    public void setInGarage(boolean inGarage) {
        this.inGarage = inGarage;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * reduces the price of the car based on MSRP and milleage and a random offset
     * of 10%
     * 
     * @return
     */
    public int sellPrice() {
        int range = (int) (0.10 * msrp);
        int randomOffset = random.nextInt(2 * range + 1) - range;
        if (totalMileage < 100000) {
            return ((int) ((msrp - 5000) - (totalMileage * 0.04)) + randomOffset);
        } else {
            return ((int) ((msrp - 8500) - (totalMileage * 0.020)) + randomOffset);
        }
    }

    @Override
    public String toString() {
        return "Vehicle maxSpeed=" + maxSpeed + ", currentMileage=" + totalMileage
                + ", manufacturer=" + manufacturer + ", msrp=" + msrp + ", bodyType=" + bodyType + ", color=" + color
                + ", maxRange=" + maxRange + ", inGarage=" + inGarage + ", running=" + running
                + ", currentDistance=" + currentDistance;
    }

}