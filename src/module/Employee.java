package module;

public class Employee extends Person {

	private String description;
	private int emp_Id;
	
	public Employee(String firstName, String lastName, String address, String zipcode, String city, String phoneNo,
			String email, String password, String description, PersonType type) {
		super(firstName, lastName, address, zipcode, city, phoneNo, email, password, type);
		// TODO Auto-generated constructor stub
		this.setDescriptor(description);
		this.setType(PersonType.EMP);
		
	}
	
	/**
	 * get the emp_Id
	 * @return int emp_Id
	 */
	public int getEmp_Id() {
		return this.emp_Id;
	}
	
	/**
	 * set emp_Id
	 * @param int emp_Id
	 */
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	
	/**
	 * get the description of the employee
	 * @return String description 
	 */
	public String getDescripton() {
		return this.description;
	}

	/**
	 * set descriptor
	 * @param String description
	 */
	public void setDescriptor(String descripton) {
		this.description = descripton;
	}
	


	
	
}
