package module;

public class Car extends CarDescriptor {
	
	private String regNo;
	private int km;
	private int emp_Id;
	private int cus_Id; 
	private int carDesc_Id;
	
	public Car(String brand, String model, String color, int year, String regNo, int km, int emp_Id) 
	{
		super(brand,model,color,year);
		this.setKm(km);
		this.setRegNo(regNo);
		this.setEmp_Id(emp_Id);
		
		carDesc_Id = 0; 
	}
	
	/**
	 * 
	 * @return emp_id of type int
	 */
	public int getEmp_Id() {
		return emp_Id;
	}
	/**
	 * @return the regNo of type String
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * @return the km of type int
	 */
	public int getKm() {
		return km;
	}
	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}
	
	/**
	 * Set new emp_Id
	 * @param int emp_Id
	 */
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	
	/**
	 * Set new cus_Id
	 * @param int cus_Id
	 */
	public void setCus_Id(int cus_Id) {
		this.cus_Id = cus_Id; 
	}
	
	/**
	 * Get cus_Id
	 * @return int cus_Id
	 */
	public int getCus_Id() {
		return cus_Id; 
	}
	
	/**
	 * get CarDesc_Id
	 * @return int carDesc_Id
	 */
	public int getCarDesc_Id() {
		return carDesc_Id; 
	}
}
