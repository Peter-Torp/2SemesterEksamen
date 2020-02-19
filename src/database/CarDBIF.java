package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import module.Car;

public interface CarDBIF {
	
	/**
	 * Find cars of a specific customer by customer id.
	 * @param int cus_Id
	 * @return Cars[]
	 * @throws SQLException
	 */
	public List<Car> findCarsByCus_Id(int cus_Id); 
	
	/**
	 * Find a vehicle in the database by registration number.
	 * @param String regNo
	 * @return Car car
	 * @throws SQLException
	 */
	public Car findByRegNo(String regNo);

	
	/**
	 * Delete a car by a regNo 
	 * @param String regNo
	 * @return true or false
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	boolean deleteCarByRegNo(String regNo) throws SQLException, DataAccessException;
	
	
	/**
	 * Insert car into database
	 * @param Car car
	 * @return Car car
	 * @throws DataAccessException 
	 * @throws SQLException 
	 */
	public Car insertCar(Car car) throws DataAccessException, SQLException;

	

}
