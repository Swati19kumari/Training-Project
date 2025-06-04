package com.java.carrental.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.carrental.exception.CustomerNotFoundException;
import com.java.carrental.model.Customer;
import com.java.carrental.util.ConnectionHelper;

public class CustomerDaoImple implements CustomerDao {
	 static Connection con;
	    static PreparedStatement psmt;
	    
	@Override
	public void addCustomer(Customer customer) {
		 String cmd = "INSERT INTO Customer (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";

	        try {
	            con = ConnectionHelper.getConnection();
	            psmt = con.prepareStatement(cmd);
	            psmt.setString(1, customer.getFirstName());
	            psmt.setString(2, customer.getLastName());
	            psmt.setString(3, customer.getEmail());
	            psmt.setString(4, customer.getPhoneNumber());

	            int rows = psmt.executeUpdate();
	            if (rows > 0) {
	                System.out.println("Customer added successfully.");
	            } else {
	                System.out.println("Failed to add customer.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void removeCustomer(Customer customer) {
		  String cmd = "DELETE FROM Customer WHERE customerID = ?";

	        try {
	            con = ConnectionHelper.getConnection();
	            psmt = con.prepareStatement(cmd);
	            psmt.setInt(1, customer.getCustomerId());

	            int rows = psmt.executeUpdate();
	            if (rows > 0) {
	                System.out.println("Customer removed successfully.");
	            } else {
	                System.out.println("No customer found with ID: " + customer.getCustomerId());
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Customer> listCustomer() {
		 List<Customer> customers = new ArrayList<>();
	        String cmd = "SELECT * FROM Customer";

	        try {
	            con = ConnectionHelper.getConnection();
	            psmt = con.prepareStatement(cmd);
	            ResultSet rs = psmt.executeQuery();

	            while (rs.next()) {
	                Customer customer = new Customer();
	                customer.setCustomerId(rs.getInt("customerID"));
	                customer.setFirstName(rs.getString("firstName"));
	                customer.setLastName(rs.getString("lastName"));
	                customer.setEmail(rs.getString("email"));
	                customer.setPhoneNumber(rs.getString("phoneNumber"));
	                customers.add(customer);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return customers;
	}

	@Override
	public Customer findCustomerById(int customerId) {
		 String cmd = "SELECT * FROM Customer WHERE customerID = ?";

	        try {
	            con = ConnectionHelper.getConnection();
	            psmt = con.prepareStatement(cmd);
	            psmt.setInt(1, customerId);
	            ResultSet rs = psmt.executeQuery();

	            if (rs.next()) {
	                Customer customer = new Customer();
	                customer.setCustomerId(rs.getInt("customerID"));
	                customer.setFirstName(rs.getString("firstName"));
	                customer.setLastName(rs.getString("lastName"));
	                customer.setEmail(rs.getString("email"));
	                customer.setPhoneNumber(rs.getString("phoneNumber"));
	                return customer;
	            }
	    else {
           throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
       }
   } catch (Exception e) {
       e.printStackTrace();
       throw new RuntimeException("Error while finding customer.");
   }

}
}

