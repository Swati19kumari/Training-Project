package com.java.carrental.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.java.carrental.Bal.LeaseBal;
import com.java.carrental.exception.LeaseNotFoundException;
import com.java.carrental.model.Lease;

public class LeaseMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeaseBal leaseBal = new LeaseBal();

        while (true) {
            System.out.println("\n--- Lease Management Menu ---");
            System.out.println("1. Create New Lease");
            System.out.println("2. Get Lease By ID");
            System.out.println("3. List Active Leases");
            System.out.println("4. List Lease History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        System.out.print("Enter Vehicle ID: ");
                        int vehicleId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        LocalDate startDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        LocalDate endDate = LocalDate.parse(scanner.nextLine());

                        // Date validation
                        if (startDate.isAfter(endDate)) {
                            System.out.println(" Start date cannot be after end date.");
                            break;
                        }

                        Lease newLease = leaseBal.createLeaseBal(customerId, vehicleId, startDate, endDate);
                        System.out.println("Lease Created Successfully! Lease ID: " + newLease.getLeaseId());
                        break;

                    case 2:
                        System.out.print("Enter Lease ID: ");
                        int leaseId = scanner.nextInt();
                        Lease lease = leaseBal.leaseDao.returnLeaseByIdDaoImpl(leaseId);
                        if (lease != null) {
                            System.out.println("Lease Found: " + lease);
                        } else {
                            System.out.println("Lease not found.");
                        }
                        break;

                    case 3:
                        List<Lease> activeLeases = leaseBal.leaseDao.listActiveLeaseDaoImpl();
                        System.out.println("--- Active Leases ---");
                        for (Lease l : activeLeases) {
                            System.out.println(l);
                        }
                        break;

                    case 4:
                        List<Lease> leaseHistory = leaseBal.leaseDao.listLeaseHistoryDaoImple();
                        System.out.println("--- Lease History ---");
                        for (Lease l : leaseHistory) {
                            System.out.println(l);
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (LeaseNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SQLException | ClassNotFoundException | DateTimeParseException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }
}
