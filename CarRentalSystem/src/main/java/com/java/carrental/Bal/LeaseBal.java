package com.java.carrental.Bal;
import java.sql.SQLException;
import java.time.LocalDate;

import com.java.carrental.Dao.LeaseDao;
import com.java.carrental.Dao.LeaseDaoImple;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.model.Lease;


public class LeaseBal {

	    public static LeaseDao leaseDao;
	    static StringBuilder sb;

	    static {
	        leaseDao = new LeaseDaoImple();
	        sb = new StringBuilder();
	    }

	    public Lease createLeaseBal(int customerId, int carId, LocalDate start, LocalDate end) throws LeaseNotFoundException, ClassNotFoundException, SQLException {
	        if (validateLeaseDates(start, end)) {
	           
	                return leaseDao.createLease(customerId, carId, start, end);
	            
	        }
	        throw new LeaseNotFoundException("Lease validation failed.");
	    }
	
	    
	    public static boolean validateLeaseDates(LocalDate startDate, LocalDate endDate) {
	    sb = new StringBuilder();
	
	    if (startDate == null || endDate == null) {
	        sb.append("Start and end dates must not be null.\n");
	        return false;
	    }
	    else {
	        if (startDate.isAfter(endDate)) {
	            sb.append("Start date must be before or equal to end date.\n");
	            return false;
	        }
	
	        if (startDate.isBefore(LocalDate.now())) {
	            sb.append("Start date must not be in the past.\n");
	            return false;
	        }
	    }
	
	    if (sb.length() > 0) {
	        System.out.println("Lease date validation failed:\n" + sb.toString().trim());
	        return false;
	    }
	
	    return true;
	}

}
