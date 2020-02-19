package controller;

import module.*;

import java.util.List;

import database.*;

public class ServiceController {

	private ServiceDBIF serviceDB;
	private Service service;
	
	public ServiceController()
	{
		try {
			serviceDB = new ServiceDB();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * get services of a car
	 * @param Car car
	 * @param int km 
	 * @return List of services[]
	 * @throws DataAccessException
	 */
    public List<Service> getServices(Car car, int km) throws DataAccessException
    {
      return serviceDB.findAllServices(car, km);
    }
    
    /**
     * Calculate timeIntensity of services
     * @param List of services[]
     * @return int totalTime
     */
    public int calculateTimeIntensity(List<Service> services) {
    	int totalTime = 0;
    	for(Service service : services) {
    		totalTime = totalTime + service.getTimeIntensity();
    		System.out.println("totalTime : " + totalTime);
    	}
    	return totalTime;
    }
    
    /**
     * calculate totalPrice
     * @param List of services[]
     * @return double totalPrice
     */
    public double calculateTotalPrice(List<Service> services) {
    	double totalPrice = 0;
    	for(Service service : services) {
    		totalPrice = totalPrice + service.getPrice();
    		System.out.println("totalPrice : " + totalPrice);
    	}
    	return totalPrice;
    }
    
}
