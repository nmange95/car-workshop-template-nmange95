package org.wecancodeit;

/**
 * The ElectricVehicle class represents a type of vehicle that is
 * electric-powered. It extends the abstract Vehicle class
 * and provides specific implementations for electric vehicles.
 */

public class ElectricVehicle extends Vehicle {

    /**
     * Constructs an ElectricVehicle object with specific properties.
     *
     * @param maxSpeed       The maximum speed of the electric vehicle.
     * @param currentMileage The current mileage of the electric vehicle.
     * @param manufacturer   The manufacturer of the electric vehicle.
     * @param bodyType       The body type of the electric vehicle.
     * @param color          The color of the electric vehicle.
     * @param msrp           The Manufacturer's Suggested Retail Price (MSRP) of the
     *                       electric vehicle.
     * @param maxRange       The maximum range (for electric vehicles) of the
     *                       electric vehicle.
     */

    public ElectricVehicle(int maxSpeed, int currentMileage, Manufacturer manufacturer, BodyType bodyType,
            Color color, int msrp, int maxRange) {
        super(maxSpeed, currentMileage, manufacturer, bodyType, color, msrp, maxRange);
        setType(VehicleType.ELECTRIC);
    }

    @Override
    public int maxDistance() {
        return getMaxRange() - getCurrentDistance();
    }

    /**
     * prints out the vehicles information
     */
    @Override
    public String vehicleType() {
        return "Electric " + getBodyType() + " made by: " + getManufacturer() + " Color: " + getColor()
                + " Total Miles: " + getTotalMileage() + " Max Speed: " + getMaxSpeed()
                + " Max Range: " + getMaxRange() + " Purchase Price: " + getMsrp();
    }

    /**
     * will set required maintenance to true if parameters are met
     */
    @Override
    public void vehicleMaintenance() {
        if ((getTotalMileage() / getTimesReqMaint()) > 5000) {
            setRequiresMaintenance(true);
            setMaxRange(getMaxRange() - 50);
            System.out.println("Your vehicle needs maintenance max range is reduced.");
        }
    }

    /**
     * preforms maintenance on your EV giving you back full driving range
     */
    @Override
    public void performMaintenance() {
        setRequiresMaintenance(false);
        setTimesReqMaint(getTimesReqMaint() + 1);
        setMaxRange(getMaxRange() + 50);
    }

    public void drive(int dis) {
        if (dis <= maxDistance()) {
            System.out
                    .println("You take your " + getManufacturer() + " " + getBodyType() + " for a drive.");
            setCurrentDistance(dis);
            setTotalMileage(dis);
        } else {
            dis = maxDistance();
            System.out.println("You take your car for a " + dis + " mile ride and need to charge it to go farther");
            setCurrentDistance(dis);
            setTotalMileage(dis);
        }
    }

    public void charge() {
        System.out.println("Your car is charging please wait...");
        try {
            for (int x = 0; x < 30; x++) {
                System.out.print("*");
                Thread.sleep(1000);
            }
            System.out.println();
            setCurrentDistance(-getCurrentDistance());
            System.out.println("Charging complete! Max mileage " + getMaxRange());

        } catch (InterruptedException e) {
        }
    }

    @Override
    public void fillUp() {
        charge();
    }

    @Override
    public void testDrive(int distance) {
        drive(distance);
    }

}
