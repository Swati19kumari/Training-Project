package com.java.carrental.model;

import java.time.LocalDate;

import lombok.Data;
@Data
public class Lease {

	private int leaseId;
	private int vehicleId;
	private int cutomerId;
	private LocalDate startDate;
	private LocalDate endDate;
	private Type type;
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Lease [leaseId=" + leaseId + ", vehicleId=" + vehicleId + ", cutomerId=" + cutomerId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + "]";
	}
	
	
}
