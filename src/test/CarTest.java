package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CarController;
import controller.CustomerController;
import controller.EmployeeController;
import database.CarDB;
import database.DataAccessException;
import module.Car;
import module.Customer;
import module.Employee;
import module.Person;

class CarTest {
	
	private CarController carCon;  
	private EmployeeController eCon; 
	

	@BeforeEach
	void setUp() throws Exception {
		carCon = new CarController();  
		eCon = new EmployeeController(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		carCon = null;
		eCon = null; 
	}

	@Test
	void testInsertCar() throws DataAccessException, SQLException {
		//Arrange
		Car car1 = null;
		Employee employee2 = eCon.findEmployeeByEmail("JensOggre@yahoo.dk");
		int emp_Id = employee2.getEmp_Id(); 
		Car car2 = new Car("KIA", "Picanto", "Green", 2015, "AC445566", 3500, emp_Id);
		
		//Act
		carCon.createCar("KIA", "Picanto", "Green", 2015, "AC445566", 3500, emp_Id);
		car1 = carCon.getCar("AC445566");
		
		//Assert
		assertEquals(car1, car2);
		
		
	}

}
