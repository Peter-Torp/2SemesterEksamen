package database;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import module.Car;
import module.Employee;
import module.Person.PersonType;

public class EmployeeDB implements EmployeeDBIF {

	private static final String FIND_ALL_EMPLOYEES_Q = "SELECT * " + "FROM Person p " + "INNER JOIN ZipCode zc "
			+ "ON zc.zipCode=p.zipCode " + "INNER JOIN Employee e " + "ON p.id=e.emp_Id " + "INNER JOIN Occupation o "
			+ "ON e.occ_Id=o.occ_Id";

	private static final String FIND_EMPLOYEE_BY_EMAIL_Q = FIND_ALL_EMPLOYEES_Q + " WHERE email = ?";
	private static final String FIND_EMPLOYEE_BY_EMP_ID_Q = FIND_ALL_EMPLOYEES_Q + " WHERE emp_Id = ?";

	private static final String UPDATE_EMPLOYEE_Q = "UPDATE Person SET firstName = ?, lastName = ?, address = ? , zipcode = ?, city = ?, phoneNo = ?, email = ?, password = ?, description = ?";

	private static final String INSERT_PERSON_Q = "INSERT INTO Person (firstName,lastName,zipCode,address,phone,email,type,password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_ZIPCODE_Q = "INSERT INTO ZipCode VALUES (?,?)";
	private static final String FIND_ZIPCODE_Q = "SELECT * FROM ZipCode where zipCode = ?";
	private static final String FIND_OCCUPATION_Q = "SELECT * FROM Occupation where position = ?";
	private static final String INSERT_OCCUPATION_Q = "INSERT INTO Occupation VALUES (?)";
	private static final String INSERT_EMPLOYEE_Q = "INSERT INTO Employee VALUES (?, ?, ?);";
	private PreparedStatement insertPerson, insertZipCode, insertOccupation, insertEmployee, findZipCode,
			findOccupation;
	
	private static final String DELETE_PERSON_Q = "delete from Person WHERE id = ?";
	private static final String DELETE_EMPLOYEE_Q = "DELETE FROM Employee WHERE emp_id = ?";
	private static final String DELETE_ZIPCODE_Q = "delete from ZipCode WHERE zipCode = ?";
	private PreparedStatement deletePerson, deleteEmployee, deleteZipCode;
	
	private PreparedStatement findEmployeeByEmail, findAllEmployees, updateEmployee;

	Connection con;

	public EmployeeDB() throws DataAccessException {
		init();
	}

	private void init() throws DataAccessException {
		con = DBConnection.getInstance().getConnection();

		try { // Prepare the statements
			findAllEmployees = con.prepareStatement(FIND_ALL_EMPLOYEES_Q);
			findEmployeeByEmail = con.prepareStatement(FIND_EMPLOYEE_BY_EMAIL_Q);
			updateEmployee = con.prepareStatement(UPDATE_EMPLOYEE_Q);
			
			deletePerson = con.prepareStatement(DELETE_PERSON_Q);
			deleteEmployee = con.prepareStatement(DELETE_EMPLOYEE_Q);
			deleteZipCode = con.prepareStatement(DELETE_ZIPCODE_Q);

			insertPerson = con.prepareStatement(INSERT_PERSON_Q, insertPerson.RETURN_GENERATED_KEYS);
			insertZipCode = con.prepareStatement(INSERT_ZIPCODE_Q);
			insertOccupation = con.prepareStatement(INSERT_OCCUPATION_Q, insertOccupation.RETURN_GENERATED_KEYS);
			insertEmployee = con.prepareStatement(INSERT_EMPLOYEE_Q);
			findZipCode = con.prepareStatement(FIND_ZIPCODE_Q);
			findOccupation = con.prepareStatement(FIND_OCCUPATION_Q);
		} catch (SQLException e) { // Throw custom message

			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}

	/**
	 * Convert a collection of results to Java Objects.
	 * 
	 * @param rs A collection of results from a DB query of the Objects Employee.
	 * @return An array list of Employee.
	 * @throws SQLException
	 */
	private List<Employee> buildObjects(ResultSet rs) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		while (rs.next()) {
			employees.add(buildObject(rs));
		}
		return employees;
	}

	/**
	 * Convert a result to Java Object.
	 * 
	 * @param rs A result from a DB query of the object Employee.
	 * @return Employee
	 * @throws SQLException
	 */
	private Employee buildObject(ResultSet rs) throws SQLException {
		Employee employee = new Employee(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
				rs.getString("zipCode"), rs.getString("city"), rs.getString("phone"), rs.getString("email"),
				rs.getString("password"), rs.getString("description"), PersonType.valueOf(rs.getString("type")));
			employee.setEmp_Id(rs.getInt("emp_Id"));
		return employee;
	}


	@Override
	public List<Employee> findAllEmployees() {
		ResultSet rs;
		try {
			rs = this.findAllEmployees.executeQuery();
			List<Employee> emps = buildObjects(rs);
			return emps;
		} catch (SQLException e) {

		}
		return null;
	}


	@Override
	public Employee findEmployeeByEmail(String email) {
		try {
			findEmployeeByEmail.setString(1, email);
			ResultSet rs = findEmployeeByEmail.executeQuery();
			Employee employee = null;
			if (rs.next()) {
				employee = buildObject(rs);
			}
			return employee;
		} catch (SQLException e) {
			System.out.println("SQL exception thrown  :" + e);
		}
		return null;
	}


	@Override
	public Employee findEmployeeByEmpId(int id) {
		try {
			PreparedStatement findEmployeeByEmpId = con.prepareStatement(FIND_EMPLOYEE_BY_EMP_ID_Q);
			findEmployeeByEmpId.setInt(1, id);
			ResultSet rs = findEmployeeByEmpId.executeQuery();
			Employee employee = null;
			if (rs.next()) {
				employee = buildObject(rs);
			}
			return employee;
		} catch (SQLException e) {
			System.out.println("SQL exception thrown  :" + e);
		}
		return null;
	}


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteEmployee(int emp_Id, String zipCode) throws SQLException {
		try {
			con.setAutoCommit(false);
			
			deleteEmployee.setInt(1, emp_Id);
			int rowEmployeeAffected = deleteEmployee.executeUpdate();
			if(rowEmployeeAffected == 1) {
				deletePerson.setInt(1, emp_Id);
				int rowPersonAffected = deletePerson.executeUpdate();
				if(rowPersonAffected == 1) {
					deleteZipCode.setString(1, zipCode);
					int rowZipCodeAfftected = deleteZipCode.executeUpdate(); //Bedstikke at slette city/zipcode
					if(rowZipCodeAfftected == 0) {
						con.rollback();
					}
				} else {
					con.rollback();
				}
			} else {
				con.rollback();
			}
			con.commit();
		} catch (SQLException e) {
			con.rollback();
		}
	}

	@Override
	public void createEmployee(Employee employee) throws SQLException {
		try {
			con.setAutoCommit(false); // Start transaction.

			/*
			 * Check if zipcode and city exist in db. 
			 * If it does use existing db tuple. 
			 * If not insert into table.
			 */
			findZipCode.setString(1, employee.getZipcode());
			ResultSet zipCodeRS = findZipCode.executeQuery();
			int rowZipCodeAffected = 0;
			System.out.println("HALLO JEG ER I GANG");
			if (zipCodeRS.next()) {
				//Finds entry in database.
				rowZipCodeAffected = 1;
			} else {
				insertZipCode.setString(1, employee.getZipcode());
				insertZipCode.setString(2, employee.getCity());
				rowZipCodeAffected = insertZipCode.executeUpdate(); //Returns number of affected rows. Should always be 1, can be 0 if fails. Could be because of duplicate email etc.
			}

			/*
			 * Check if zipcode actually is in database. 
			 * Then insert into Person table. 
			 * Needs to get an auto generated id for Person primary key.
			 */
			if (rowZipCodeAffected == 1) {
				System.out.println("Yes");
				insertPerson.setString(1, employee.getFirstName());
				insertPerson.setString(2, employee.getLastName());
				insertPerson.setString(3, employee.getZipcode());
				insertPerson.setString(4, employee.getAddress());
				insertPerson.setString(5, employee.getPhoneNo());
				insertPerson.setString(6, employee.getEmail());
				insertPerson.setString(7, employee.getType().toString());
				insertPerson.setString(8, employee.getPassword());
				int rowPersonAffected = insertPerson.executeUpdate();

				// To get the auto generated key.
				ResultSet keyPersonRS = insertPerson.getGeneratedKeys();
				int emp_Id = 0;
				if (keyPersonRS.next()) {
					emp_Id = keyPersonRS.getInt(1);
				}
				System.out.println(emp_Id);

				/*
				 * Check if person got inserted to database.
				 * Then determine if occupation already is in database. If not, then insert.
				 * Needs an auto generated key to continue.
				 */
				if (rowPersonAffected == 1) {

					findOccupation.setString(1, "Salg");
					ResultSet occupationRS = findOccupation.executeQuery();
					
					ResultSet occKeyRS;
					int rowOccAffected = 0;
					int occ_Id = 0;
					if (occupationRS.next()) {
						occ_Id = occupationRS.getInt("occ_Id");
						rowOccAffected = 1;
					} else {
						insertOccupation.setString(1, "Salg");
						rowOccAffected = insertOccupation.executeUpdate();
						occKeyRS = insertOccupation.getGeneratedKeys();
						if (occKeyRS.next()) {
							occ_Id = occKeyRS.getInt(1);
						}
					}

					/* 
					 * Check if occupation is present in db.
					 * Then insert employee.
					 */
					int rowEmpAffected = 0;
					if (rowOccAffected == 1) {
						insertEmployee.setString(1, employee.getDescripton());
						insertEmployee.setInt(2, emp_Id);
						insertEmployee.setInt(3, occ_Id);
						rowEmpAffected = insertEmployee.executeUpdate();
						if(rowEmpAffected == 0) {
							System.out.println("Employee failed insertion. Rollback");
							con.rollback(); //If employee fails insertion.
						}
					} else {
						System.out.println("Occupation failed insertion. Rollback");
						con.rollback(); //If occupation fails insertion.
					}
				} else {
					System.out.println("Person failed insertion. Rollback");
					con.rollback(); //If person fails insertion.
				}
			} else {
				System.out.println("Zipcode failed insertion. Rollback");
				con.rollback(); //If zipcode fails insertion
			}

			System.out.println("HALLO JEG ER FÆRDIG");
			con.commit();
		} catch (SQLException e) {
			con.rollback();
		}
	}

}
