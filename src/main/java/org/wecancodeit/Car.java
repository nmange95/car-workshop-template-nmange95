package org.wecancodeit;

/**
 * The Car class represents a type of vehicle that runs on gasoline. It extends
 * the abstract Vehicle class
 * and provides specific implementations for gas-powered cars.
 */

public class Car extends Vehicle {

    /**
     * Constructs a Car object with specific properties.
     *
     * @param maxSpeed       The maximum speed of the car.
     * @param currentMileage The current mileage of the car.
     * @param manufacturer   The manufacturer of the car.
     * @param bodyType       The body type of the car.
     * @param color          The color of the car.
     * @param msrp           The Manufacturer's Suggested Retail Price (MSRP) of the
     *                       car.
     * @param maxRange       The maximum range (for gas cars) of the car.
     */

    public Car(int maxSpeed, int currentMileage, Manufacturer manufacturer, BodyType bodyType,
            Color color, int msrp, int maxRange) {
        super(maxSpeed, currentMileage, manufacturer, bodyType, color, msrp, maxRange);
        setType(VehicleType.GAS);
    }

    /**
     * Gets the maximum distance the car can travel.
     *
     * @return The maximum distance the car can travel.
     */

    @Override
    public int maxDistance() {
        return getMaxRange() - getCurrentDistance();
    }

    /**
     * Gets a description of the gas car's type and properties.
     *
     * @return A string describing the gas car, including its type, manufacturer,
     *         color, mileage, speed, range, and price.
     */

    @Override
    public String vehicleType() {
        return "Gas " + getBodyType() + " made by: " + getManufacturer() + " Color: " + getColor()
        + " Total Miles: " + getTotalMileage() + " Max Speed: " + getMaxSpeed()
        + " Max Range: " + getMaxRange() + " Purchase Price: " + getMsrp();
    }

    /**
     * Checks if the car needs maintenance based on its mileage and reduces the max
     * range if required.
     */

    @Override
    public void vehicleMaintenance() {
        if ((super.getTotalMileage() / super.getTimesReqMaint()) > 5000) {
            super.setRequiresMaintenance(true);
            super.setMaxRange(super.getMaxRange() - 50);
            System.out.println("Your vehicle needs maintenance max range is reduced.");
        }
    }

    /**
     * Simulates driving the car for a specified distance, updating the current
     * distance and turning off the car.
     *
     * @param dis The distance to drive the car.
     */

    public void drive(int dis) {
        if (dis <= maxDistance()) {
            System.out
                    .println("You take your " + getManufacturer() + " " + getBodyType() + " for a drive.");
            setCurrentDistance(dis);
            setTotalMileage(dis);
        } else if (dis > maxDistance()) {
            System.out.println("Your max range is " + maxDistance()
                    + " you will drive that far then you will have to fill up");
            setCurrentDistance(maxDistance());
            setTotalMileage(maxDistance());
        }
        System.out.println("Hope you had a nice drive");
    }

    public void fillUpGas() {
        setCurrentDistance(-getCurrentDistance());
        System.out.println("You filled up the tank range:" + getMaxRange());
    }

    @Override
    public void fillUp() {
        fillUpGas();
    }

    @Override
    public void testDrive(int distance) {
        drive(distance);
    }

    @Override
    public void performMaintenance() {
        setRequiresMaintenance(false);
        setTimesReqMaint(getTimesReqMaint() + 1);
        setMaxRange(getMaxRange() + 50);
    }

}
