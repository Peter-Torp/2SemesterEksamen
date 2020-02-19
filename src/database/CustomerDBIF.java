package database;

import java.sql.SQLException;
import java.util.List;

import module.Appointment;
import module.Customer;
import module.Person;

public interface CustomerDBIF {
	
	
	/**
	 * Find all customers
	 * @return List of customer[]
	 */
	public List<Customer> findAllCustomers(); 
	
	/**
	 * Find customer by email
	 * @param String email
	 * @return Customer customer
	 */
	public Customer findCustomerByEmail(String email); 
	
	
	/**
	 * Update a customer
	 * @param Customer customer
	 */
	public void updateCustomer(Customer customer); 
	
	/**
	 * Insert a customer to database
	 * @param Customer customer
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	public void insertCustomer(Customer customer) throws SQLException, DataAccessException;
	
	
	/**
	 * Find a person by email
	 * @param String email
	 * @return Person person
	 * @throws SQLException
	 */
	public Person findPersonByEmail(String email) throws SQLException;
	
	/**
	 * Delete a customer by cus_Id
	 * @param int cus_Id
	 * @throws SQLException
	 */
	public void deleteCustomerByCus_Id(int cus_Id) throws SQLException;
	
}
