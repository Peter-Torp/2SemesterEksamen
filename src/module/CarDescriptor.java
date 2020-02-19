package module;

public abstract class CarDescriptor {

	private String brand;
	private String model;
	private String color;
	private int year;
	
	
	
	public CarDescriptor(String brand, String model, String color, int year)
	{
		this.setBrand(brand);
		this.setModel(model);
		this.setColor(color);
		this.setYear(year);
	}



	/**
	 * get the brand of the car
	 * @return String brand
	 */
	public String getBrand() {
		return brand;
	}



	/**
	 * Set brand 
	 * @param String brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}



	/**
	 * get the model of the car
	 * @return String model
	 */
	public String getModel() {
		return model;
	}



	/**
	 * set model
	 * @param String model
	 */
	public void setModel(String model) {
		this.model = model;
	}



	/**
	 * get the color of the car
	 * @return String color
	 */
	public String getColor() {
		return color;
	}



	/**
	 * set color of the car
	 * @param String color
	 */
	public void setColor(String color) {
		this.color = color;
	}



	/**
	 * get the year of the car
	 * @return year of car
	 */
	public int getYear() {
		return year;
	}



	/**
	 * set the int year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
}
