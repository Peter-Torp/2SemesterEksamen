package controller;

import module.Appointment;
import module.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import database.AppointmentDB;
import database.AppointmentDBIF;
import database.DBMessages;
import database.DataAccessException;

public class AppointmentController {

	private AppointmentDBIF aDB;

	private ServiceController serviceController;

	public AppointmentController() throws DataAccessException {
		aDB = new AppointmentDB();
		serviceController = new ServiceController();
	}

	
	/**
	 * create an appointment
	 * @param appointment
	 * @param services
	 * @return list of services[]
	 * @throws DataAccessException
	 */
	public int createAppointment(Appointment appointment, List<Service> services) throws DataAccessException {
		try {
			return aDB.insertAppointment(appointment, services);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(DBMessages.COULD_NOT_CONFIRM, e);
		}
	}

	public String calculateTimeTo(Appointment appointment, int timeIntensity) {
		return appointment.calculateStopTime(appointment.getTimeFrom(), timeIntensity);
	}

	public List<Service> getServices(Car car, int km) throws DataAccessException {
		List<Service> services;

		return services = serviceController.getServices(car, km);

	}

	/**
	 * Checking if appointment has null values. If null - Throw message and
	 * exception
	 * @param appointment
	 * @param car
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public int confirmAppointment(Appointment appointment, List<Service> services) throws DataAccessException, SQLException {
		
		return createAppointment(appointment, services);

	}

	/**
	 * Add services to a appointment object and return calculated total time intensity of all services.
	 * @param Appointment appointment
	 * @param List of services[]
	 * @return int timeIntensity
	 */
	public int addServices(Appointment appointment, List<Service> services) {
		appointment.addServices(services);
		return appointment.calcTimeIntensity(services);
	}

	public Appointment findAppointment(int app_Id) {
		Appointment appointment = null;
		try {
			appointment = aDB.findAppointmentByAppId(app_Id);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointment;
	}
	
	
	/**
	 * add date to appointment
	 * @param appointment
	 * @param date
	 */
	public void addDate(Appointment appointment, Date date) {
		appointment.setAppDate(date);
	}

	public List<Appointment> findAppointmentsByRegNo(String RegNo) {
		List<Appointment> appointments = null;
		try {
			appointments = aDB.findAppointmentsByRegNo(RegNo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;

	}

	/**
	 * Return a list with all the appointments associated with a certain car.
	 * 
	 * @param car
	 * @return
	 * @throws DataAccessException
	 */
	public List<Appointment> getAppointments(Car car) throws DataAccessException {
		return aDB.findAllAppointments(car);
	}

	/**
	 * Check the times on a given date.
	 * @param appointment
	 * @return List<String> validTimes
	 * TODO: If no appointments that day???
	 * TODO: If appointment is mid day, it will make all previous times occupied.
	 */
	public List<String> checkTimes(Appointment appointment) {
		HashMap<String, Integer> timestamps = new HashMap<String, Integer>();
		List<String> validTimes;

		try {
			timestamps = aDB.timestamps(appointment);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int timeIntensity = serviceController.calculateTimeIntensity(appointment.getAppServices());

		validTimes = appointment.validTimes(timestamps, timeIntensity);

		return validTimes;
	}
	
	
	/**
	 * delete appointment by appId
	 * @param String appId
	 * @throws SQLException
	 */
	public void deleteAppByIdString(String appId) throws SQLException {

		aDB.deleteApp(appId);

	}
	

}
