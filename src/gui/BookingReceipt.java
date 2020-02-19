package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controller.AppointmentController;
import controller.ServiceController;
import database.DataAccessException;
import module.Appointment;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BookingReceipt extends JPanel {
	/**
	 * 
	 */

	private static JTextField textFieldRegNo;
	private static JTextField textFieldModel;
	private static JTextField textFieldColor;
	private static JTextField textFieldKm;
	private static JTextField textFieldYear;
	private static JTextField textFieldBrand;
	private static JTextField textFieldTime;
	private static JTextField textFieldDate;
	private static JTextField textFieldSelectedServices;
	
	private static AppointmentController appCtr;
	private static ServiceController servCtr;

	/**
	 * Create the panel.
	 */
	public BookingReceipt() {
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));
		
		try {
			appCtr = new AppointmentController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		servCtr = new ServiceController();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.RED);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(10, 10));
		scrollPane.setViewportBorder(null);
		scrollPane.setForeground(Color.RED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 753, 589);
		add(scrollPane);
		
		JPanel panelReceipt = new JPanel();
		panelReceipt.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(panelReceipt);
		
		JLabel label = new JLabel("Biloplysninger og V\u00E6rksted");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separatorTopLeft = new JSeparator();
		
		JSeparator separatorTopRight = new JSeparator();
		
		JLabel label_1 = new JLabel("Registreringsnummer");
		label_1.setForeground(SystemColor.activeCaption);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldRegNo = new JTextField();
		textFieldRegNo.setEditable(false);
		textFieldRegNo.setForeground(Color.WHITE);
		textFieldRegNo.setColumns(10);
		textFieldRegNo.setCaretColor(Color.WHITE);
		textFieldRegNo.setBorder(null);
		textFieldRegNo.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorLicensePlate = new JSeparator();
		
		JLabel label_2 = new JLabel("M\u00E6rke");
		label_2.setForeground(SystemColor.activeCaption);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separatorBrand = new JSeparator();
		
		JLabel label_3 = new JLabel("Model & variant");
		label_3.setForeground(SystemColor.activeCaption);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldModel = new JTextField();
		textFieldModel.setEditable(false);
		textFieldModel.setForeground(Color.WHITE);
		textFieldModel.setColumns(10);
		textFieldModel.setCaretColor(Color.WHITE);
		textFieldModel.setBorder(null);
		textFieldModel.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorModel = new JSeparator();
		
		JLabel label_4 = new JLabel("\u00C5rgang");
		label_4.setForeground(SystemColor.activeCaption);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separatorYear = new JSeparator();
		
		JLabel lblColor = new JLabel("Farve");
		lblColor.setForeground(SystemColor.activeCaption);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setForeground(Color.WHITE);
		textFieldColor.setColumns(10);
		textFieldColor.setCaretColor(Color.WHITE);
		textFieldColor.setBorder(null);
		textFieldColor.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorWagonType = new JSeparator();
		
		JLabel label_6 = new JLabel("Kilometerafstand");
		label_6.setForeground(SystemColor.activeCaption);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldKm = new JTextField();
		textFieldKm.setEditable(false);
		textFieldKm.setForeground(Color.WHITE);
		textFieldKm.setColumns(10);
		textFieldKm.setCaretColor(Color.WHITE);
		textFieldKm.setBorder(null);
		textFieldKm.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorKM = new JSeparator();
		
		JButton btnFinish = new JButton("Afslut Booking");
		btnFinish.setFocusable(false);
		btnFinish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//confirmAppointment(AppointmentPanel.appointment);
				AppointmentPanel.appointment.setTimeTo(appCtr.calculateTimeTo(AppointmentPanel.appointment, AppointmentPanel.timeIntensity));
				AppointmentPanel.appointment.setTotalPrice(servCtr.calculateTotalPrice(AppointmentPanel.appointment.getAppServices()));
				System.out.println(AppointmentPanel.appointment.getTimeTo());
				System.out.println(AppointmentPanel.appointment.getTimeFrom());
				System.out.println(AppointmentPanel.appointment.getAppDate());
				try {
					confirmAppointment(AppointmentPanel.appointment);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFinish.setIcon(new ImageIcon(BookingReceipt.class.getResource("/Images/icons8_Checkmark_32px.png")));
		btnFinish.setHorizontalTextPosition(SwingConstants.LEFT);
		btnFinish.setForeground(SystemColor.activeCaption);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.setContentAreaFilled(false);
		btnFinish.setAlignmentX(1.0f);
		
		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setForeground(Color.WHITE);
		textFieldYear.setColumns(10);
		textFieldYear.setCaretColor(Color.WHITE);
		textFieldYear.setBorder(null);
		textFieldYear.setBackground(Color.DARK_GRAY);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setEditable(false);
		textFieldBrand.setForeground(Color.WHITE);
		textFieldBrand.setColumns(10);
		textFieldBrand.setCaretColor(Color.WHITE);
		textFieldBrand.setBorder(null);
		textFieldBrand.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorServicesLeft = new JSeparator();
		
		JSeparator separatorServicesRight = new JSeparator();
		
		JLabel lblServices = new JLabel("Valgte Services");
		lblServices.setForeground(Color.WHITE);
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separatorBookingLeft = new JSeparator();
		
		JLabel lblBookedTime = new JLabel("Tidspunkt");
		lblBookedTime.setForeground(Color.WHITE);
		lblBookedTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separatorBookingRight = new JSeparator();
		
		JLabel lblTime = new JLabel("Tid");
		lblTime.setForeground(SystemColor.activeCaption);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDate = new JLabel("Dato");
		lblDate.setForeground(SystemColor.activeCaption);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnBack = new JButton("Booking");
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpBackToBooking();
			}
		});
		btnBack.setIcon(new ImageIcon(BookingReceipt.class.getResource("/Images/icons8_Left_32px.png")));
		btnBack.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBack.setForeground(SystemColor.activeCaption);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setContentAreaFilled(false);
		btnBack.setAlignmentX(1.0f);
		
		textFieldTime = new JTextField();
		textFieldTime.setEditable(false);
		textFieldTime.setForeground(Color.WHITE);
		textFieldTime.setColumns(10);
		textFieldTime.setCaretColor(Color.WHITE);
		textFieldTime.setBorder(null);
		textFieldTime.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorTime = new JSeparator();
		
		textFieldDate = new JTextField();
		textFieldDate.setEditable(false);
		textFieldDate.setForeground(Color.WHITE);
		textFieldDate.setColumns(10);
		textFieldDate.setCaretColor(Color.WHITE);
		textFieldDate.setBorder(null);
		textFieldDate.setBackground(Color.DARK_GRAY);
		
		JSeparator separatorDate = new JSeparator();
		
		JLabel lblSelectedServices = new JLabel("\u00D8nskede Services");
		lblSelectedServices.setForeground(SystemColor.activeCaption);
		lblSelectedServices.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldSelectedServices = new JTextField();
		textFieldSelectedServices.setEditable(false);
		textFieldSelectedServices.setForeground(Color.WHITE);
		textFieldSelectedServices.setColumns(10);
		textFieldSelectedServices.setCaretColor(Color.WHITE);
		textFieldSelectedServices.setBorder(null);
		textFieldSelectedServices.setBackground(Color.DARK_GRAY);
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panelReceipt = new GroupLayout(panelReceipt);
		gl_panelReceipt.setHorizontalGroup(
			gl_panelReceipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(12)
					.addComponent(separatorTopLeft, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separatorTopRight, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(144)
					.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldRegNo, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(textFieldColor, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separatorLicensePlate, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(separatorWagonType, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(144)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldBrand, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(textFieldKm, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separatorBrand, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(separatorKM, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldModel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separatorModel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldYear, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separatorYear, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(12)
					.addComponent(separatorServicesLeft, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServices, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(210)
							.addComponent(separatorServicesRight, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(lblSelectedServices, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldSelectedServices, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(12)
					.addComponent(separatorBookingLeft, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addGap(89)
					.addComponent(lblBookedTime, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(separatorBookingRight, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(130)
					.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(textFieldTime, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(150)
					.addComponent(separatorTime, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(separatorDate, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGap(46)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(408)
					.addComponent(btnFinish))
		);
		gl_panelReceipt.setVerticalGroup(
			gl_panelReceipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReceipt.createSequentialGroup()
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(13)
							.addComponent(separatorTopLeft, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(13)
							.addComponent(separatorTopRight, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldRegNo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(separatorLicensePlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separatorWagonType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(1)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(5)
							.addComponent(textFieldBrand, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldKm, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(separatorBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separatorKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textFieldModel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(separatorModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textFieldYear, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(separatorYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(18)
							.addComponent(separatorServicesLeft, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblServices, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(18)
							.addComponent(separatorServicesRight, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addComponent(lblSelectedServices, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textFieldSelectedServices, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(106)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(18)
							.addComponent(separatorBookingLeft, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBookedTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelReceipt.createSequentialGroup()
							.addGap(18)
							.addComponent(separatorBookingRight, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTime, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(separatorTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separatorDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panelReceipt.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
		);
		panelReceipt.setLayout(gl_panelReceipt);

		//setBookingCarReceipt();

	}

	private void jumpBackToBooking()
	{
		CardLayout cl = (CardLayout) (((getParent()).getLayout()));
		cl.show(getParent(), "booking");
	}
	
	public static void setBookingCarReceipt() 
	{ 	
	
		textFieldRegNo.setText(Main.car.getRegNo());
		textFieldBrand.setText(Main.car.getBrand());
		textFieldModel.setText(Main.car.getModel());
		textFieldColor.setText(Main.car.getColor());
		textFieldKm.setText(Integer.toString(Main.car.getKm()));
		textFieldYear.setText(Integer.toString(Main.car.getYear()));
		
	}
	
	/**
	 * Confirm appointment by checking the database, for new entries while choosing.
	 * If not, put into appointment db, if yes, cancel transaction.
	 * @param Appointment
	 * @throws SQLException 
	 */
	private void confirmAppointment(Appointment appointment) throws SQLException {
		try {
			appCtr.confirmAppointment(appointment, appointment.getAppServices());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
