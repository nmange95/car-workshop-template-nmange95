package org.wecancodeit;

import java.util.Random;

/**
 * The AICar class represents a type of vehicle that is AI-driven. It extends
 * the abstract Vehicle class
 * and provides specific implementations for AI-driven cars.
 */

public class AICar extends Vehicle {

    private Random random = new Random();

    /**
     * Constructs an AICar object with specific properties.
     *
     * @param maxSpeed       The maximum speed of the AI car.
     * @param currentMileage The current mileage of the AI car.
     * @param manufacturer   The manufacturer of the AI car.
     * @param bodyType       The body type of the AI car.
     * @param color          The color of the AI car.
     * @param msrp           The Manufacturer's Suggested Retail Price (MSRP) of the
     *                       AI car.
     * @param maxRange       The maximum range (for electric AI cars) of the AI car.
     */

    public AICar(int maxSpeed, int currentMileage, Manufacturer manufacturer, BodyType bodyType,
            Color color, int msrp, int maxRange) {
        super(maxSpeed, currentMileage, manufacturer, bodyType, color, msrp, maxRange);
        setType(VehicleType.AICAR);
    }

    /**
     * Gets the maximum distance the AI car can travel.
     *
     * @return The maximum distance the AI car can travel.
     */

    @Override
    public int maxDistance() {
        return getMaxRange() - getCurrentDistance();
    }

    /**
     * Gets a description of the AI car's type and properties.
     *
     * @return A string describing the AI car, including its type, manufacturer,
     *         color, mileage, speed, range, and price.
     */

    @Override
    public String vehicleType() {
        return "AI driven " + getBodyType() + " " + getManufacturer() + " Color: " + getColor()
                + " Total Miles: " + getTotalMileage() + " Max Speed: " + getMaxSpeed()
                + " Max Range: " + getMaxRange() + " Purchase Price: " + getMsrp();
    }

    /**
     * Checks if the AI car needs maintenance based on its mileage, and performs
     * maintenance if required.
     */

    @Override
    public void vehicleMaintenance() {
        if ((getTotalMileage() / getTimesReqMaint()) > 5000) {
            performMaintenance();
        }
    }

    /**
     * Simulates the AI car self-driving and taking a joyride.
     */

    public void selfDrive() {
        int joyRide = random.nextInt(10, maxDistance());
        System.out.println("Your AI car drives you around town for " + joyRide + " miles.");
        setTotalMileage(joyRide);
    }

    public void fillUpCar() {
        setCurrentDistance(-getCurrentDistance());
        System.out.println("The AI filled up your tank Max Range = " + getMaxRange());
    }

    /**
     * Fills up the AI car's tank and resets its current distance.
     */

    @Override
    public void fillUp() {
        fillUpCar();
    }

    /**
     * Simulates a test drive of the AI car by self-driving it.
     *
     * @param distance The distance to test drive the AI car.
     */

    @Override
    public void testDrive(int distance) {
        selfDrive();
    }

    /**
     * Performs maintenance on the AI car and resets the maintenance flag.
     */

    @Override
    public void performMaintenance() {
        System.out.println("Your AI took care of all required maintenance while you were away.");
        setRequiresMaintenance(false);
    }

}
