package com.java.carrental.Dao;

import java.sql.SQLException;
import java.util.List;

import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.model.Lease;
import com.java.carrental.model.Payment;

public interface PaymentDao {

	
	public void recordPayment(Lease lease) throws ClassNotFoundException, SQLException, LeaseNotFoundException, CarNotFoundException;
	List<Payment> showpaymentRecord() throws SQLException, ClassNotFoundException;

}