package com.java.carrental.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Car {

	private int vehicleId;
	private String vehicleNo;
	private String make;
	private String model;
	private String year;
	private  double dailyRate;
	private Status status;
	private  int passengerCapacity;
	private int engineCapacity;
	
	public int getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	
	@Override
	public String toString() {
		return "Car [vehicleId=" + vehicleId + ", vehicleNo=" + vehicleNo + ", make=" + make + ", model=" + model
				+ ", year=" + year + ", dailyRate=" + dailyRate + ", status=" + status + ", passengerCapacity="
				+ passengerCapacity + ", engineCapacity=" + engineCapacity + "]";
	}
	
}
