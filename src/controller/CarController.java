package controller;

import module.Car;
import database.*;

import java.sql.SQLException;
import java.util.List;

public class CarController {

	private CarDBIF carDB;
	public CarDB cDB; 
	public Car car;
	   
	public CarController()
	{
		try {
			carDB = new CarDB();
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createCar(String brand, String model, String color, int year, String regNo, int km, int emp_Id) throws DataAccessException, SQLException {
		
		try {
			
			Car car = new Car(brand, model, color, year, regNo, km, emp_Id); 	
			
			
			
				carDB.insertCar(car); 
			
		
		} catch (NullPointerException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_CREATE, e); 
		}
		
		
	}
	
	
	/**
	 * get the cars associated with a cus_Id
	 * @param int cus_Id
	 * @return list of cars[]
	 */
    public List<Car> getCars(int cus_Id){
    	return carDB.findCarsByCus_Id(cus_Id);
      
    }
    
    
    /**
     * get a car by regNo
     * @param String regNo
     * @return a car object
     */
	public Car getCar(String regNo)
    {
    	Car car = carDB.findByRegNo(regNo);
    	return car;
    }
     
	
	 /**
     * Delete car by regNo. 
     * @param String regNo
     */
    public boolean deleteCarByRegNo(String regNo) throws SQLException, DataAccessException {
    	return carDB.deleteCarByRegNo(regNo); 
    }
    
}
