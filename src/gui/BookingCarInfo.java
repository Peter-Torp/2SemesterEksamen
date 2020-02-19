package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import gui.Frontpage;
import module.Car;

import java.awt.Component;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Cursor;

public class BookingCarInfo extends JPanel {
	/**
	 * 
	 */
	
	private static JTextField textFieldRegNo;
	private static JTextField textFieldModel;
	private static JTextField textFieldColor;
	private static JTextField textFieldKm;
	private static JTextField textFieldYear;
	private static JTextField textFieldBrand;
	
	

	/**
	 * Create the panel.
	 */
	public BookingCarInfo() {
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.DARK_GRAY);
		add(panelInfo, "name_2083373041506900");
		panelInfo.setLayout(null);
		
		JLabel lblBiloplysninger = new JLabel("Biloplysninger og V\u00E6rksted");
		lblBiloplysninger.setForeground(Color.WHITE);
		lblBiloplysninger.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBiloplysninger.setBounds(257, 0, 243, 29);
		panelInfo.add(lblBiloplysninger);
		
		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 13, 221, 11);
		panelInfo.add(separatorTopLeft);
		
		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(512, 13, 221, 11);
		panelInfo.add(separatorTopRight);
		
		JLabel lblNewLabel = new JLabel("Registreringsnummer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(150, 60, 158, 16);
		panelInfo.add(lblNewLabel);
		
		textFieldRegNo = new JTextField();
		textFieldRegNo.setEditable(false);
		textFieldRegNo.setForeground(Color.WHITE);
		textFieldRegNo.setColumns(10);
		textFieldRegNo.setCaretColor(Color.WHITE);
		textFieldRegNo.setBorder(null);
		textFieldRegNo.setBackground(Color.DARK_GRAY);
		textFieldRegNo.setBounds(150, 90, 169, 22);
		panelInfo.add(textFieldRegNo);
		
		JSeparator separatorLicense = new JSeparator();
		separatorLicense.setBounds(150, 120, 169, 2);
		panelInfo.add(separatorLicense);
		
		JLabel lblBrand = new JLabel("M\u00E6rke");
		lblBrand.setForeground(SystemColor.activeCaption);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrand.setBounds(150, 150, 158, 16);
		panelInfo.add(lblBrand);
		
		JSeparator separatorBrand = new JSeparator();
		separatorBrand.setBounds(150, 210, 169, 2);
		panelInfo.add(separatorBrand);
		
		JLabel lblModelVariant = new JLabel("Model & variant");
		lblModelVariant.setForeground(SystemColor.activeCaption);
		lblModelVariant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelVariant.setBounds(150, 240, 158, 16);
		panelInfo.add(lblModelVariant);
		
		textFieldModel = new JTextField();
		textFieldModel.setEditable(false);
		textFieldModel.setForeground(Color.WHITE);
		textFieldModel.setColumns(10);
		textFieldModel.setCaretColor(Color.WHITE);
		textFieldModel.setBorder(null);
		textFieldModel.setBackground(Color.DARK_GRAY);
		textFieldModel.setBounds(150, 270, 169, 22);
		panelInfo.add(textFieldModel);
		
		JSeparator separatorModel = new JSeparator();
		separatorModel.setBounds(150, 300, 169, 2);
		panelInfo.add(separatorModel);
		
		JLabel lblYear = new JLabel("\u00C5rgang");
		lblYear.setForeground(SystemColor.activeCaption);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(150, 330, 158, 16);
		panelInfo.add(lblYear);
		
		JSeparator separatorYear = new JSeparator();
		separatorYear.setBounds(150, 400, 169, 2);
		panelInfo.add(separatorYear);
		
		JLabel lblColor = new JLabel("Farve");
		lblColor.setForeground(SystemColor.activeCaption);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblColor.setBounds(452, 60, 158, 16);
		panelInfo.add(lblColor);
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setForeground(Color.WHITE);
		textFieldColor.setColumns(10);
		textFieldColor.setCaretColor(Color.WHITE);
		textFieldColor.setBorder(null);
		textFieldColor.setBackground(Color.DARK_GRAY);
		textFieldColor.setBounds(452, 90, 169, 22);
		panelInfo.add(textFieldColor);
		
		JSeparator separatorWagonType = new JSeparator();
		separatorWagonType.setBounds(452, 120, 169, 2);
		panelInfo.add(separatorWagonType);
		
		JLabel lblKM = new JLabel("Kilometerafstand");
		lblKM.setForeground(SystemColor.activeCaption);
		lblKM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKM.setBounds(452, 151, 158, 16);
		panelInfo.add(lblKM);
		
		textFieldKm = new JTextField();
		textFieldKm.setEditable(false);
		textFieldKm.setForeground(Color.WHITE);
		textFieldKm.setColumns(10);
		textFieldKm.setCaretColor(Color.WHITE);
		textFieldKm.setBorder(null);
		textFieldKm.setBackground(Color.DARK_GRAY);
		textFieldKm.setBounds(452, 175, 169, 22);
		panelInfo.add(textFieldKm);
		
		JSeparator separatorKm = new JSeparator();
		separatorKm.setBounds(452, 210, 169, 2);
		panelInfo.add(separatorKm);
		
		JButton btnNext = new JButton("Videre");
		btnNext.setFocusable(false);
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToBookingServices();
			}
		});
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNext.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNext.setForeground(SystemColor.activeCaption);
		btnNext.setIcon(new ImageIcon(BookingCarInfo.class.getResource("/Images/icons8_Right_32px_1.png")));
		btnNext.setContentAreaFilled(false);
		btnNext.setBounds(557, 543, 140, 25);
		panelInfo.add(btnNext);
		
		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setForeground(Color.WHITE);
		textFieldYear.setColumns(10);
		textFieldYear.setCaretColor(Color.WHITE);
		textFieldYear.setBorder(null);
		textFieldYear.setBackground(Color.DARK_GRAY);
		textFieldYear.setBounds(150, 372, 169, 22);
		panelInfo.add(textFieldYear);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setEditable(false);
		textFieldBrand.setForeground(Color.WHITE);
		textFieldBrand.setColumns(10);
		textFieldBrand.setCaretColor(Color.WHITE);
		textFieldBrand.setBorder(null);
		textFieldBrand.setBackground(Color.DARK_GRAY);
		textFieldBrand.setBounds(150, 179, 169, 22);
		panelInfo.add(textFieldBrand);

		setBookingCarInfo();
	}
	
	private void jumpToBookingServices() {					// skifter side til Contact (Kontakt)
		super.getParent();
		//CardLayout cl = (CardLayout) (((Container) AppointmentPanel.panelService).getLayout()); //giver sig selv nullpointer
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); //NullPointer ved 209
		cl.show(getParent(), "service");
	}
	
	public static void setBookingCarInfo() 
	{ 	
	
		textFieldRegNo.setText(Main.car.getRegNo());
		textFieldBrand.setText(Main.car.getBrand());
		textFieldModel.setText(Main.car.getModel());
		textFieldColor.setText(Main.car.getColor());
		textFieldKm.setText(Integer.toString(Main.car.getKm()));
		textFieldYear.setText(Integer.toString(Main.car.getYear()));
		
	}
	
}
