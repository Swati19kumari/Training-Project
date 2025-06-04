package com.java.lms.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.LeaveDetails;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;
import com.java.lms.Bal.Validation;
import com.java.lms.model.Employ;
import com.java.util.ConnectionHelper;

public class lmsDaoImple implements lmsDao {

	Connection connection;
	PreparedStatement psmt;
	LeaveDetails leave=new LeaveDetails();
	@Override
	public List<Employ> showEmployDao() throws ClassNotFoundException, SQLException {
		List<Employ> employList = new ArrayList<Employ>();
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employee";
		psmt = connection.prepareStatement(cmd);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			 Employ employ = new Employ();
			 
			System.out.println("===================================");
			employ.setEmpId(rs.getInt("emp_id"));
			employ.setEmp_Name(rs.getString("emp_name"));
			//employ.setGender(Gender.valueOf(rs.getString("gender")));
			employ.setEmp_Mail(rs.getString("emp_mail"));
			employ.setEmp_Mob_No(rs.getString("emp_mob_no"));
			employ.setEmpDtJoin(rs.getDate("emp_dt_join"));
			employ.setEmp_Dept(rs.getString("emp_dept"));
			employ.setEmp_Manager_Id(rs.getInt("emp_manager_id"));
			employ.setEmp_Avail_Leave_Bal(rs.getInt("emp_avail_leave_bal"));
			employList.add(employ);
		}
		return employList;
	}
	
	
	@Override
	public Employ searchEmployDao(int empno) throws SQLException, ClassNotFoundException {
		Employ employ = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employee where emp_id = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setInt(1, empno);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			employ = new Employ();
			employ.setEmpId(rs.getInt("emp_id"));
			employ.setEmp_Name(rs.getString("emp_name"));
			
			employ.setEmp_Mail(rs.getString("emp_mail"));
			employ.setEmp_Mob_No(rs.getString("emp_mob_no"));
			employ.setEmpDtJoin(rs.getDate("emp_dt_join"));
			employ.setEmp_Dept(rs.getString("emp_dept"));
			employ.setEmp_Manager_Id(rs.getInt("emp_manager_id"));
			employ.setEmp_Avail_Leave_Bal(rs.getInt("emp_avail_leave_bal"));
		}
		return employ;
	}
	@Override
	public String applyLeaveDao(LeaveDetails leave) 
	{		int noOfDays= (int)ChronoUnit.DAYS.between(leave.getLeaveStartDate(), leave.getLeaveEndDate());
			String message1= UpdateLeaveBalance(leave.getEmpId(), noOfDays);
			String message2=insertLeave_history(leave);
			return message1+message2;
				
	}

	
	public String insertLeave_history(LeaveDetails leave) {
		String sql =  "INSERT INTO leave_history (EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE, LEAVE_REASON, LEAVE_STATUS, LEAVE_NO_OF_DAYS) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = ConnectionHelper.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setLong(1, leave.getEmpId());
	            stmt.setDate(2, Date.valueOf(leave.getLeaveStartDate()));
	            stmt.setDate(3, Date.valueOf(leave.getLeaveEndDate()));
	            stmt.setString(4, leave.getLeaveType().name());
	            stmt.setString(5, leave.getLeaveReason());
	            stmt.setString(6, leave.getLeaveStatus().name());
	            stmt.setInt(7, leave.getNoOfDays());

	            int rowInserted=stmt.executeUpdate() ;
	            if(rowInserted>0) {
	            	return "Leave requested submitted successfully and the data is stored in leave_history";
	            }
	            else {
	            	return" Leave requested not submitted successfully ";
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	        
	        return "error ";
	}

//	int noOfDays=(int)ChronoUnit.DAYS.between(leave.getLeaveStartDate(), leave.getLeaveStartDate());
	
	public String  UpdateLeaveBalance(int empId,int noOfDays) {
		String sql= "UPDATE employee "+
					"SET EMP_AVAIL_LEAVE_BAL =EMP_AVAIL_LEAVE_BAL - ? " + "Where EMP_ID =?  ";
		
		try {
			Connection conn = ConnectionHelper.getConnection();
			  PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setInt(1, noOfDays);
			 stmt.setInt(2, empId);
			 //stmt.setInt(3,noOfDays);
			 int  updaterow=stmt.executeUpdate();
			 
			 if(updaterow>0) {
				 	return "Yes balance updated Succesfully";
			        } 
			 else{
				 return"Update failed,employ not found";
			 }
		}
			 catch (Exception e) {
				 e.printStackTrace();
			 }	       
		return "error ";	    
	}
	
	
	// to calaculate the balance in emp table
	public int getLeaveBalance(int empId) {
	    int balance = -1;
	    try {
	        Connection con = ConnectionHelper.getConnection();
	        String sql = "SELECT  emp_avail_leave_bal FROM employee WHERE emp_id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, empId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            balance = rs.getInt("emp_avail_leave_bal");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return balance;
	}


	@Override
	public List<LeaveDetails> getLeaveHistory(int empId) {
	 List<LeaveDetails> leaveList = new ArrayList<>();
		    try {
		        Connection conn = ConnectionHelper.getConnection();
		        String sql = "SELECT * FROM leave_history WHERE emp_id = ?";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, empId);
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		            LeaveDetails leave = new LeaveDetails();
		            leave.setLeaveId(rs.getInt("leave_id"));
		            leave.setEmpId(rs.getInt("emp_id"));
		            leave.setLeaveStartDate(rs.getDate("leave_start_date").toLocalDate());
		            leave.setLeaveEndDate(rs.getDate("leave_end_date").toLocalDate());
		            leave.setLeaveType(LeaveType.valueOf(rs.getString("leave_type")));
		            leave.setLeaveReason(rs.getString("leave_reason"));
		            leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leave_status")));
		            leave.setNoOfDays(rs.getInt("leave_no_of_days"));
		            leaveList.add(leave);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return leaveList;
		}


	@Override
	public List<LeaveDetails> getPendingLeavesForManager(int managerId) {
		
		    List<LeaveDetails> leaveList = new ArrayList<>();
		    try {
		        Connection conn = ConnectionHelper.getConnection();
		        String sql = "SELECT lh.* FROM leave_history lh JOIN employee e ON lh.emp_id = e.emp_id " +
		                     "WHERE e.emp_manager_id = ? AND lh.leave_status = 'PENDING'";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, managerId);
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		            LeaveDetails leave = new LeaveDetails();
		            leave.setLeaveId(rs.getInt("leave_id"));
		            leave.setEmpId(rs.getInt("emp_id"));
		            leave.setLeaveStartDate(rs.getDate("leave_start_date").toLocalDate());
		            leave.setLeaveEndDate(rs.getDate("leave_end_date").toLocalDate());
		            leave.setLeaveType(LeaveType.valueOf(rs.getString("leave_type")));
		            leave.setLeaveReason(rs.getString("leave_reason"));
		            leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leave_status")));
		            leave.setNoOfDays(rs.getInt("leave_no_of_days"));
		            leaveList.add(leave);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return leaveList;
		}


	@Override
	public LeaveDetails getLeaveDetailsById(int leaveId) {
		 LeaveDetails leave = null;
		    try {
		        Connection con = ConnectionHelper.getConnection();
		        String sql = "SELECT * FROM leave_history WHERE leave_id = ?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, leaveId);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            leave = new LeaveDetails();
		            leave.setLeaveId(rs.getInt("leave_id"));
		            leave.setEmpId(rs.getInt("emp_id"));
		            leave.setLeaveStartDate(rs.getDate("leave_start_date").toLocalDate());
		            leave.setLeaveEndDate(rs.getDate("leave_end_date").toLocalDate());
		            leave.setNoOfDays(rs.getInt("leave_no_of_days"));
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return leave;
		}
	

	
	@Override
	public String updateLeaveStatus(int leaveId, String status, String comments, int empId, int balanceChange) {
		
		    try {
		        // Get the database connection
		        Connection con = ConnectionHelper.getConnection();
		        
		        // Correct SQL query: Use uppercase for column names
		        String sql = "UPDATE leave_history SET LEAVE_STATUS = ?, LEAVE_MNGR_COMMENTS = ? WHERE LEAVE_ID = ?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        
		        // Set the values for the prepared statement
		        ps.setString(1, status);  // Set leave status
		        ps.setString(2, comments);  // Set manager comments
		        ps.setInt(3, leaveId);  // Set leave ID
		        
		        // Execute the update query
		        int updated = ps.executeUpdate();

		        // If the leave status is "DENIED", update the employee's leave balance
		        if (status.equals("DENIED")) {
		            String balSql = "UPDATE employee SET emp_avail_leave_bal = emp_avail_leave_bal + ? WHERE emp_id = ?";
		            PreparedStatement ps2 = con.prepareStatement(balSql);
		            ps2.setInt(1, -balanceChange);  // Decrease the leave balance
		            ps2.setInt(2, empId);
		            ps2.executeUpdate();
		        }

		        // Return success message if the update was successful
		        if (updated > 0) {
		            return "Leave status updated to " + status;
		        }

		    } catch (SQLException e) {
		        // Print stack trace for debugging
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    // Return failure message if the update was not successful
		    return "Failed to update leave status.";
		}

	
	}

	
	


