package gui;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import controller.CarController;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;

public class Frontpage extends JPanel {

	/**
	 * 
	 */

	private CarTable carTable;


	/**
	 * Create the panel.
	 */
	public Frontpage() {

		setLayout(new CardLayout(0, 0));

		JPanel panelFrontpage = new JPanel(new CardLayout());
		panelFrontpage.addMouseListener(new MouseAdapter() {

		});
		panelFrontpage.setBackground(Color.DARK_GRAY);
		add(panelFrontpage, "name_2511302589058900");
		panelFrontpage.setLayout(null);

		JButton btnLookCarInfo = new JButton("G\u00E5 til bil");
		btnLookCarInfo.setFocusable(false);
		btnLookCarInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLookCarInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canContinue = fetchTableRowInfo();
				if(canContinue) {
				jumpToFrontpageCarInfo();
				FrontpageCar.getCarInfo(Main.car);
				showButtons();
				}
			}

		});
		btnLookCarInfo.setIcon(new ImageIcon(Frontpage.class.getResource("/Images/icons8_Car_32px.png")));
		btnLookCarInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLookCarInfo.setForeground(SystemColor.activeCaption);
		btnLookCarInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLookCarInfo.setContentAreaFilled(false);
		btnLookCarInfo.setAlignmentX(1.0f);
		btnLookCarInfo.setBounds(640, 505, 140, 41);
		panelFrontpage.add(btnLookCarInfo);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);

		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 66, 609, 480);
		panelFrontpage.add(scrollPane);

		carTable = new CarTable() {

			public boolean isCellEditable(int row, int column) { // Cant double click to edit in table but single click
																	// to select
				return false;
			}
		};
		carTable.setSelectionBackground(SystemColor.activeCaption);
		carTable.setBorder(null);
		carTable.setGridColor(Color.WHITE);
		carTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		carTable.setForeground(SystemColor.activeCaption);
		carTable.setBackground(Color.DARK_GRAY);
		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carTable.setRequestFocusEnabled(false);
		carTable.setRowHeight(35);
		scrollPane.setViewportView(carTable);

		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 13, 296, 11);
		panelFrontpage.add(separatorTopLeft);

		JLabel lblHome = new JLabel("Hjem");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHome.setBounds(353, 0, 78, 29);
		panelFrontpage.add(lblHome);

		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(461, 13, 296, 11);
		panelFrontpage.add(separatorTopRight);
		
		JLabel lblPickCar = new JLabel("V\u00E6lg deres bil");
		lblPickCar.setSize(150, 30);
		lblPickCar.setLocation(25, 28);
		lblPickCar.setForeground(SystemColor.activeCaption);
		lblPickCar.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelFrontpage.add(lblPickCar, "name_1601273003832700");

		updateTable();
	}

	private void jumpToFrontpageCarInfo() { // skifter side til Contact (Kontakt)
		super.getParent();
		// CardLayout cl = (CardLayout) (((Container)
		// AppointmentPanel.panelService).getLayout()); //giver sig selv nullpointer
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); // NullPointer ved 209
		cl.show(getParent(), "frontpagecar");
	}

	/*
	 * Update table.
	 */
	public void updateTable() {
		if (Main.customer != null) {
			carTable.doUpdate(Main.customer.getCus_Id());
		}
	}

	/**
	 * Get selected row, then find car in db.
	 */
	public boolean fetchTableRowInfo() {
		
		int row = carTable.getSelectedRow();
		if(row != -1) {
		String cartab = carTable.getModel().getValueAt(row, 0).toString();

		CarController carController = new CarController();
		Main.car = carController.getCar(cartab);
		return true;
		}
		else
		{
			JOptionPane.showMessageDialog(getRootPane(), "Vælg en bil først", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}

	/**
	 * Call to show buttons in main.
	 */
	public void showButtons() {
		Main.btnAppointment.setVisible(true);
		Main.btnContact.setVisible(true);
		Main.btnDiary.setVisible(true);
	}
			
}
