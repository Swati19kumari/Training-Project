package com.java.crm.mainTest;

import java.util.List;

import com.java.crm.Dao.ResolveDaoImpl;
import com.java.crm.model.Resolve;

public class TestResolve {
	public static void main(String[] args) {
		// Create a Scanner object to get user input
//        Scanner scanner = new Scanner(System.in);
//        
//        // Create an instance of ResolveDaoImpl
//        ResolveDaoImpl resolveDao = new ResolveDaoImpl();
//        
//        // Ask user for inputs
//        System.out.print("Enter Complaint ID: ");
//        String complaintID = scanner.nextLine();
//        
//        System.out.print("Enter Complaint Date (yyyy-mm-dd): ");
//        String complaintDateStr = scanner.nextLine();
//        Date complaintDate = Date.valueOf(complaintDateStr);  // Convert to Date
//        
//        System.out.print("Enter Resolved By: ");
//        String resolvedBy = scanner.nextLine();
//        
//        System.out.print("Enter Comments: ");
//        String comments = scanner.nextLine();
//        
//        // Create a Resolve object and set its values
//        Resolve resolve = new Resolve();
//        resolve.setComplaintID(complaintID);
//        resolve.setComplaintDate(complaintDate);
//        resolve.setResolvedBy(resolvedBy);
//        resolve.setComments(comments);
//        
//        // Automatically set the current time as ResolveDate        
//        // Call addResolve method to save the Resolve record
//        String result = resolveDao.addResolve(resolve);
//        
//        // Print the result message
//        System.out.println(result);
//        
//        // Close the scanner
//        scanner.close();

//		ResolveDaoImpl dao = new ResolveDaoImpl();
//
//		List<Resolve> resolveList = dao.getAllResolves();
//
//		if (resolveList.isEmpty()) {
//			System.out.println("No resolved complaints found.");
//		} else {
//			System.out.println("Resolved Complaints List:");
//			System.out.printf("%-10s %-15s %-15s %-10s %-20s\n", "ID", "Complaint Date", "Resolve Date", "TAT",
//					"Resolved By");
//
//			for (Resolve r : resolveList) {
//				System.out.printf("%-10s %-15s %-15s %-10d %-20s\n", r.getComplaintID(), r.getComplaintDate(),
//						r.getResolveDate(), r.getTat(), r.getResolvedBy());
//			}
//		}

		ResolveDaoImpl dao = new ResolveDaoImpl();

		// Test the method with a specific Complaint ID (replace with an actual
		// complaint ID)
		String complaintId = "C001"; // Example Complaint ID (it can be alphanumeric)
		Resolve resolve = dao.getResolveByComplaintId(complaintId);

		// Check if the resolve object is not null and print its details
		if (resolve != null) {
			System.out.println("Resolve Details for Complaint ID: " + complaintId);
			System.out.printf("%-15s %-15s %-15s %-10s %-20s\n", "Complaint ID", "Complaint Date", "Resolve Date",
					"TAT", "Resolved By");

			// Print the details of the resolve object
			System.out.printf("%-15s %-15s %-15s %-10d %-20s\n", resolve.getComplaintID(), resolve.getComplaintDate(),
					resolve.getResolveDate(), resolve.getTat(), resolve.getResolvedBy());
		} else {
			System.out.println("No resolution found for Complaint ID: " + complaintId);
		}
	}

}
