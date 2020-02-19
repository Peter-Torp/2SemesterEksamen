package module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Appointment {

	private final Date orderDate;
	private double totalPrice;
	private AppState state;
	private String timeTo;
	private String timeFrom;
	private Date appDate;
	private int km;
	private List<Service> appServices;
	private int app_Id;
	private int ws_Id;
	private String regNo;
	private Car car;
	
	public enum AppState {
		PENDING, DONE;
	}

	public Appointment(double totalPrice, AppState state, String timeTo, String timeFrom, Date appDate, String regNo,
			int km, int app_Id, int ws_Id) {
		this.orderDate = new Date();
		this.totalPrice = totalPrice;
		this.state = state;
		this.timeTo = timeTo;
		this.timeFrom = timeFrom;
		this.setAppDate(appDate);
		this.km = km;
		this.app_Id = app_Id;
		this.ws_Id = ws_Id;
		this.regNo = regNo;

		setAppServices(new ArrayList<Service>());
	}

	/**
	 * Calculate the total timeIntensity of a service list int totalTimeIntensity
	 * represents minutes.
	 * 
	 * @param list of services
	 * @return int totalTimeIntensity
	 */
	public int calcTimeIntensity(List<Service> services) {

		int timeInt = 0;

		for (Service service : services) {
			timeInt = timeInt + service.getTimeIntensity();

		}
		return timeInt;
	}

	/**
	 * Calculate the total price of added services.
	 * 
	 * @param services
	 * @return double totalPrice
	 */
	public double calcPrice(List<Service> services) {
		double totalPrice = 0;

		for (Service service : services) {
			totalPrice = totalPrice + service.getPrice();
		}
		return totalPrice;
	}

	/**
	 * Add services to appointment
	 * 
	 * @param List with services Call method calcTimeIntensity(services)
	 */
	public void addServices(List<Service> services) {

		setAppServices(services);

		calcTimeIntensity(services);

	}

	/**
	 * Calculates the difference between the end of firstAppointment and the start of nextAppointment.
	 * @param firstAppointment
	 * @param nextAppointment
	 * @return
	 */
	public int calcTimeDifference(Appointment firstAppointment, Appointment nextAppointment) {
		int[] fAppTimeTo = splitTimeString(firstAppointment.timeTo); // Closing time for first appointment
		int[] nAppTimeFrom = new int[2];
		boolean lastApp = false; // Last appointment of the day.
		if (nextAppointment == null) {
			lastApp = true;
			nAppTimeFrom[0] = 15; // Sets the corporation closing time.
			nAppTimeFrom[1] = 0; // Sets the corporation closing time.
		} else {
			nAppTimeFrom = splitTimeString(nextAppointment.timeFrom); // Start time for next appointment
		}

		System.out.println("First appointment " + firstAppointment.timeFrom + " + " + firstAppointment.timeTo);
		if (!lastApp) {
			System.out.println("Next appointment " + nextAppointment.timeFrom + " + " + nextAppointment.timeTo);
		}
		System.out.println("My appointment " + this.timeFrom + " + " + this.timeTo);

		/*
		 * Calculate the time difference between first appointment and next appointment.
		 */
		int timeDifHour = (nAppTimeFrom[0] - fAppTimeTo[0]) * 60;
		int timeDifMin = nAppTimeFrom[1] - fAppTimeTo[1];
		int totalTimeDif = timeDifHour + timeDifMin;

		return totalTimeDif;
	}

	/**
	 * Split a time string, and return integer array with the 2 times.
	 * @param time
	 * @return int[] integers - Where 0 index is hour, and 1 index is minute.
	 */
	private int[] splitTimeString(String time) {
		// The string you want to be an integer array.
		String[] integerStrings = time.split(":");
		// Splits each spaced integer into a String array.
		int[] integers = new int[integerStrings.length];
		// Creates the integer array.
		for (int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(integerStrings[i]);
			// Parses the integer for each string.
		}
		return integers;
	}

	/**
	 * Convert the int array of time to string.
	 * 
	 * @param splittedTime
	 * @return String time
	 */
	private String timeToString(int[] splittedTime) {
		String time = "";

		// Make the hour part of the time slot.
		if (splittedTime[0] >= 10) {
			time = Integer.toString(splittedTime[0]);
		} else {
			time = "0" + Integer.toString(splittedTime[0]);
		}

		// Make the colon in the middle of the time slot.
		time = time + ":";

		// Make the minute part of the time slot.
		if (splittedTime[1] != 0) {
			time = time + Integer.toString(splittedTime[1]);
		} else {
			time = time + "0" + Integer.toString(splittedTime[1]);
		}

		return time;
	}
/**
 * Finds available times, when compared to timeIntensity.
 * @param timestamps
 * @param timeIntensity
 * @return List<String> validTimes
 */
	public List<String> validTimes(HashMap<String, Integer> timestamps, int timeIntensity) {
		List<String> validTimes = new ArrayList<>();

		for (String key : timestamps.keySet()) {
			System.out.println("key: " + key + " value: " + timestamps.get(key));
			int value = timestamps.get(key);
			if (timeIntensity <= value) {
				validTimes.add(key);
				int[] splittedTime = splitTimeString(key);
				System.out.println("Valid time to start appointment " + key);

				/**
				 * Check for more times to start after a time slot.
				 */
				boolean moreValidTimes = true;
				int newValue = value;
				while (moreValidTimes) {
					newValue = newValue - 15;
					splittedTime[1] = splittedTime[1] + 15;
					if (splittedTime[1] >= 60) {
						splittedTime[1] = 0;
						splittedTime[0] = splittedTime[0] + 1;
					} 
					if (timeIntensity <= newValue) {
						validTimes.add(timeToString(splittedTime));
						System.out.println("Valid time to start appointment " + timeToString(splittedTime));

					} else {
						moreValidTimes = false;
					}
				}
			}
		}
		if(validTimes.size() == 0) {
			validTimes.add("none");
		}
		return validTimes;
	}
	
	public String calculateStopTime(String startTime, int timeIntensity) {
		int[] startTimeInt = splitTimeString(startTime);
		startTimeInt[1] = timeIntensity + startTimeInt[1];
		
		while (startTimeInt[1] >= 60) {
			startTimeInt[1] = startTimeInt[1] - 60;
			startTimeInt[0] = startTimeInt[0] + 1;
		}
		String fullString = timeToString(startTimeInt);
		return fullString;
	}

	//////////////////////////////////////////
	// Getter and setter
	//////////////////////////////////////////

	public void setKm(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setState(AppState state) {
		this.state = state;
	}

	public AppState getState() {
		return state;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Car getCar(Car car) {
		return car;
	}

	public int getApp_Id() {
		return app_Id;
	}

	public void setApp_Id(int app_Id) {
		this.app_Id = app_Id;
	}

	/**
	 * @return the appDate
	 */
	public Date getAppDate() {
		return appDate;
	}

	/**
	 * @param appDate the appDate to set
	 */
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	/**
	 * @return the ws_Id
	 */
	public int getWs_Id() {
		return ws_Id;
	}

	/**
	 * @param ws_Id the ws_Id to set
	 */
	public void setWs_Id(int ws_Id) {
		this.ws_Id = ws_Id;
	}

	/**
	 * @return the regNo
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
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * @return the appServices
	 */
	public List<Service> getAppServices() {
		return appServices;
	}

	/**
	 * @param appServices the appServices to set
	 */
	public void setAppServices(List<Service> appServices) {
		this.appServices = appServices;
	}

}
