package module;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNo;
	private String email;
	private String password;
	private PersonType type;
	
	/*
	 * Put a type on customer or person for login check
	 */
	public enum PersonType {
		CUS,	//customerType
		EMP; 	//employeeType
	}
	
	
    public Person(String firstName, String lastName, String address, String zipcode, String city, String phoneNo, String email, String password, PersonType type){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setZipcode(zipcode);
        this.setCity(city);
        this.setPhoneNo(phoneNo);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
        
    }
    


	/**
	 * return address of a person
	 * @return String address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * set address
	 * @param String address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * get the zipCode
	 * @return String zipCode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * set zipCode
	 * @param String zipCode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * get city
	 * @return String city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * set city
	 * @param String city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * get phone
	 * @return String phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * set phoneNo
	 * @param String phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * get email
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * set email
	 * @param String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * return password
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set password
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * get firstName
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * set firstName
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * get lastName
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * set lastName
	 * @param String lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
	/**
	 * return personType
	 * @return personType type
	 */
	public PersonType getType() {
		return type; 
	}
	
	/**
	 * set personType
	 * @param personType type
	 */
	public void setType(PersonType type) {
		this.type = type;
	}
}
