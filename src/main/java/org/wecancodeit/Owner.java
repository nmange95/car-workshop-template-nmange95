package org.wecancodeit;

import java.util.Scanner;

/**
 * The Owner class represents an owner of a garage and provides various actions
 * the owner can perform.
 */

public class Owner {
    Garage garage;
    boolean usingApp = true;
    private Scanner scanner = new Scanner(System.in);
    private CarForSale carForSale = new CarForSale();
    int carValue;
    boolean sold = false;

    /**
     * will hold possible owner actions and deal with input from owner of garage.
     */

    public void ownerAction() {
        this.garage = new Garage();
        do {
            userAction();
        } while (usingApp);
    }

    /**
     * prints the initial menu
     */

    private void printMenu() {
        System.out.println("Welcome to the garage select an action:");
        System.out.println("1. Print a summary of the cars in your garage");
        System.out.println("2. Buy a new car");
        System.out.println("3. Select an Individual car");
        System.out.println("4. Exit application");
    }

    /**
     * deals with the users actions for printing garage summary, buy car, sell car,
     * single car action close application.
     */

    private void userAction() {
        while (true) {
            printMenu();
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "1":
                    if (garage.carsInGarage() >= 1) {
                        garage.garageSummary();
                    } else {
                        System.out.println("You have no cars in your garage; try buying one!");
                    }
                    break;
                case "2":
                    buyCar();
                    break;
                case "3":
                    singleCarAction();
                    break;
                case "4":
                    System.out.println("You've closed the application; have a nice day.");
                    usingApp = false;
                    break;
                default:
                    System.out.println("Invalid input; try again");
            }
        }
    }

    /**
     * handles purchasing of a car
     */

    private void buyCar() {
        Vehicle saleCar = carForSale.generateCarToSell();
        saleCar.vehicleType();
        System.out.println("Would you like to buy this car? y/n");
        String input = scanner.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("y")) {
                break;
            }
            if (input.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Enter 'y' or 'n'");
        }
        if (input.equalsIgnoreCase("y")) {
            garage.buyVehicle(saleCar);
        } else {
            System.out.println("Have a nice day.");
        }
    }

    /**
     * deals with actions for a single car
     */
    private void singleCarAction() {
        System.out.println("What car would you like to select?");
        carActions(selectACar());
    }

    /**
     * pick an individual car
     */
    private Vehicle selectACar() {
        System.out.println("Select a car by entering its ID: ");
        Vehicle selectedCar;
        sold=false;
        while (true) {
            garage.garageSummary();
            System.out.print("Select Vehicle: ");
            String sValue = scanner.nextLine();
            this.carValue = Integer.parseInt(sValue);
            selectedCar = garage.getGarageMap().get(carValue);
            if (selectedCar != null) {
                System.out.println("You selected: " + selectedCar.vehicleType());
                break;
            } else {
                System.out.println("Invalid car ID. Please select a valid car.");
            }
        }
        return selectedCar;
    }

    /**
     * lists all your actions for a single car
     * 
     * @param c
     */
    private void carActions(Vehicle c) {
        while (!sold) {
            System.out.println("What would you like to do with your car?");
            System.out.println("1. Take car out of garage");
            System.out.println("2. look at max speed of the car");
            System.out.println("3. see summary");
            System.out.println("4. do nothing");
            System.out.print("Action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1": {
                    c.outOfGarage();
                    takenOutAction(c);
                    break;
                }
                case "2": {
                    System.out.println("Max Speed: " + c.getMaxSpeed());
                    break;
                }
                case "3": {
                    System.out.println(c.vehicleType());
                    break;
                }
                case "4": {
                    break;
                }
                default:
                    continue;
            }
            if (action.equals("4")) {
                break;
            }
        }
    }

    /**
     * prints a menu for user actions
     * 
     * @param c
     */
    private void outOfGarageActionsMenu() {
        System.out.println("What would you like to do.");
        System.out.println("1. start car");
        System.out.println("2. check for maintenance");
        System.out.println("3. sell car");
        System.out.println("4. put car back in garage");
    }

    /**
     * handles all the actions when the vehicle is out of the garage
     * 
     * @param c
     */
    public void takenOutAction(Vehicle c) {
        c.outOfGarage();
        while (!c.inGarage && !sold) {
            outOfGarageActionsMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    switch (c.getType()) {
                        case GAS:
                            carRide(c);
                            break;
                        case ELECTRIC:
                            eVRide(c);
                            break;
                        case AICAR:
                            aIRide(c);
                            break;
                    }
                    break;
                case "2":
                    c.vehicleMaintenance();
                    if (c.isRequiresMaintenance()) {
                        while (true) {
                            System.out.println("Would you like to perform Maintenance? (y/n)");
                            String prefMaint = scanner.nextLine();
                            if (prefMaint.equalsIgnoreCase("y")) {
                                c.performMaintenance();
                                break;
                            } else if (prefMaint.equalsIgnoreCase("n")) {
                                System.out.println("You performed no maintenance on your vehicle.");
                                break;
                            } else {
                                System.out.println("Invalid input");
                            }
                        }
                    } else {
                        System.out.println("Your car required no maintenance");
                    }
                    break;
                case "3":
                    int value = c.sellPrice();
                    System.out.println("Would you like to sell the vehicle for " + value + "? (y/n)");
                    while (true) {
                        String toSell = scanner.nextLine();
                        if (toSell.equalsIgnoreCase("y")) {
                            garage.sellVehicle(carValue);
                            System.out.println("You sold the car");
                            sold=true;
                            break;
                        } else {
                            System.out.println("Have a nice day.");
                            break;
                        }
                    }
                    break;
                case "4":
                    c.inGarage();
                    System.out.println("You put the car back in the garage.");
                    break;
                default:
                    System.out.println("Invalid input, please try again: ");
            }
        }
    }

    /**
     * Simulates a ride with a gas vehicle.
     * 
     * @param c The selected car.
     */

    public void carRide(Vehicle c) {
        System.out.println("You push a button and the car roars to life");
        c.startCar();
        String input = "";
        while (true) {
            System.out.println("Would you like to go for a drive? y/n");
            if (input.equals("")) {
                input = scanner.nextLine();
            }
            if (input.equalsIgnoreCase("y")) {
                System.out.println("How far would you like to drive? current range is " + c.maxDistance());
                String sDistance = scanner.nextLine();
                int distance = Integer.parseInt(sDistance);
                c.testDrive(distance);
                System.out.println("1. Fill up vehicle");
                System.out.println("2. to go for another drive");
                System.out.println("3. turn off car");
                String secInput = scanner.nextLine();
                switch (secInput) {
                    case "1": {
                        c.fillUp();
                        input = "";
                        break;
                    }
                    case "2": {
                        input = "y";
                        break;
                    }
                    case "3": {
                        input = "n";
                        c.turnOff();
                        break;
                    }
                }
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("You turn off the car");
                c.turnOff();
                break;
            } else {
                System.out.println("invalid input.");
            }
        }
    }

    /**
     * Simulates a ride with an electric vehicle.
     * 
     * @param c The selected car.
     */

    public void eVRide(Vehicle c) {
        System.out.println("You push a button and the car hums to life");
        c.startCar();
        String input = "";
        while (true) {
            System.out.println("Would you like to go for a drive? y/n");
            if (input.equals("")) {
                input = scanner.nextLine();
            }
            if (input.equalsIgnoreCase("y")) {
                System.out.println("How far would you like to drive? current range is " + c.maxDistance());
                String sDistance = scanner.nextLine();
                int distance = Integer.parseInt(sDistance);
                c.testDrive(distance);
                System.out.println("1. Charge vehicle");
                System.out.println("2. to go for another drive");
                System.out.println("3. turn off car");
                String secInput = scanner.nextLine();
                switch (secInput) {
                    case "1": {
                        c.fillUp();
                        input = "";
                        break;
                    }
                    case "2": {
                        input = "y";
                        break;
                    }
                    case "3": {
                        input = "n";
                        c.turnOff();
                        break;
                    }
                }
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("You turn off the car");
                c.turnOff();
                break;
            } else {
                System.out.println("invalid input.");
            }
        }
    }

    /**
     * Simulates a ride with an AI-controlled car.
     * 
     * @param c The selected car.
     */

    public void aIRide(Vehicle c) {
        System.out.println("You sit down and the car's AI welcomes you while turning on automatically");
        c.startCar();
        String input = "";
        while (true) {
            System.out.println("Would you the AI to drive you around town? y/n");
            if (input.equals("")) {
                input = scanner.nextLine();
            }
            if (input.equalsIgnoreCase("y")) {
                c.testDrive(0);
                System.out.println("1. Fill up vehicle");
                System.out.println("2. to go for another drive");
                System.out.println("3. turn off car");
                String secInput = scanner.nextLine();
                switch (secInput) {
                    case "1": {
                        c.fillUp();
                        input = "";
                        break;
                    }
                    case "2": {
                        input = "y";
                        break;
                    }
                    case "3": {
                        input = "n";
                        c.turnOff();
                        break;
                    }
                }
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("You turn off the car");
                c.turnOff();
                break;
            } else {
                System.out.println("invalid input.");
            }
        }
    }

}
