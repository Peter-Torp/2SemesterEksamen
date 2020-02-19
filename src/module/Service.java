package module;

public class Service {

	private String type;
	private int timeIntensity;
	private double price;
	private int service_Id;
	private int price_Id;
	
	public Service(String type, int timeIntensity, double price, int service_Id, int price_Id)
	{
		this.setType(type);
		this.setTimeIntensity(timeIntensity);
		this.setPrice(price);
		this.setService_Id(service_Id);
		this.setPrice_Id(price_Id);
	}
	
	/**
	 * set service_Id
	 * @param int service_Id
	 */
	public void setService_Id(int service_Id) {
		this.service_Id = service_Id;
	}
	
	/**
	 * set price
	 * @param double price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * get price
	 * @return double price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * get service_Id
	 * @return service_Id
	 */
	public int getService_Id() {
		return this.service_Id;
	}
	
	/**
	 * get type
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * set type
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * get timeIntensity
	 * @return int timeIntensity
	 */
	public int getTimeIntensity() {
		return timeIntensity;
	}

	/**
	 * set timeIntensity
	 * @param timeIntensity the timeIntensity to set
	 */
	public void setTimeIntensity(int timeIntensity) {
		this.timeIntensity = timeIntensity;
	}

	/**
	 * get price_Id
	 * @return int price_Id
	 */
	public int getPrice_Id() {
		return price_Id;
	}

	/**
	 * set price_Id
	 * @param int price_Id
	 */
	public void setPrice_Id(int price_Id) {
		this.price_Id = price_Id;
	}
	
	
}
