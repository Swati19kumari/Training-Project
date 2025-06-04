package com.java.lms.Bal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.java.lms.Dao.lmsDao;
import com.java.lms.Dao.lmsDaoImple;
import com.java.lms.model.Employ;
import com.java.lms.model.LeaveDetails;

public class Validation {

	static Scanner sc ;
	  static   lmsDao  balDao;
	  static StringBuilder sb;
	    static {
	    	 sc = new Scanner(System.in);
	        balDao =new lmsDaoImple();
	        sb=new StringBuilder();
	    }
	    
	
	public static String applyLeaveDaoBal(LeaveDetails leaveDetails) {
		if(validate(leaveDetails)) {
			return balDao.applyLeaveDao(leaveDetails);
		}
		else {
			return sb.toString();
		}
		
		
	}
	

    public static boolean validate(LeaveDetails leaveDetails ) {
        LocalDate today = LocalDate.now();
        LocalDate start =leaveDetails.getLeaveStartDate();
		LocalDate end=leaveDetails.getLeaveEndDate();
        
		 int currentBalance = balDao.getLeaveBalance(leaveDetails.getEmpId());

	       
        Boolean isValid=true;
        
        leaveDetails.setNoOfDays((int)ChronoUnit.DAYS.between(start, end));

        if (start.isBefore(today) || end.isBefore(today)) {
            sb.append("Leave dates cannot be in the past.");
            isValid=false;
        }
        if (start.isAfter(end)) {
            sb.append("Start date cannot be after end date."); 
            isValid=false;
        }
        if (currentBalance == -1) {
            sb.append("Employee not found in leave balance table.") ;
            isValid=false;
        }

        if (leaveDetails.getNoOfDays() > currentBalance) {
            sb.append("Insufficient leave balance.");
        }
//        if(leaveDetails.getNoOfDays()> )
        
		return isValid;
	
	}
    
    public static String processManagerDecision(int leaveId, int managerId, String decision, String comments) throws ClassNotFoundException, SQLException {
        LeaveDetails leave = balDao.getLeaveDetailsById(leaveId);
        if (leave == null) return "Invalid Leave ID.";

        Employ emp = balDao.searchEmployDao(leave.getEmpId());
        if (emp == null || emp.getEmp_Manager_Id() != managerId) {
            return "You are not authorized to approve this leave.";
        }

        if (decision.equalsIgnoreCase("yes")) {
            return balDao.updateLeaveStatus(leaveId, "APPROVED", comments, leave.getEmpId(), leave.getNoOfDays());
        } else if (decision.equalsIgnoreCase("no")) {
            return balDao.updateLeaveStatus(leaveId, "DENIED", comments, leave.getEmpId(), -leave.getNoOfDays());
        } else {
            return "Invalid choice. Use Yes or No.";
        }
    }

	
    
}
