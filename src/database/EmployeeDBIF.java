package database;

import java.sql.SQLException;
import java.util.List;

import module.*;

public interface EmployeeDBIF {

	/**
	 * Find all employees in db.
	 * @return List of employees[]
	 */
	public List<Employee> findAllEmployees();

	/**
	 * Find a specific employee by email.
	 * @param String email
	 * @return Employee employee
	 * @throws SQLException
	 */
	public Employee findEmployeeByEmail(String email);

	/**
	 * Find a specific employee by employee id.
	 * @param int id
	 * @return Employee employee
	 * @throws SQLException
	 */
	public Employee findEmployeeByEmpId(int id);

	/**
	 * Update an employee in the database.
	 * @param Employee employee
	 */
	public void updateEmployee(Employee employee);

	/**
	 * Insert an employee object into the database.
	 * @param Employee employee
	 * @throws SQLException 
	 */
	public void createEmployee(Employee employee) throws SQLException;
	
	/**
	 * Delete an employee in the database.
	 * @param int emp_Id
	 * @param String zipCode
	 * @throws SQLException 
	 */
	public void deleteEmployee(int emp_Id, String zipCode) throws SQLException;

}
