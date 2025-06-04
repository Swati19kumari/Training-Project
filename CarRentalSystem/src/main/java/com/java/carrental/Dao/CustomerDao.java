package com.java.carrental.Dao;

import java.util.List;

import com.java.carrental.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	void removeCustomer(Customer customer);
	List<Customer> listCustomer();
	Customer findCustomerById(int customerId);
}
