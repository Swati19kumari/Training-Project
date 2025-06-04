package com.java.crm.mainTest;

import java.sql.Date;
import java.util.Scanner;

import com.java.crm.Dao.ComplaintDao;
import com.java.crm.Dao.ComplaintDaoImpl;
import com.java.crm.model.Complaint;
import com.java.enums.Severity;

public class MainTest {
	static ComplaintDao complaintDAO = new ComplaintDaoImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//
//		Complaint complaint = new Complaint();
//
//		System.out.print("Enter Complaint Type: ");
//		complaint.setComplaintType(sc.nextLine());
//
//		System.out.print("Enter Complaint Description: ");
//		complaint.setCdescription(sc.nextLine());
//		
//
//		System.out.println("Select Severity (LOW, MEDIUM, HIGH): ");
//		try {
//			complaint.setSeverity(Severity.valueOf(sc.nextLine().trim().toUpperCase()));
//		} catch (IllegalArgumentException e) {
//			System.out.println("Invalid Severity! Defaulting to MEDIUM.");
//			complaint.setSeverity(Severity.MEDIUM);
//		}
//
//		complaintDAO.addComplaint(complaint);
//
//	System.out.println("✅ Complaint added successfully with ID: " + complaint.getComplaintId());
//	}
		
		System.out.println("Enter COmoplaint Id: ");
		String id = sc.next();
		
		System.out.println(complaintDAO.searchComplaintById(id));
		
		

	}

}
