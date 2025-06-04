package com.java.carrental.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.java.carrental.Bal.PaymentBal;
import com.java.carrental.Dao.LeaseDao;
import com.java.carrental.Dao.LeaseDaoImple;
import com.java.carrental.exception.CarNotFoundException;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.model.Lease;
import com.java.carrental.model.Payment;
import com.java.carrental.util.ConnectionHelper;

public class PaymentMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentBal paymentBal = new PaymentBal();
        LeaseDao leaseDao = new LeaseDaoImple();

        while (true) {
            System.out.println("\n--- Payment Management Menu ---");
            System.out.println("1. Record Payment");
            System.out.println("2. Show All Payments");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline after int input

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Lease ID: ");
                        int leaseId = sc.nextInt();
                        sc.nextLine(); // clear newline

                        
                        Lease lease = leaseDao.returnLeaseByIdDaoImpl(leaseId);
                        if (lease == null || lease.getLeaseId() == 0) {
                            System.out.println(" Lease not found.");
                            break;
                        }

                        // Calculate amount
                        LocalDate start = lease.getStartDate();
                        LocalDate end = lease.getEndDate();
                        long days = ChronoUnit.DAYS.between(start, end);
                        if (days == 0) days = 1;

                        Connection con = ConnectionHelper.getConnection();
                        String rateSql = "SELECT dailyRate FROM vehicle WHERE vehicleId = ?";
                        PreparedStatement rateStmt = con.prepareStatement(rateSql);
                        rateStmt.setInt(1, lease.getVehicleId());
                        ResultSet rateRs = rateStmt.executeQuery();

                        double dailyRate = 0;
                        if (rateRs.next()) {
                            dailyRate = rateRs.getDouble("dailyRate");
                        } else {
                            System.out.println(" Vehicle not found.");
                            break;
                        }

                        double amount = dailyRate * days;

                        // Confirm from user
                        System.out.println("Total payment amount for Lease ID " + leaseId + " is: ₹" + amount);
                        System.out.print("Do you want to proceed? (yes/no): ");
                        String confirm = sc.nextLine().trim().toLowerCase();

                        if (confirm.equals("yes")) {
                            paymentBal.recordPaymentBal(lease);
                        } else {
                            System.out.println(" Payment cancelled.");
                        }

                    } catch (LeaseNotFoundException | CarNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (ClassNotFoundException | SQLException e) {
                        System.out.println(" Database error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        List<Payment> payments = paymentBal.paymentDao.showpaymentRecord();
                        if (payments.isEmpty()) {
                            System.out.println("No payment records found.");
                        } else {
                            System.out.println("--- Payment Records ---");
                            for (Payment p : payments) {
                                System.out.println("Lease ID: " + p.getLeaseId() +
                                        ", Amount: ₹" + p.getAmount() +
                                        ", Payment Date: " + p.getPaymentDate());
                            }
                        }
                    } catch (ClassNotFoundException | SQLException e) {
                        System.out.println(" Error retrieving payments: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println(" Exiting Payment Module.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
