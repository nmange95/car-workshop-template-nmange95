# Car Workshop project
Welcome to the Car Garage project! This guide is designed to help you create a car garage management system that handles various types of vehicles, including Electric Vehicles (EVs), Artificial Intelligence (AI) cars, and regular cars. 


## Project Description
In this project, you will build a comprehensive car garage management system capable of accommodating three different vehicle types: 
1. Electric Vehicles (EVs)
2. Artificial Intelligence (AI) cars
3. regular cars 

**The owner wants to:**
1. Start the Vehicle
2. Drive the Vehicle
3. Know Max Speed of Vehicle
4. Purchase Price of Vehicle
5. Max Distance without stopping
6. Sell The Vehicle
7. Buy a Vehicle
8. Store Vehicles in the garage
9. preform Maintance on Vehicle

Each type will have its own unique properties and features, and your task is to implement classes to represent and manage these vehicles within a garage. Each type of vehicle will have it's own maintain schedule and downtime for vehicle maintainance




## Project Structure
Here's a suggested project structure for your Car Garage project:

carworkshop/
├── src/
│   ├── CarApp.java
│   ├── Vehicle.java
│   ├── Car.java
│   ├── ElectricVehicle.java
│   ├── AICar.java
│   ├── Garage.java
│   ├── Operation.java
│
├── README.md

**CarApp.java:** The entry point of your program where you'll interact with the Garage class and manage different types of cars.

**Vehicle.java:** An abstract class serving as the base class for all vehicle types (Car, ElectricVehicle, and AICar). It includes shared properties and methods.

**Car.java:** A class representing regular cars, inheriting from the Vehicle class.

**ElectricVehicle.java:** A class representing Electric Vehicles (EVs), also inheriting from the Vehicle class.

**AICar.java:** A class representing Artificial Intelligence (AI) cars, inheriting from the Vehicle class.

**Garage.java:** The class that represents the garage. It manages a collection of vehicles of various types and provides methods for adding, removing, and listing these vehicles.

**Operation.java** The class that allows the user to interact with the Garage.java, through a user interface.

## Project Tasks
Here are the tasks to complete for this project:

1. Create the abstract Vehicle class with shared properties and methods.

2. Implement the Car, ElectricVehicle, and AICar classes, each inheriting from the Vehicle class. These classes should include specific properties and methods for each vehicle type.

3. Add the Garage class to manage a collection of vehicles, including regular cars, EVs, and AI cars.

4. Implement methods in the Garage class for Buying, Selling, and listing vehicles of various types.

5. Create a user interface in the operation class to interact with the Garage class, allowing users to manage different types of cars.

6. Thoroughly test your program to ensure it functions correctly for all vehicle types.

## Add comments to your code to explain different parts of your project.