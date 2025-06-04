package com.java.carrental.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.model.Car;
import com.java.carrental.model.Status;
import com.java.carrental.util.ConnectionHelper;

 public class CarDaoImple implements CarDao {

	static Connection con;
	static PreparedStatement psmt;
	@Override
	public void addCar(Car car) throws ClassNotFoundException, SQLException {
	 String cmd = "INSERT INTO Vehicle(vehicleNo, make, model, year, dailyRate, status, passengerCapacity, engineCapacity) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    con = ConnectionHelper.getConnection();
    psmt = con.prepareStatement(cmd);

    psmt.setString(1, car.getVehicleNo());
    psmt.setString(2, car.getMake());
    psmt.setString(3, car.getModel());
    psmt.setString(4, car.getYear());
    psmt.setDouble(5, car.getDailyRate());
    psmt.setString(6, car.getStatus().toString());
    psmt.setInt(7, car.getPassengerCapacity());
    psmt.setInt(8, car.getEngineCapacity());

    int rows = psmt.executeUpdate();
    if (rows > 0) {
        System.out.println("Car added successfully.");
    }
    else {
        System.out.println("Car was not added; no rows affected.");
    }
		
	}
	@Override
	public void removeCar(Car car) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		  String cmd = "DELETE FROM Vehicle WHERE vehicleNo = ?";

	          con = ConnectionHelper.getConnection();
	               psmt = con.prepareStatement(cmd);

	             psmt.setString(1, car.getVehicleNo());

	             int rows = psmt.executeUpdate();
	             if (rows > 0) {
	                 System.out.println("Car removed successfully.");
	             } else {
	                 System.out.println("Car not found with vehicleNo: " + car.getVehicleNo());
	             }
	         } 
		
	
	@Override
	public List<Car> listCarsByStatus(String status) throws ClassNotFoundException, SQLException {
		
		 List<Car> cars = new ArrayList<>();
         String cmd = "SELECT * FROM Vehicle WHERE status = ?";

         con = ConnectionHelper.getConnection();
         psmt = con.prepareStatement(cmd);
         psmt.setString(1, status);

         ResultSet rs = psmt.executeQuery();

         while (rs.next()) {
             Car car = new Car();
             car.setVehicleId(rs.getInt("vehicleID"));
             car.setVehicleNo(rs.getString("vehicleNo"));
             car.setMake(rs.getString("make"));
             car.setModel(rs.getString("model"));
             car.setYear(rs.getString("year"));
             car.setDailyRate(rs.getDouble("dailyRate"));
             car.setStatus(Status.valueOf(rs.getString("status")));
             car.setPassengerCapacity(rs.getInt("passengerCapacity"));
             car.setEngineCapacity(rs.getInt("engineCapacity"));
             cars.add(car);
         }
         return cars;
	}
	@Override
	public List<Car> findCarById(int vehicleId) {

		 List<Car> cars = new ArrayList<>();
         String cmd = "SELECT * FROM Vehicle WHERE vehicleID = ?";

         try {
             con = ConnectionHelper.getConnection();
             psmt = con.prepareStatement(cmd);
             psmt.setInt(1, vehicleId);

             ResultSet rs = psmt.executeQuery();

             if (rs.next()) {
                 Car car = new Car();
                 car.setVehicleId(rs.getInt("vehicleID"));
                 car.setVehicleNo(rs.getString("vehicleNo"));
                 car.setMake(rs.getString("make"));
                 car.setModel(rs.getString("model"));
                 car.setYear(rs.getString("year"));
                 car.setDailyRate(rs.getDouble("dailyRate"));
                 car.setStatus(Status.valueOf(rs.getString("status")));
                 car.setPassengerCapacity(rs.getInt("passengerCapacity"));
                 car.setEngineCapacity(rs.getInt("engineCapacity"));
                 cars.add(car);
             }

             if (cars.isEmpty()) {
                 throw new CarNotFoundException("Car with ID " + vehicleId + " not found.");
             }

         } catch (CarNotFoundException e) {
             System.err.println(e.getMessage());
         } catch (Exception e) {
             e.printStackTrace();
         }

         return cars;
     
		
	}	
	

 }
 

	
	

	

