package database;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import module.Appointment;
import module.Car;
import module.Service;

public interface AppointmentDBIF {
	
	
	
	/**
	 * IKKE FUNKTIONEL!
	 * Return possible dates to choose
	 * @param Timeintensity
	 * @return dates
	 */
	public Date getDates(int Timeintensity);
	
	
	/**
	 * Find all appointments associated with a car
	 * Calling method buildObejcts
	 * Returning List<> with appointments
	 * @param Car car 
	 * @return List of appointments[]
	 */
	List<Appointment> findAllAppointments(Car car) throws DataAccessException;
	
	
	/**
	 * Insert an appointment into the database
	 * @param Appointment appointment 
	 * @param List of services[]
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	int insertAppointment(Appointment appointment,List<Service> services) throws DataAccessException, SQLException;
	
	
	/**
	 * Confirm appointment and insert it into database	//IKKE FUNKTIONEL!
	 * @param appointment
	 * @param car
	 * @return 
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	boolean confirmAppointment(Appointment appointment, Car car) throws DataAccessException, SQLException; 
	
	
	/**
	 * Delete an appointment by appId
	 * @param appId
	 */
	public void deleteApp(String appId) throws SQLException; 
	
	/**
	 * Find appointments by app_Id
	 * @param int app_Id
	 * @return Appointment appointment
	 * @throws DataAccessException
	 */
	public Appointment findAppointmentByAppId(int app_Id) throws DataAccessException;
	
	/**
	 * Return a list of appointments
	 * @param String RegNo 
	 * @return list of appointments[]
	 * @throws DataAccessException
	 */
	public List<Appointment> findAppointmentsByRegNo(String RegNo) throws DataAccessException;
	
	/**
	 * Return a hashmap 
	 * @param Appointment appointment
	 * @return Hashmap<String, Integer> 
	 * @throws DataAccessException
	 */
	public HashMap<String, Integer> timestamps(Appointment appointment) throws DataAccessException;
	
	

}
