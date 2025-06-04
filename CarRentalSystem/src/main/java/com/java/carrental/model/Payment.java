package com.java.carrental.model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;
@Data
public class Payment {
	private int paymentId;
	private int leaseId;
	private LocalDate paymentDate;
	private double amount;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate localDate) {
		this.paymentDate = localDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
