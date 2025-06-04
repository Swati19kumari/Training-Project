package com.java.carrental.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.carrental.Bal.CarBal;
import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.model.Car;
import com.java.carrental.model.Status;

public class CarMain {
    static Scanner sc = new Scanner(System.in);
    static CarBal carBal = new CarBal();

    public static void main(String[] args) {
        while (true) {
        	System.out.println("===============================");
            System.out.println("\n=== Car Rental Management ===");
            System.out.println("===============================");
            System.out.println("1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. List Cars By Status");
            System.out.println("4. Find Car By ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addCar();
                        break;
                    case 2:
                        removeCar();
                        break;
                    case 3:
                        listCarsByStatus();
                        break;
                    case 4:
                        findCarById();
                        break;
                    case 5:
                        System.out.println("Exiting application.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void addCar() throws ClassNotFoundException, SQLException {
        Car car = new Car();
        System.out.print("Enter Vehicle No: ");
        car.setVehicleNo(sc.nextLine());
        System.out.print("Enter Make: ");
        car.setMake(sc.nextLine());
        System.out.print("Enter Model: ");
        car.setModel(sc.nextLine());
        System.out.print("Enter Year: ");
        car.setYear(sc.nextLine());
        System.out.print("Enter Daily Rate: ");
        car.setDailyRate(Double.parseDouble(sc.nextLine()));

        Status status = null;
        while (status == null) {
            System.out.print("Enter Status (AVAILABLE, NOTAVAILABLE): ");
            String input = sc.nextLine().toUpperCase().trim();  // Trim spaces
            try {
                status = Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status. Please enter AVAILABLE or NOTAVAILABLE.");
            }
        }
        car.setStatus(status);

     // Taking user input and parsing to integer safely
        System.out.print("Enter Passenger Capacity: ");
        String passengerCapacityInput = sc.nextLine().trim();  

        try {
            car.setPassengerCapacity(Integer.parseInt(passengerCapacityInput));  // Parse the cleaned input
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for passenger capacity.");
        }

        System.out.print("Enter Engine Capacity: ");
        car.setEngineCapacity(Integer.parseInt(sc.nextLine()));

       
        
        try {
            carBal.addCarBal(car);  // Assuming this calls addCarBal internally
            System.out.println("Car added successfully.");
        } catch (SQLException e) {
            System.out.println("Error with the database: " + e.getMessage());  // Print SQL exceptions
        } catch (CarNotFoundException e) {
            System.out.println("Car not found: " + e.getMessage());  // Print car not found exceptions
        } catch (Exception e) {
            System.out.println("Failed to add car: " + e.getMessage());  // Catch all other exceptions
        }
    }

    private static void removeCar() throws ClassNotFoundException, SQLException {
        System.out.print("Enter Vehicle No to remove: ");
        String vehicleNo = sc.nextLine();
        Car car = new Car();
        car.setVehicleNo(vehicleNo);

        carBal.carbal.removeCar(car);
    }

    private static void listCarsByStatus() throws ClassNotFoundException, SQLException {
        System.out.print("Enter status to filter (AVAILABLE, NOTAVAILABLE): ");
        String status = sc.nextLine().toUpperCase();
        List<Car> cars = carBal.carbal.listCarsByStatus(status);
        if (cars.isEmpty()) {
            System.out.println("No cars found with status: " + status);
        } else {
            for (Car c : cars) {
                System.out.println(c);
            }
        }
    }

    private static void findCarById() {
        System.out.print("Enter Vehicle ID: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Car> result = carBal.carbal.findCarById(id);
        if (result.isEmpty()) {
            System.out.println("No car found with ID: " + id);
        } else {
            System.out.println(result.get(0));
        }
    }
}
