package com.java.carrental.Bal;

import java.util.List;
import com.java.carrental.Dao.CustomerDao;
import com.java.carrental.Dao.CustomerDaoImple;
import com.java.carrental.exception.CustomerNotFoundException;
import com.java.carrental.model.Customer;

public class CustomerBal {

    static CustomerDao customerDao;
    static StringBuilder sb;

    static {
        customerDao = new CustomerDaoImple();
        sb = new StringBuilder();
    }

    public String addCustomerBal(Customer customer) throws CustomerNotFoundException {
        if (validateCustomer(customer)) {
            customerDao.addCustomer(customer);
            return null;  // Return null if everything is fine
        }
        throw new CustomerNotFoundException(sb.toString());
    }

    public void removeCustomerBal(Customer customer) throws CustomerNotFoundException {
        customerDao.removeCustomer(customer);
    }

    public List<Customer> listCustomersBal() {
        return customerDao.listCustomer();
    }

    public Customer findCustomerByIdBal(int customerId) throws CustomerNotFoundException {
        Customer customer = customerDao.findCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
        return customer;
    }

    public static boolean validateCustomer(Customer customer) {
        sb = new StringBuilder();
        String phone = customer.getPhoneNumber();
        String email = customer.getEmail();

        if (phone == null || phone.trim().isEmpty()) {
            sb.append("Phone number cannot be empty.\n");
            return false;
        } else if (phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) {
            sb.append("Phone number must be exactly 10 digits and contain only numbers.\n");
            return false;
        }

        if (email == null || email.trim().isEmpty()) {
            sb.append("Email cannot be empty.\n");
            return false;
        } else {
            if (!email.contains("@")) {
                sb.append("Email must contain '@' symbol.\n");
                return false;
            }
            if (!email.endsWith(".com")) {
                sb.append("Email must end with '.com'.\n");
                return false;
            }
        }

        if (sb.length() > 0) {
            System.out.println("Customer validation failed:\n" + sb.toString().trim());
            return false;
        }

        return true;
    }
}
