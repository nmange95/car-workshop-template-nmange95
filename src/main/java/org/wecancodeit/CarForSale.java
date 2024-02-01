package org.wecancodeit;

import java.util.Random;

/**
 * This class represents a car available for sale. It generates a random car to
 * be offered for sale to the customer
 * all the cars values will be randomized with a higher likely hood of the car
 * being GAS then ELECTRIC followed by AI
 */

public class CarForSale {
    Vehicle carForSale;
    private Random random = new Random();
    Manufacturer[] list = Manufacturer.values();
    Manufacturer randManufacturer;
    BodyType[] bodyTypes = BodyType.values();
    BodyType randType;
    int maxSpeed;
    int msrp;
    int randRange;
    Color[] listColor = Color.values();
    Color randColor;

    /**
     * Constructs a CarForSale object and generates a car for sale.
     */

    public CarForSale() {
        generateCarToSell();
    }

    /**
     * Generates a vehicle to be sold and stores it in the carForSale field.
     *
     * @return The generated vehicle that is available for sale.
     */

    public Vehicle generateCarToSell() {

        int randNum = random.nextInt(0, 100);
        if (randNum >= 0 && randNum <= 65) {
            createVehicle(randNum);
            this.carForSale = new Car(maxSpeed, 0, randManufacturer, randType, randColor, msrp, randRange);
            System.out.println(((Car) carForSale).vehicleType());
        }
        if (randNum > 65 && randNum < 90) {
            createVehicle(randNum);
            this.carForSale = new ElectricVehicle(maxSpeed, 0, randManufacturer, randType, randColor, msrp, randRange);
            System.out.println(((ElectricVehicle) carForSale).vehicleType());
        }
        if (randNum > 89) {
            createVehicle(randNum);
            this.carForSale = new AICar(maxSpeed, 0, randManufacturer, randType, randColor, msrp, randRange);
            System.out.println(((AICar) carForSale).vehicleType());

        }

        return this.carForSale;
    }

    private void createVehicle(int n) {
        randManufacturer(n);
        randMaxSpeed(n);
        dealWithType();
        randMSRP();
        randRange(n);
        randColor();
    }

    private void randManufacturer(int n) {
        int randIndex;
        if (n >= 0 && n <= 65) {
            randIndex = random.nextInt(list.length - 1);
            this.randManufacturer = list[randIndex];
        } else {
            randIndex = random.nextInt(list.length);
            this.randManufacturer = list[randIndex];
        }
    }

    private void dealWithType() {
        int randIndex;
        if (randManufacturer == (list[6])) {
            randIndex = random.nextInt(bodyTypes.length - 1);
            this.randType = bodyTypes[randIndex];
        } else {
            randIndex = random.nextInt(bodyTypes.length);
            this.randType = bodyTypes[randIndex];
        }
    }

    private void randMSRP() {
        int value = 0;
        if (randManufacturer == list[6]) {
            value = random.nextInt(50000, 200000);
        }
        if (randType == bodyTypes[3]) {
            if (this.randManufacturer == list[6]) {
                value = random.nextInt(60000, 100000);
            } else {
                value = random.nextInt(45000, 150000);
            }
        } else if (randManufacturer == list[6]) {
            value = random.nextInt(45000, 133000);
        } else {
            value = random.nextInt(20000, 50000);
        }

        this.msrp = value;
    }

    private void randRange(int typeVehicle) {
        int range = 0;
        if (typeVehicle >= 0 && typeVehicle <= 65) {
            range = random.nextInt(250, 300);
        }
        if (typeVehicle > 65 && typeVehicle < 90) {
            range = random.nextInt(200, 400);
        }
        if (typeVehicle > 89) {
            range = random.nextInt(300, 500);
        }
        this.randRange = range;
    }

    private void randMaxSpeed(int typeVehicle) {
        int speed = 0;
        if (typeVehicle >= 0 && typeVehicle <= 65) {
            speed = random.nextInt(175, 250);
        }
        if (typeVehicle > 65 && typeVehicle < 90) {
            speed = random.nextInt(125, 170);
        }
        if (typeVehicle > 89) {
            speed = random.nextInt(125, 300);
        }
        this.maxSpeed = speed;
    }

    private void randColor() {
        int randIndex = random.nextInt(listColor.length);
        this.randColor = listColor[randIndex];
    }

}
