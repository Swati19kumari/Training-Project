package com.java.carrental.main;
import java.util.List;
import java.util.Scanner;
import com.java.carrental.Bal.CustomerBal;
import com.java.carrental.exception.CustomerNotFoundException;
import com.java.carrental.model.Customer;


public class CustomerMain {
 
	    private static Scanner scanner = new Scanner(System.in);
	    private static CustomerBal customerBal = new CustomerBal();
	    
	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\nWelcome to the Car Rental System!");
	            System.out.println("1. Add Customer");
	            System.out.println("2. Remove Customer");
	            System.out.println("3. List Customers");
	            System.out.println("4. Find Customer By ID");
	            System.out.println("5. Exit");
	            
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            
	            switch (choice) {
	                case 1:
	                    addCustomer();
	                    break;
	                case 2:
	                    removeCustomer();
	                    break;
	                case 3:
	                    listCustomers();
	                    break;
	                case 4:
	                    findCustomerById();
	                    break;
	                case 5:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;  // Exit the program
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        }
	    }
	    
	    // Method to add a customer
	    private static void addCustomer() {
	        System.out.println("\nEnter Customer Details:");
	        
	        System.out.print("First Name: ");
	        String firstName = scanner.nextLine();
	        
	        System.out.print("Last Name: ");
	        String lastName = scanner.nextLine();
	        
	        System.out.print("Email: ");
	        String email = scanner.nextLine();
	        
	        System.out.print("Phone Number: ");
	        String phoneNumber = scanner.nextLine();
	        
	        Customer customer = new Customer();
	        customer.setFirstName(firstName);
	        customer.setLastName(lastName);
	        customer.setEmail(email);
	        customer.setPhoneNumber(phoneNumber);
	        
	        try {
	            customerBal.addCustomerBal(customer);
	            System.out.println("Customer added successfully.");
	        } catch (CustomerNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // Method to remove a customer by ID
	    private static void removeCustomer() {
	        System.out.print("\nEnter Customer ID to remove: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        
	        Customer customer = new Customer();
	        customer.setCustomerId(customerId);
	        
	        try {
	            customerBal.removeCustomerBal(customer);
	            System.out.println("Customer removed successfully.");
	        } catch (CustomerNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // Method to list all customers
	    private static void listCustomers() {
	        try {
	            List<Customer> customers = customerBal.listCustomersBal();
	            if (customers.isEmpty()) {
	                System.out.println("No customers found.");
	            } else {
	                System.out.println("\nList of Customers:");
	                for (Customer customer : customers) {
	                    System.out.println("ID: " + customer.getCustomerId() + ", Name: " + customer.getFirstName() + " " + customer.getLastName());
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving customers: " + e.getMessage());
	        }
	    }
	    
	    // Method to find a customer by ID
	    private static void findCustomerById() {
	        System.out.print("\nEnter Customer ID to search: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        
	        try {
	            Customer customer = customerBal.findCustomerByIdBal(customerId);
	            System.out.println("\nCustomer Found:");
	            System.out.println("ID: " + customer.getCustomerId());
	            System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName());
	            System.out.println("Email: " + customer.getEmail());
	            System.out.println("Phone: " + customer.getPhoneNumber());
	        } catch (CustomerNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


