package controller;

import java.sql.SQLException;
import module.Customer;
import module.Person;
import module.Person.PersonType;
import database.*;
import java.util.List;

public class CustomerController {

	private CustomerDBIF cDB;

	public CustomerController() throws DataAccessException {
		cDB = new CustomerDB();
	}

	public List<Customer> findAllCustomers() {
		List<Customer> res;
		res = cDB.findAllCustomers();
		return res;
	}

	/*
	 * Find a customer with *String email* Return the customer object
	 */
	public Customer findCustomerByEmail(String email) {
		Customer customer;
		customer = cDB.findCustomerByEmail(email);
		return customer;
	}
	
	
	/**
	 * Find a person by email
	 * @param String email
	 * @return person object
	 * @throws SQLException
	 */
	public Person findPersonByEmail(String email) throws SQLException {
		try {
			Person person = cDB.findPersonByEmail(email);
			return person;
		} catch (NullPointerException e) {
			
		}
		return null;
	}

	/**
	 * Create Customer object and send it to db layer to insert in database.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param zipCode
	 * @param city
	 * @param phoneNo
	 * @param email
	 * @param password
	 * @param type
	 * @return customer object
	 * @throws DataAccessException 
	 */
	public Customer createCustomer(String firstName, String lastName, String address, String zipCode, String city,
			String phoneNo, String email, String password, PersonType type) throws DataAccessException {
		
		Customer customer = new Customer(firstName, lastName, address, zipCode, city, phoneNo, email, password, type, 0);
		try {
			cDB.insertCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer; 
	}
	
	
	/**
	 * Delete a customer by a cus_Id
	 * @param int cus_Id
	 */
	public void deleteCustomer(int cus_Id) {
		try {
			cDB.deleteCustomerByCus_Id(cus_Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update a customer with String firstName, String lastName, String address,
	 * String zipcode, String city, String phoneNo, String email, String password
	 * @param Customer customer
	 */
	public void updateCustomer(Customer customer) {
		cDB.updateCustomer(customer);
	}
}
