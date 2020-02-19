package module;
import java.util.ArrayList;


public class Customer extends Person {
	
	public ArrayList<Car> cars; 
	public int cus_Id;

	public Customer(String firstName, String lastName, String address, String zipcode, String city, String phoneNo,
			String email, String password, PersonType type, int cus_Id) {
		super(firstName, lastName, address, zipcode, city, phoneNo, email, password, type);
		// TODO Auto-generated constructor stub
		cars = new ArrayList<>(); 
		
		this.setType(PersonType.CUS);
		this.setCus_Id(cus_Id);
		
	}

	public void setCus_Id(int cus_Id) {
		this.cus_Id = cus_Id;
	}
	public int getCus_Id() {
		return this.cus_Id;
	}

}
