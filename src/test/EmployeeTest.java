package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apiguardian.api.API;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import controller.EmployeeController;
import database.DataAccessException;
import module.Employee;

class EmployeeTest {

	private EmployeeController empCon;
	private Employee gEmployee;

	@Test
	void testGetEmployeeById() {
		//Arrange
		int id = 1;
		
		//Act
		Employee employee = empCon.findEmployeeByEmpID(id);
		
		//Assert
		assert (employee.getFirstName().equals("Jens"));
	}

	@Test
	void testGetEmployeeByEmail() {
		//Arrange
		String email = "HansR@live.dk";
		
		//Act
		Employee employee = empCon.findEmployeeByEmail(email);
		
		//Assert
		assert (employee.getFirstName().equals("Hans"));
	}

	@Test
	void testInsertEmployee() {
		//Arrange
		String email = "hodor@holdthedoor.com";

		//Act
		empCon.createEmployee("Hodor", "Stark", "Rabalderstræde 30", "3030", "Måneby", "43233432", email, "1234", "This guy is awesome");
		gEmployee = empCon.findEmployeeByEmail(email);
		
		//Assert
		assert(gEmployee.getEmail().equals(email));
	}
	
	@Test
	void testDeleteEmployee() {
		//Arrange
		String email = "Dozia@email.rus";
		Employee employee;
		Employee employeeTwo = null;
		
		//Act
		empCon.createEmployee("Dosia", "xGod", "Bossensgade 40", "9999", "Moskva", "95049544", email, "1234", "Dosia er bedst.");
		employee = empCon.findEmployeeByEmail(email);
		empCon.deleteEmployee(employee);
		employeeTwo = empCon.findEmployeeByEmpID(employee.getEmp_Id());
		
		//Assert
		assert(employeeTwo == null);
		
	}
	


	@BeforeEach
	void setUp() throws DataAccessException {
		empCon = new EmployeeController();
	}

	@AfterEach
	void tearDown() {
		if(gEmployee != null) {
			empCon.deleteEmployee(gEmployee);
			gEmployee = null;
		}
	}
	

}
