package gui;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controller.AppointmentController;
import controller.CarController;
import controller.ServiceController;
import database.DataAccessException;
import module.Car;
import module.Service;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class BookingServices extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 215914176560536241L;

	private AppointmentController appCtr;
	private int km = 0;
	private List<Service> services;
	private List<Service> chosenServices;
	
	private ServiceTable serviceTable;

	/**
	 * Create the panel.
	 */
	public BookingServices() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		try {
			appCtr = new AppointmentController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		chosenServices = new ArrayList<Service>();

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

		JPanel panelService = new JPanel();
		panelService.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(panelService);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(12, 13, 300, 9);

		JSeparator separatorRight = new JSeparator();
		separatorRight.setBounds(438, 13, 300, 9);

		JLabel lblServices = new JLabel("Services");
		lblServices.setBounds(340, 6, 79, 16);
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblServices.setForeground(Color.WHITE);
		setLayout(new CardLayout(0, 0));

		JButton btnNext = new JButton("Booking");
		btnNext.setBounds(613, 577, 140, 23);
		btnNext.setFocusable(false);
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addServices();
				jumpToTimeBooking();
			}
		});
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNext.setIcon(new ImageIcon(BookingServices.class.getResource("/Images/icons8_Right_32px_1.png")));
		btnNext.setContentAreaFilled(false);
		btnNext.setForeground(SystemColor.activeCaption);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnBack = new JButton("Info");
		btnBack.setBounds(22, 576, 121, 25);
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpBackToCarInfo();
			}
		});
		btnBack.setContentAreaFilled(false);
		btnBack.setIcon(new ImageIcon(BookingServices.class.getResource("/Images/icons8_Left_32px.png")));
		btnBack.setForeground(SystemColor.activeCaption);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelService.setLayout(null);
		panelService.add(separatorTop);
		panelService.add(lblServices);
		panelService.add(separatorRight);
		panelService.add(btnBack);
		panelService.add(btnNext);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(22, 35, 732, 490);
		panelService.add(scrollPaneTable);
		
		serviceTable = new ServiceTable();
		scrollPaneTable.setViewportView(serviceTable);
		
		JButton btnAddNewServices = new JButton("Tilf\u00F8j Service");
		btnAddNewServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addService();
			}
		});
		btnAddNewServices.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddNewServices.setIcon(new ImageIcon(BookingServices.class.getResource("/Images/icons8_Car_Service_32px_1.png")));
		btnAddNewServices.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAddNewServices.setForeground(SystemColor.activeCaption);
		btnAddNewServices.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewServices.setFocusable(false);
		btnAddNewServices.setContentAreaFilled(false);
		btnAddNewServices.setBounds(285, 577, 198, 41);
		panelService.add(btnAddNewServices);

		getServices();
		updateTable();

	}

	private void jumpToTimeBooking() { // skifter side til Contact (Kontakt)
		super.getParent();
		// CardLayout cl = (CardLayout) (((Container)
		// AppointmentPanel.panelService).getLayout()); //giver sig selv nullpointer
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); // NullPointer ved 209
		cl.show(getParent(), "booking");
	}

	private void jumpBackToCarInfo() {
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); // NullPointer ved 209
		cl.show(getParent(), "info");
	}

	private void getServices() {
		try {
			services = appCtr.getServices(Main.car, km);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Service service : services) {
			System.out.println(service.getType());
		}
	}
	
	/**
	 * Add services to appointment
	 */
	private void addService() {
		fetchTableRowInfo();
	}
	
	private void addServices() {
		int timeIntensity = appCtr.addServices(AppointmentPanel.appointment,chosenServices);
		AppointmentPanel.timeIntensity = timeIntensity;
	}
	
	/*
	 * Update table.
	 */
	public void updateTable() {
		if (Main.car != null) {
			serviceTable.doUpdate(Main.car, km);
		}
	}
	
	public boolean fetchTableRowInfo() {
		
		int row = serviceTable.getSelectedRow();
		if(row != -1) {
		String serviceEntry = serviceTable.getModel().getValueAt(row, 0).toString();

		List<Service> allServices = serviceTable.getServices();
		for(Service tempService : allServices) {
			if(serviceEntry.contains(tempService.getType())) {
				System.out.println("Service added: " + tempService.getType());
				chosenServices.add(tempService);
			}
		}
		return true;
		}
		else
		{
			JOptionPane.showMessageDialog(getRootPane(), "Vælg en bil først", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
