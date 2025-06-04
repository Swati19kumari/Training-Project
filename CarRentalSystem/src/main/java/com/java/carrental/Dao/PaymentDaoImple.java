package com.java.carrental.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.model.Lease;
import com.java.carrental.model.Payment;
import com.java.carrental.util.ConnectionHelper;

public class PaymentDaoImple implements PaymentDao {

    static Connection con;
    static PreparedStatement psmt;

    @Override
    public void recordPayment(Lease lease) throws ClassNotFoundException, SQLException, LeaseNotFoundException, CarNotFoundException {
    
    	    con = ConnectionHelper.getConnection();

    	    // 1. Check if lease exists
    	    String leaseCheck = "SELECT leaseId FROM lease WHERE leaseId = ?";
    	    psmt = con.prepareStatement(leaseCheck);
    	    psmt.setInt(1, lease.getLeaseId());
    	    ResultSet leaseRs = psmt.executeQuery();
    	    if (!leaseRs.next()) {
    	        throw new LeaseNotFoundException("Lease with ID " + lease.getLeaseId() + " not found.");
    	    }

    	    // 2. Calculate lease duration
    	    LocalDate startDate = lease.getStartDate();
    	    LocalDate endDate = lease.getEndDate();
    	    long days = ChronoUnit.DAYS.between(startDate, endDate);
    	    if (days == 0) days = 1;

    	    // 3. Get daily rate
    	    String rateSql = "SELECT dailyRate FROM vehicle WHERE vehicleId = ?";
    	    psmt = con.prepareStatement(rateSql);
    	    psmt.setInt(1, lease.getVehicleId());
    	    ResultSet rateRs = psmt.executeQuery();

    	    double dailyRate;
    	    if (rateRs.next()) {
    	        dailyRate = rateRs.getDouble("dailyRate");
    	    } else {
    	        throw new CarNotFoundException("Vehicle with ID " + lease.getVehicleId() + " not found.");
    	    }

    	    // 4. Calculate amount
    	    double amount = days * dailyRate;

    	    // 5. Record payment (no user interaction)
    	    String paymentSql = "INSERT INTO payment (leaseId, amount, paymentDate) VALUES (?, ?, ?)";
    	    psmt = con.prepareStatement(paymentSql);
    	    psmt.setInt(1, lease.getLeaseId());
    	    psmt.setDouble(2, amount);
    	    psmt.setDate(3, Date.valueOf(LocalDate.now()));
    	    psmt.executeUpdate();
    	}


    @Override
    public List<Payment> showpaymentRecord() throws SQLException, ClassNotFoundException {
        List<Payment> list = new ArrayList<>();
        con = ConnectionHelper.getConnection();

        String cmd = "SELECT * FROM payment";
        psmt = con.prepareStatement(cmd);
        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            Payment details = new Payment();
            details.setLeaseId(rs.getInt("leaseId"));
            details.setAmount(rs.getDouble("amount"));
            details.setPaymentDate(rs.getDate("paymentDate").toLocalDate()); // Convert java.sql.Date to java.time.LocalDate
            list.add(details);
        }

        return list;
    }
}
