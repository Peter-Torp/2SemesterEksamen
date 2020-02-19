package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.CardLayout;

import gui.BookingCarInfo;
import gui.BookingServices;
import module.Appointment;
import module.Service;
import module.Appointment.AppState;

public class AppointmentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //unik identifier
	public static Container panelService;
	private BookingCarInfo bookingCarInfo;
	private BookingServices bookingServices;
	private BookingCalendar bookingCalendar;
	private BookingReceipt bookingReceipt;
	
	public static Appointment appointment;
	public static int timeIntensity;

	/**
	 * Create the panel.
	 */
	public AppointmentPanel() {
		createAppointment();
		
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));
		
		JPanel parentPanel = new JPanel (new CardLayout());
		add(parentPanel, "parentPanelApp");
		parentPanel.setLayout(new CardLayout(0, 0));
		
		bookingCarInfo = new BookingCarInfo();
		parentPanel.add(bookingCarInfo, "info");
		
		bookingServices = new BookingServices();
		parentPanel.add(bookingServices, "service");
		
		bookingCalendar = new BookingCalendar();
		parentPanel.add(bookingCalendar, "booking");
		
		bookingReceipt = new BookingReceipt();
		parentPanel.add(bookingReceipt, "receipt");
	}
	
	private void createAppointment() {
List<Service> services = new ArrayList<>();
		
		Date appDate = new Date();
		
		appointment = new Appointment(
				0,
				AppState.PENDING,
				"0",
				"0",
				appDate,
				Main.car.getRegNo(),
				Main.car.getKm(),
				0,//App Id
				1
				);
		appointment.setTotalPrice(appointment.calcPrice(services));
	}

}
