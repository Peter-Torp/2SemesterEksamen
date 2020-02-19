package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import controller.AppointmentController;
import controller.CarController;
import database.DataAccessException;
import module.Appointment;
import module.Appointment.AppState;
import module.Car;
import module.Service;

@TestInstance(Lifecycle.PER_CLASS)
class AppointmentTest {
	
	
	private AppointmentController appCon;
	private CarController carCon; 
	
	@BeforeAll
	void setUp() throws Exception {
		this.appCon = new AppointmentController();
		this.carCon = new CarController(); 
	}


	@Test
	void testInsertAppointment() throws DataAccessException, SQLException, ParseException {
		//Arrange
		List<Service> services = new ArrayList<>();
		
		Service service1 = new Service("Olie tjek", 15, 400, 2,2);
		Service service2 = new Service("Bremse eftersyn", 30, 800, 3, 3);
		
		services.add(service1);
		services.add(service2);
		
		Appointment appointment = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "01-06-2019 10:20:56";
		Date appDate;

		appDate = sdf.parse(dateInString);
		System.out.println(appDate);
		

		//appointment.calcTimeIntensity(services);
		appointment = new Appointment(
				0,
				AppState.PENDING,
				"09:00",
				"08:45",
				appDate,
				"RE22843",
				20000,
				0,
				1
				);
		appointment.setTotalPrice(appointment.calcPrice(services));
		
		Appointment appointment2;
		
		//Act
		int app_Id = appCon.createAppointment(appointment, services);
		appointment2 = appCon.findAppointment(app_Id);
		
		//Assert
		assert(appointment2.getRegNo().equals(appointment.getRegNo()));
	}
	
	
	@Test
	void testFindAppointment() {
		//Arrange
		List<Service> services = new ArrayList<>();
		
		Service service1 = new Service("Olie tjek", 15, 400, 2,2);
		Service service2 = new Service("Bremse eftersyn", 30, 800, 3, 3);
		
		services.add(service1);
		services.add(service2);
		
		Appointment appointment = null;
		Date appDate = new Date();
		//appointment.calcTimeIntensity(services);
		appointment = new Appointment(
				0,
				AppState.PENDING,
				"09:00",
				"08:45",
				appDate,
				"RE22843",
				20000,
				0,
				1
				);
		appointment.setTotalPrice(appointment.calcPrice(services));
		
		appCon.checkTimes(appointment);
		System.out.println("Done");
 
	}
	
	
	@Test 
/*	void testFindAllApointments() throws DataAccessException, SQLException {
		//Arrange
		Car car4 = carCon.createCar("Opel", "Corsa", "Black", 2017, "1212121212", 4000,3); 
		
		//Act
		List<Appointment> AppointmentsList2 = appCon.getAppointments(car4); 
		
		//Assert
		assertEquals(appointmentsList, AppointmentsList2);
	} */
	
	
	@AfterAll 
	void cleanUp() throws SQLException, DataAccessException {
		
	}
	


}
