package database;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import module.Customer;
import module.Employee;
import module.Person;
import module.Person.PersonType;

public class CustomerDB implements CustomerDBIF {

	/**
	 * 
	 */
	private static final String FIND_ALL_CUSTOMERS_Q = "SELECT * FROM Person p " + "INNER JOIN ZipCode zc "
			+ "ON zc.zipCode=p.zipCode";
	private PreparedStatement findAllCustomers;

	private static final String FIND_CUSTOMER_BY_EMAIL_Q = FIND_ALL_CUSTOMERS_Q + " WHERE email = ?";
	private PreparedStatement findCustomerByEmail;

	private static final String UPDATE_CUSTOMER_Q = "UPDATE Person SET firstName = ?, lastName = ?, address = ? , zipcode = ?, city = ?, phoneNo = ?, email = ?, password = ?";
	private PreparedStatement updateCustomer;
	
	private static final String INSERT_CUSTOMER_Q = "INSERT INTO Person (firstName,lastName,address,zipCode,city,phoneNo,email,password,type) VALUES(?,?,?,?,?,?,?,?,?)";
	private PreparedStatement insertCustomer;
	//String firstName, String lastName, String address, String zipcode, String city, String phoneNo,
	//String email, String password, PersonType type, int cus_Id
	
	private static final String INSERT_ZIPCODE_Q = "INSERT INTO zipCode (zipCode, city) VALUES (?,?)"; 
	private PreparedStatement insertZipCode; 
	private static final String FIND_ZIPCODE_Q = "SELECT * FROM zipCode"; 
	private PreparedStatement findZipCode; 
	
	
	private static final String DELETE_BY_CUS_ID_Q = "DELETE FROM Person WHERE id = ?"; 
	private PreparedStatement deleteCustomer;

	public CustomerDB() throws DataAccessException {
		init();
	}

	private void init() throws DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();

		try { // Prepare the statements
			findAllCustomers = con.prepareStatement(FIND_ALL_CUSTOMERS_Q);
			findCustomerByEmail = con.prepareStatement(FIND_CUSTOMER_BY_EMAIL_Q);
			updateCustomer = con.prepareStatement(UPDATE_CUSTOMER_Q);
			insertCustomer = con.prepareStatement(INSERT_CUSTOMER_Q);
			deleteCustomer = con.prepareStatement(DELETE_BY_CUS_ID_Q);
			insertZipCode = con.prepareStatement(INSERT_ZIPCODE_Q); 
			findZipCode = con.prepareStatement(FIND_ZIPCODE_Q); 
			
		} catch (SQLException e) { // Throw custom message
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}

	/**
	 * Convert a collection of results to Java Objects.
	 * 
	 * @param rs A collection of results from a DB query of the Objects Customer.
	 * @return An array list of Customer.
	 * @throws SQLException
	 */
	private List<Customer> buildObjects(ResultSet rs) throws SQLException {
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			customers.add(buildObject(rs));
		}
		return customers;
	}

	/**
	 * Convert a result to Java Object.
	 * 
	 * @param rs A result from a DB query of the object Customer.
	 * @return Customer customer
	 * @throws SQLException
	 */
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer customer = new Customer(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
				rs.getString("zipCode"), rs.getString("city"), rs.getString("phone"), rs.getString("email"),
				rs.getString("password"), PersonType.valueOf(rs.getString("type")), rs.getInt("id"));
		return customer;
	}

	private Person buildObjectPerson(ResultSet rs) throws SQLException {
		Person person = new Person(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
				rs.getString("zipCode"), rs.getString("city"), rs.getString("phone"), rs.getString("email"),
				rs.getString("password"), PersonType.valueOf(rs.getString("type")));
		return person;
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		try {
			findCustomerByEmail.setString(1, email);
			ResultSet rs = findCustomerByEmail.executeQuery();
			Customer customer = null;
			if (rs.next()) {
				customer = buildObject(rs);
			}
			return customer;
		} catch (SQLException e) {
			System.out.println("SQL exception thrown  :" + e);
		}
		return null;
	}
	
	
	/**
	 * Find person by email
	 * @param String email
	 * @return Person person
	 */
	public Person findPersonByEmail(String email) throws SQLException {
			findCustomerByEmail.setString(1, email);
			ResultSet rs = findCustomerByEmail.executeQuery();
			Person person = null;
			if (rs.next()) {
				person = buildObjectPerson(rs);
			}
			return person;

	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertCustomer(Customer customer) throws SQLException, DataAccessException {
		
		DBConnection con = DBConnection.getInstance(); 
		
		try {
			con.startTransaction();	
			
				findZipCode.setString(1, customer.getZipcode()); 
				ResultSet zipCodeRS = findZipCode.executeQuery(); 
				int rowZipCodeAffected = 0; 
				System.out.println("Tjekker zipCode");
				
				if(zipCodeRS.next()) {
					rowZipCodeAffected = 1; 
				} else {
					insertZipCode.setString(1, customer.getZipcode()); 
					insertZipCode.setString(2, customer.getCity()); 
				}
				
				if(rowZipCodeAffected == 1) {										//firstName,lastName,address,zipCode,city,phoneNo,email,password,type,cus_Id
					insertCustomer.setString(1, customer.getFirstName());
					insertCustomer.setString(2, customer.getLastName());
					insertCustomer.setString(3, customer.getAddress()); 
					insertCustomer.setString(4, customer.getZipcode()); 
					insertCustomer.setString(5, customer.getCity()); 
					insertCustomer.setString(6, customer.getPhoneNo()); 
					insertCustomer.setString(7, customer.getEmail()); 
					insertCustomer.setString(8, customer.getPassword()); 
					insertCustomer.setString(9, customer.getType().toString()); 
					insertCustomer.setInt(10, customer.getCus_Id());
					insertCustomer.executeUpdate(); 
					
					ResultSet keyPersonRS = insertCustomer.getGeneratedKeys(); 
					int cus_Id = 0; 
					if(keyPersonRS.next()) {
						cus_Id = keyPersonRS.getInt(1); 
					}
					System.out.println(cus_Id); 
					
					
				} else {
					System.out.println("Person failed insertion. Rollback"); 
					con.rollbackTransaction();
				}
				
						con.commitTransaction();
				
			} catch (SQLException e) {
				
				con.rollbackTransaction();
				
				throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e); 
			}
	}
	
	
	@Override
	public void deleteCustomerByCus_Id(int cus_Id) throws SQLException {
		try {
			deleteCustomer.setInt(1, cus_Id); 
			deleteCustomer.executeUpdate(); 
			deleteCustomer.close(); 
		} catch (SQLException e) {
			throw e; 
		}
	}

}
