package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CustomerController;
import database.DataAccessException;
import module.Customer;
import module.Person.PersonType;

class CustomerTest {

	//Arrange
	private CustomerController cusCon;
	private Customer customer;
	

	@Test
/*	void testInsertCustomer() {
		//Arrange 
		String firstName = "Tove";
		String email = "tovepigen@google.dk";
		
		//Act
		cusCon.createCustomer(firstName, "Klitgaard", "Svinestien 32", "9000", "Aalborg", "24325434", email, "1234", PersonType.CUS);
		
		customer = cusCon.findCustomerByEmail(email);
		
		//Assert
		assert (customer.getFirstName().equals(firstName));
	}*/
	

	void testFindCustomer() {
		Customer customer = cusCon.findCustomerByEmail("tobyh@gmail.dk");
		System.out.println(customer.getFirstName());
		assert(customer.getFirstName().equals("Tobias"));
	}
	
	@BeforeEach
	void setUp() throws DataAccessException {
		cusCon = new CustomerController();
	}

/*	@AfterAll
	void tearDown() {
		//cusCon.deleteCustomer(customer.getCus_Id());
	}
*/
}
