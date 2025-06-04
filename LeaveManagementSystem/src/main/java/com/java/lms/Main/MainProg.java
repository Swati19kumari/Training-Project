package com.java.lms.Main;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.java.lms.Bal.Validation;
import com.java.lms.Dao.lmsDao;
import com.java.lms.Dao.lmsDaoImple;
import com.java.lms.model.Employ;
import com.java.lms.model.LeaveDetails;

public class MainProg {

	    static Scanner sc = new Scanner(System.in);
	    static lmsDao dao = new lmsDaoImple();

	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n==== Leave Management System ====");
	            System.out.println("1. Show All Employees");
	            System.out.println("2. Search Employee by ID");
	            System.out.println("3. Apply for Leave");
	            System.out.println("4. View My Leave History");
	            System.out.println("5. View Pending Leaves (Manager)");
	            System.out.println("6. Approve/Reject Leave (Manager)");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    showAllEmployees();
	                    break;
	                case 2:
	                    searchEmployee();
	                    break;
	                case 3:
	                    applyLeave();
	                    break;
	                case 4:
	                    viewLeaveHistory();
	                    break;
	                case 5:
	                    viewPendingLeaves();
	                    break;
	                case 6:
					try {
						approveOrRejectLeave();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	                case 0:
	                    System.out.println("Exiting... Thanks!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        }
	    }

	    private static void showAllEmployees() {
	        try {
	            List<Employ> list = dao.showEmployDao();
	            list.forEach(System.out::println);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void searchEmployee() {
	        System.out.print("Enter Employee ID: ");
	        int empId = sc.nextInt();
	        try {
	            Employ emp = dao.searchEmployDao(empId);
	            if (emp != null) {
	                System.out.println(emp);
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void applyLeave() {
	        System.out.print("Enter EmpId: ");
	        int empId = sc.nextInt();

	        System.out.print("Enter Leave Start Date (yyyy-mm-dd): ");
	        LocalDate startDate = LocalDate.parse(sc.next());

	        System.out.print("Enter Leave End Date (yyyy-mm-dd): ");
	        LocalDate endDate = LocalDate.parse(sc.next());

	        System.out.print("Enter Leave Type (EL/SL/CL): ");
	        String type = sc.next();

	        sc.nextLine(); // consume newline

	        System.out.print("Enter Leave Reason: ");
	        String reason = sc.nextLine();

	        LeaveDetails leave = new LeaveDetails();
	        leave.setEmpId(empId);
	        leave.setLeaveStartDate(startDate);
	        leave.setLeaveEndDate(endDate);
	        leave.setLeaveType(Enum.valueOf(com.java.lms.model.LeaveType.class, type.toUpperCase()));
	        leave.setLeaveReason(reason);

	        String result = Validation.applyLeaveDaoBal(leave);
	        System.out.println(result);
	    }

	    private static void viewLeaveHistory() {
	        System.out.print("Enter Employee ID: ");
	        int empId = sc.nextInt();
	        List<LeaveDetails> history = dao.getLeaveHistory(empId);
	        if (history.isEmpty()) {
	            System.out.println("No leave history found.");
	        } else {
	            history.forEach(System.out::println);
	        }
	    }

	    private static void viewPendingLeaves() {
	        System.out.print("Enter Manager ID: ");
	        int managerId = sc.nextInt();
	        List<LeaveDetails> pendingLeaves = dao.getPendingLeavesForManager(managerId);
	        if (pendingLeaves.isEmpty()) {
	            System.out.println("No pending leaves for your subordinates.");
	        } else {
	            pendingLeaves.forEach(System.out::println);
	        }
	    }

	    private static void approveOrRejectLeave() throws ClassNotFoundException, SQLException {
	        System.out.print("Enter Leave ID: ");
	        int leaveId = sc.nextInt();

	        System.out.print("Enter Your Manager ID: ");
	        int managerId = sc.nextInt();

	        System.out.print("Approve? (Yes/No): ");
	        String decision = sc.next();

	        sc.nextLine(); // consume newline
	        System.out.print("Enter Manager Comments: ");
	        String comments = sc.nextLine();


	        String res = Validation.processManagerDecision(leaveId, managerId, decision, comments);
	        System.out.println(res);
	        
	    }
	}



