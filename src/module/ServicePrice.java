package module;

//import java.sql.Date;
import java.util.Date;

public class ServicePrice {

	private double price;
	private Date startInterval;
	
	public ServicePrice(double price, Date startInterval)
	{
		this.setPrice(price);
		this.setStartInterval(startInterval);
	}

	/**
	 * get price
	 * @return double price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * set price
	 * @param double price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * get startInterval
	 * @return Date startInterval
	 */
	public Date getStartInterval() {
		return startInterval;
	}

	/**
	 * set startInterval
	 * @param Date startInterval
	 */
	public void setStartInterval(Date startInterval) {
		this.startInterval = startInterval;
	}
}
