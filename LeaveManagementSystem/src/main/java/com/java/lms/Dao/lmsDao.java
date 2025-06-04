package com.java.lms.Dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.java.lms.model.LeaveDetails;
import com.java.lms.model.Employ;

public interface lmsDao {
	List<Employ>showEmployDao() throws ClassNotFoundException, SQLException;
	Employ searchEmployDao(int empno) throws SQLException, ClassNotFoundException;
	String applyLeaveDao(LeaveDetails leave);
	int getLeaveBalance(int empId);
	    
//	  leave 
	LeaveDetails getLeaveDetailsById(int leaveId);
	String updateLeaveStatus(int leaveId, String status, String comments, int empId, int balanceChange);
	List<LeaveDetails> getLeaveHistory(int empId);
	List<LeaveDetails> getPendingLeavesForManager(int managerId);
	


}
