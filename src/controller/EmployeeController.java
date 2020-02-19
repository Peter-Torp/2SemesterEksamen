package controller;

import java.sql.SQLException;
import module.Employee;
import module.Person.PersonType;
import database.*;
import java.util.List;

public class EmployeeController {

	private EmployeeDBIF eDB;

	public EmployeeController() throws DataAccessException {
		eDB = new EmployeeDB();
	}
	
	/**
	 * find all employees
	 * @return a list of employees[]
	 */
	public List<Employee> findAllEmployees() {
		List<Employee> emps;
		emps = eDB.findAllEmployees();
		return emps;
	}
	
	/**
	 * Find an employee by email
	 * @param String email
	 * @return employee object
	 */
	public Employee findEmployeeByEmail(String email) {
		Employee employee = eDB.findEmployeeByEmail(email);
		return employee;
	}
	
	
	/**
	 * Find employee by id
	 * @param int id
	 * @return employee object
	 */
	public Employee findEmployeeByEmpID(int id) {
		Employee employee = eDB.findEmployeeByEmpId(id);
		return employee;
	}
	
	
	/**
	 * Delete employee 
	 * @param Employee employee
	 */
	public void deleteEmployee(Employee employee) {
		try {
			eDB.deleteEmployee(employee.getEmp_Id(),employee.getZipcode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create an employee
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param zipCode
	 * @param city
	 * @param phoneNo
	 * @param email
	 * @param password
	 * @param description
	 * @return employee object
	 */
	public Employee createEmployee(String firstName, String lastName, String address, String zipCode, String city,
		String phoneNo, String email, String password, String description) {
		Employee employee = new Employee(firstName, lastName, address, zipCode, city, phoneNo, email, password, description, PersonType.EMP);
		try {
			eDB.createEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee; 
	}
	
	/**
	 * Update an employee 
	 * @param Employee employee
	 */
	public void updateEmployee(Employee employee) {
		eDB.updateEmployee(employee);
	}
}
