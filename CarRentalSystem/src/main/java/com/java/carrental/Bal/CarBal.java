package com.java.carrental.Bal;


import java.sql.SQLException;
import java.time.LocalDate;

import com.java.carrental.Dao.CarDao;
import com.java.carrental.Dao.CarDaoImple;
import com.java.carrental.exception.*;
import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.model.Car;
import com.java.carrental.Bal.*;


public class CarBal {


	    public static CarDao carbal;
	    static StringBuilder sb;

	    static {
	        carbal = new CarDaoImple();
	        sb = new StringBuilder();
	    }

	    public String addCarBal(Car car) throws CarNotFoundException, ClassNotFoundException, SQLException {
	        if (validateCar(car)) {
	            carbal.addCar(car);  
	            return "Car added successfully.";  // Return a success message
	        }
	        return "Car validation failed.";  // Explicit validation failure
	    }

	    // Similarly, you can add updateCarBal, deleteCarBal, searchCarBal etc.
	
		
		public static boolean validateCar(Car car) {
		    sb = new StringBuilder();
		    int currentYear = LocalDate.now().getYear();
		
		    try {
		        int carYear = Integer.parseInt(car.getYear());
		        if (currentYear - carYear > 10) {
		            sb.append("Car year must not be older than 10 years.\n");
		            return false;
		        }
		    } catch (NumberFormatException e) {
		        sb.append("Car year must be a valid number.\n");
		        return false;
		    }
		
		    if (car.getDailyRate() < 0) {
		        sb.append("Daily rate cannot be negative.\n");
		        return false;
		    }
		
		    if (car.getPassengerCapacity() < 0) {
		        sb.append("Passenger capacity cannot be negative.\n");
		        return false;
		    }
		
		    if (sb.length() > 0) {
		        System.out.println("Car validation failed:\n" + sb.toString().trim());
		        return false;
		    }
		
		    return true;
		}

}
