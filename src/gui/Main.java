package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.CustomerController;
import controller.EmployeeController;
import database.DBConnection;
import database.DataAccessException;
import module.Appointment;
import module.Car;
import module.Customer;
import module.Employee;
import module.Person;
import module.Person.PersonType;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Main extends JFrame{

	/**
	 * 
	 */

	private JPanel contentPane;

	int xx, xy;

	private JPanel contact;

	private JPanel appointment;

	private JPanel diary;

	private JPanel frontpage;

	private JPanel parentPanel;

	private JPanel panelLeft;

	private static DBConnectionPanel dbConnPanel;

	private JPanel admin;
	private JTextField textFieldWelcome;

	protected static Employee employee;
	protected static Customer customer;
	protected static Car car;
	protected static Appointment app;

	protected static JButton btnAppointment;
	protected static JButton btnContact;
	protected static JButton btnDiary;
	private JButton btnHej;
	private CustomerController cusCtr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Person person) {
		determinePType(person);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setUndecorated(true); // Hides the jframe top bar
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {

		dbConnPanel = new DBConnectionPanel();
		try {
			cusCtr = new CustomerController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(51, 51, 51));
		panelLeft.setForeground(Color.DARK_GRAY);
		panelLeft.setBounds(0, 78, 150, 636);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		DBConnectionPanel connectionPanel = new DBConnectionPanel();
		connectionPanel.setBounds(12, 402, 126, 42);
		panelLeft.add(connectionPanel);

		JPanel panelTop = new JPanel();
		panelTop.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				moveWindowMouseDragged(arg0); // Metoden bliver kaldt - oprettet på linje 264
			}
		});
		panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				moveWindowMousePressed(e); // Metoden bliver kaldt - oprettet på linje 270
			}
		});
		panelTop.setBackground(new Color(51, 51, 51));
		panelTop.setBounds(0, 0, 987, 78);
		contentPane.add(panelTop);
		panelTop.setLayout(null);

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Exit_32px.png")));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setRolloverIcon(null);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setFocusTraversalKeysEnabled(false);
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setContentAreaFilled(false);
		btnExit.setForeground(SystemColor.activeCaption);
		btnExit.setBorder(null);
		btnExit.setBounds(900, 25, 66, 25);
		panelTop.add(btnExit);

		JLabel lblCompanyLogo = new JLabel("");
		lblCompanyLogo.setIcon(new ImageIcon(Main.class.getResource("/Images/uggerh\u00F8jmeddigvejen.PNG")));
		lblCompanyLogo.setBounds(5, 5, 246, 62);
		panelTop.add(lblCompanyLogo);

		textFieldWelcome = new JTextField();
		textFieldWelcome.setFocusTraversalKeysEnabled(false);
		textFieldWelcome.setFocusable(false);
		textFieldWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldWelcome.setForeground(Color.WHITE);
		textFieldWelcome.setEditable(false);
		textFieldWelcome.setColumns(10);
		textFieldWelcome.setCaretColor(Color.WHITE);
		textFieldWelcome.setBorder(null);
		textFieldWelcome.setBackground(new Color(51, 51, 51));
		textFieldWelcome.setBounds(263, 25, 195, 40);
		panelTop.add(textFieldWelcome);

		parentPanel = new JPanel(new CardLayout());
		parentPanel.setBackground(Color.GRAY);
		parentPanel.setBounds(148, 78, 812, 636);
		contentPane.add(parentPanel);
		parentPanel.setLayout(new CardLayout(0, 0));

		frontpage = new JPanel();
		frontpage.setBackground(Color.GRAY);
		parentPanel.add(frontpage, "frontpage");
		frontpage.setFocusable(false);
		frontpage.setLayout(new CardLayout(0, 0));

		FrontpagePanel frontpagePanel = new FrontpagePanel();
		frontpage.add(frontpagePanel, "name_1121608453469600");

//		diary = new JPanel();
//		diary.setBackground(Color.GRAY);
//		parentPanel.add(diary, "diary");
//		diary.setLayout(new CardLayout(0, 0));
//
//		DiaryPanel diaryPanel = new DiaryPanel();
//		diary.add(diaryPanel, "name_1121051246889700");
//		diaryPanel.setLayout(new CardLayout(0, 0));

//		appointment = new AppointmentPanel();
//		appointment.setBackground(Color.GRAY);
//		parentPanel.add(appointment, "appointment");
//		appointment.setLayout(new CardLayout(0, 0));
//
//		AppointmentPanel appointmentPanel = new AppointmentPanel();
//		appointment.add(appointmentPanel, "name_2086032791222700");
//		appointmentPanel.setLayout(new CardLayout(0, 0));

//		admin = new JPanel();
//		parentPanel.add(admin, "admin");
//		admin.setLayout(new CardLayout(0, 0));
//
//		AdminPanel adminPanel = new AdminPanel();
//		admin.add(adminPanel, "name_1903793252227200");
//		adminPanel.setLayout(new CardLayout(0, 0));

		if (employee != null) {
			/* SET NAME TEXT */
			textFieldWelcome.setText("Velkommen, " + employee.getFirstName());

			/* SPAWN BUTTONS */
			adminButtonInitialize();

			/* START PAGE */
			jumpToAdmin();
		} else if (customer != null) {
			/* SET NAME TEXT */
			textFieldWelcome.setText("Velkommen, " + customer.getFirstName());

			/* SPAWN BUTTONS */
			frontPageButtonInitialize();
			diaryButtonInitialize();
			appointmentButtonInitialize();
			contactButtonInitialize();

			/* START PAGE */
			jumpToFrontpage();
			System.out.println(customer.getFirstName() + customer.getType());
		}

		Threading thread = new Threading();
		thread.start();
		
	}

	private void frontPageButtonInitialize() {
		JButton btnFrontpage = new JButton("Forside");
		btnFrontpage.setFocusTraversalKeysEnabled(false);
		btnFrontpage.setFocusable(false);
		btnFrontpage.setFocusPainted(false);
		btnFrontpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpToFrontpage(); // Metoden bliver kaldt - oprettet på linje 247
			}

		});
		btnFrontpage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFrontpage.setForeground(SystemColor.activeCaption);
		btnFrontpage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFrontpage.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Home_32px_1.png")));
		btnFrontpage.setContentAreaFilled(false);
		btnFrontpage.setBorderPainted(false);
		btnFrontpage.setBorder(null);
		btnFrontpage.setBounds(16, 60, 112, 30);
		panelLeft.add(btnFrontpage);
	}

	private void diaryButtonInitialize() {
		btnDiary = new JButton("Dagbog");
		btnDiary.setFocusable(false);
		btnDiary.setFocusTraversalKeysEnabled(false);
		btnDiary.setFocusPainted(false);
		btnDiary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jumpToDiary();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Metoden bliver kaldt - oprettet på linje 252
			}
		});
		btnDiary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDiary.setContentAreaFilled(false);
		btnDiary.setBorderPainted(false);
		btnDiary.setBorder(null);
		btnDiary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDiary.setForeground(SystemColor.activeCaption);
		btnDiary.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Book_32px.png")));
		btnDiary.setBounds(16, 116, 112, 30);
		btnDiary.setVisible(false);
		panelLeft.add(btnDiary);
	}

	private void appointmentButtonInitialize() {
		btnAppointment = new JButton("Aftaler");
		btnAppointment.setFocusPainted(false);
		btnAppointment.setFocusTraversalKeysEnabled(false);
		btnAppointment.setFocusable(false);
		btnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToAppointments(); // Metoden bliver kaldt - oprettet på linje 257
			}
		});
		btnAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAppointment.setContentAreaFilled(false);
		btnAppointment.setBorderPainted(false);
		btnAppointment.setBorder(null);
		btnAppointment.setForeground(SystemColor.activeCaption);
		btnAppointment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAppointment.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Planner_32px.png")));
		btnAppointment.setBounds(16, 173, 112, 30);
		btnAppointment.setVisible(false);
		panelLeft.add(btnAppointment);
	}

	private void contactButtonInitialize() {
		btnContact = new JButton("Kontakt");
		btnContact.setFocusable(false);
		btnContact.setFocusTraversalKeysEnabled(false);
		btnContact.setFocusPainted(false);
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToContact(); // Metoden bliver kaldt - oprettet på linje 262
			}
		});
		btnContact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContact.setContentAreaFilled(false);
		btnContact.setBorder(null);
		btnContact.setBorderPainted(false);
		btnContact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContact.setForeground(SystemColor.activeCaption);
		btnContact.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Phone_32px.png")));
		btnContact.setBounds(16, 231, 112, 30);
		btnContact.setVisible(false);
		panelLeft.add(btnContact);

	}

	/**
	 * Admin button initialize. To show the button and make it clickable.
	 */
	private void adminButtonInitialize() {
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToAdmin();
			}
		});
		btnAdmin.setIcon(new ImageIcon(Main.class.getResource("/Images/icons8_Administrative_Tools_32px.png")));
		btnAdmin.setForeground(SystemColor.activeCaption);
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdmin.setFocusable(false);
		btnAdmin.setFocusTraversalKeysEnabled(false);
		btnAdmin.setFocusPainted(false);
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setBorder(null);
		btnAdmin.setBounds(16, 30, 112, 30);
		panelLeft.add(btnAdmin);

	}

	private void jumpToFrontpage() { // skifter side til Frontpage (Forside)
//		frontpage = new JPanel();
//		frontpage.setBackground(Color.GRAY);
//		parentPanel.add(frontpage, "frontpage");
//		frontpage.setFocusable(false);
//		frontpage.setLayout(new CardLayout(0, 0));
//
//		FrontpagePanel frontpagePanel = new FrontpagePanel();
//		frontpage.add(frontpagePanel, "name_1121608453469600");

		CardLayout cl = (CardLayout) (parentPanel.getLayout());
		cl.show(parentPanel, "frontpage");

	}

	private void jumpToDiary() throws DataAccessException { // skifter side til Diary (Dagbog)
		diary = new JPanel();
		diary.setBackground(Color.GRAY);
		parentPanel.add(diary, "diary");
		diary.setLayout(new CardLayout(0, 0));

		DiaryPanel diaryPanel = new DiaryPanel();
		diary.add(diaryPanel, "name_1121051246889700");
		diaryPanel.setLayout(new CardLayout(0, 0));

		CardLayout cl = (CardLayout) (parentPanel.getLayout()); // Vi henter vores CardLayout
		cl.show(parentPanel, "diary"); // Vi siger den skal vise vores parentPanel hvor der er et kort der hedder diary
	}

	private void jumpToAppointments() { // skifter side til Appointments (Aftaler)
		appointment = new JPanel();
		appointment.setBackground(Color.GRAY);
		parentPanel.add(appointment, "appointment");
		appointment.setLayout(new CardLayout(0, 0));

		AppointmentPanel appointmentPanel = new AppointmentPanel();
		appointment.add(appointmentPanel, "name_2086032791222700");
		appointmentPanel.setLayout(new CardLayout(0, 0));

		CardLayout cl = (CardLayout) (parentPanel.getLayout()); // Vi henter vores CardLayout
		cl.show(parentPanel, "appointment"); // Vi siger den skal vise vores parentPanel hvor der er et kort der hedder
												// appointment
	}

	/**
	 * To load the JPanel and show it.
	 */
	private void jumpToContact() { // skifter side til Contact (Kontakt)
		/* Auto generated */
		contact = new JPanel();
		contact.setBackground(Color.GRAY);
		parentPanel.add(contact, "contact");
		contact.setLayout(new CardLayout(0, 0));

		Contact contactPanel = new Contact();
		contactPanel.setBounds(0, 0, 1, 1);
		contact.add(contactPanel);
		/* Auto generated */

		CardLayout cl = (CardLayout) (parentPanel.getLayout()); // Vi henter vores CardLayout
		cl.show(parentPanel, "contact"); // Vi siger den skal vise vores parentPanel hvor der er et kort der hedder
											// contact
	}

	private void jumpToAdmin() { // skifter side til Contact (Kontakt)
		admin = new JPanel();
		parentPanel.add(admin, "admin");
		admin.setLayout(new CardLayout(0, 0));

		AdminPanel adminPanel = new AdminPanel();
		admin.add(adminPanel, "name_1903793252227200");
		adminPanel.setLayout(new CardLayout(0, 0));

		CardLayout cl = (CardLayout) (parentPanel.getLayout()); // Vi henter vores CardLayout
		cl.show(parentPanel, "admin"); // Vi siger den skal vise vores parentPanel hvor der er et kort der hedder
										// contact
	}

	private void moveWindowMouseDragged(MouseEvent arg0) {
		int x = arg0.getXOnScreen(); // makes uggerhøj picture dragable
		int y = arg0.getYOnScreen(); // makes uggerhøj picture dragable
		Main.this.setLocation(x - xx, y - xy); // makes uggerhøj picture dragable
	}

	private void moveWindowMousePressed(MouseEvent e) {
		xx = e.getX(); // makes uggerhøj picture dragable
		xy = e.getY(); // makes uggerhøj picture dragable
	}

	/**
	 * To determine if an object of Person is either an employee or customer.
	 * 
	 * @param person
	 */
	private static void determinePType(Person person) {
		EmployeeController empCon;
		CustomerController cusCon;
		try {
			empCon = new EmployeeController();
			cusCon = new CustomerController();

			// Check for person type.
			if (PersonType.EMP == person.getType()) {
				employee = empCon.findEmployeeByEmail(person.getEmail());
			} else if (PersonType.CUS == person.getType()) {
				customer = cusCon.findCustomerByEmail(person.getEmail());
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	class Threading extends Thread {
		

		public void run() {
			System.out.println("Thread running");
			while (true) {
				
				try {
					cusCtr.findPersonByEmail("fulderik@youmail.com");
					dbConnPanel.connected();
				} catch(SQLException e) {
					dbConnPanel.notConnected();
				}

				
				
				try {
					Thread.sleep(10000);			//sleep for 10 secs
				} catch (InterruptedException e) {
					try {
						throw e;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		}
	}
	


	
}
