package com.java.carrental.Bal;
import java.sql.SQLException;

import com.java.carrental.Dao.PaymentDao;
import com.java.carrental.Dao.PaymentDaoImple;
import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.exception.PaymentNotFoundException;
import com.java.carrental.model.Lease;


public class PaymentBal {

	    public static PaymentDao paymentDao;

	    static {
	        paymentDao = new PaymentDaoImple();
	    }

	    // No need to pass amount — it's calculated in DAO
	    public void recordPaymentBal(Lease lease) 
	            throws LeaseNotFoundException, ClassNotFoundException, SQLException, CarNotFoundException {
	        paymentDao.recordPayment(lease);
	    }

	    // Optional validation method if used later
	    public static boolean validatePaymentAmount(double amount) {
	        if (amount <= 0) {
	            System.out.println("Payment amount must be greater than zero.");
	            return false;
	        }
	        return true;
	    }
	}




