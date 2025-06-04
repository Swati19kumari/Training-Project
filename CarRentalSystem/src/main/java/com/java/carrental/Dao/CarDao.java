package com.java.carrental.Dao;

import java.sql.SQLException;
import java.util.List;

import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.model.Car;

public interface CarDao {
	
	void addCar(Car car) throws ClassNotFoundException, SQLException;
	void removeCar(Car car) throws ClassNotFoundException, SQLException;
	List<Car> listCarsByStatus(String status) throws ClassNotFoundException, SQLException;
	List<Car> findCarById(int vehicleId);
	
}
