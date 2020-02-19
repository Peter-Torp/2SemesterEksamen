package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;

import controller.EmployeeController;
import database.DataAccessException;

public class Contact extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6393197637512634194L;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldAalborg;
	private JTextField textFieldMainNumber;

	private EmployeeController empCon;

	private JPanel panelContact;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Contact() {
		setup(); // Not auto generated code.

		setLayout(null);

		panelContact = new JPanel();
		panelContact.setBackground(Color.DARK_GRAY);
		panelContact.setBounds(0, 0, 823, 670);
		add(panelContact);
		panelContact.setLayout(null);

		JLabel lblContact = new JLabel("Kontakt");
		lblContact.setForeground(Color.WHITE);
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContact.setBounds(368, 0, 165, 29);
		panelContact.add(lblContact);

		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(477, 15, 319, 9);
		panelContact.add(separatorTopRight);

		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 15, 319, 9);
		panelContact.add(separatorTopLeft);

		JLabel lblMySalesman = new JLabel("Min S\u00E6lger");
		lblMySalesman.setForeground(SystemColor.activeCaption);
		lblMySalesman.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMySalesman.setBounds(85, 30, 165, 29);
		panelContact.add(lblMySalesman);

		JLabel lblName = new JLabel("Navn");
		lblName.setForeground(SystemColor.activeCaption);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(12, 70, 158, 16);
		panelContact.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setEditable(false);
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setColumns(10);
		textFieldName.setCaretColor(Color.WHITE);
		textFieldName.setBorder(null);
		textFieldName.setBackground(Color.DARK_GRAY);
		textFieldName.setBounds(12, 100, 169, 22);
		panelContact.add(textFieldName);

		JSeparator separatorName = new JSeparator();
		separatorName.setBounds(12, 130, 169, 2);
		panelContact.add(separatorName);

		JLabel lblPhone = new JLabel("Telefon");
		lblPhone.setForeground(SystemColor.activeCaption);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(12, 160, 158, 16);
		panelContact.add(lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhone.setEditable(false);
		textFieldPhone.setForeground(Color.WHITE);
		textFieldPhone.setColumns(10);
		textFieldPhone.setCaretColor(Color.WHITE);
		textFieldPhone.setBorder(null);
		textFieldPhone.setBackground(Color.DARK_GRAY);
		textFieldPhone.setBounds(12, 190, 169, 22);
		panelContact.add(textFieldPhone);

		JSeparator separatorPhone = new JSeparator();
		separatorPhone.setBounds(12, 220, 169, 2);
		panelContact.add(separatorPhone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.activeCaption);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(12, 250, 158, 16);
		panelContact.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setEditable(false);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(Color.DARK_GRAY);
		textFieldEmail.setBounds(12, 280, 169, 22);
		panelContact.add(textFieldEmail);

		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBounds(12, 310, 169, 2);
		panelContact.add(separatorEmail);

		JLabel lblMechanicWorkshop = new JLabel("V\u00E6rksted");
		lblMechanicWorkshop.setForeground(SystemColor.activeCaption);
		lblMechanicWorkshop.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMechanicWorkshop.setBounds(331, 186, 165, 29);
		panelContact.add(lblMechanicWorkshop);

		JLabel lblAalborgOpel = new JLabel("Aalborg Opel");
		lblAalborgOpel.setForeground(SystemColor.activeCaption);
		lblAalborgOpel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAalborgOpel.setBounds(331, 240, 158, 16);
		panelContact.add(lblAalborgOpel);

		textFieldAalborg = new JTextField();
		textFieldAalborg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAalborg.setForeground(Color.WHITE);
		textFieldAalborg.setEditable(false);
		textFieldAalborg.setColumns(10);
		textFieldAalborg.setCaretColor(Color.WHITE);
		textFieldAalborg.setBorder(null);
		textFieldAalborg.setBackground(Color.DARK_GRAY);
		textFieldAalborg.setBounds(331, 270, 169, 22);
		panelContact.add(textFieldAalborg);
		textFieldAalborg.setText("72 25 04 53");

		JSeparator separatorAalborg = new JSeparator();
		separatorAalborg.setBounds(331, 300, 169, 2);
		panelContact.add(separatorAalborg);

		JLabel lblMainNumber = new JLabel("Hovednummer");
		lblMainNumber.setForeground(SystemColor.activeCaption);
		lblMainNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainNumber.setBounds(331, 70, 158, 16);
		panelContact.add(lblMainNumber);

		textFieldMainNumber = new JTextField();
		textFieldMainNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMainNumber.setForeground(Color.WHITE);
		textFieldMainNumber.setEditable(false);
		textFieldMainNumber.setColumns(10);
		textFieldMainNumber.setCaretColor(Color.WHITE);
		textFieldMainNumber.setBorder(null);
		textFieldMainNumber.setBackground(Color.DARK_GRAY);
		textFieldMainNumber.setBounds(331, 100, 365, 22);
		panelContact.add(textFieldMainNumber);
		textFieldMainNumber.setText("96 33 32 22");

		JSeparator separatorMainNumber = new JSeparator();
		separatorMainNumber.setBounds(331, 130, 365, 2);
		panelContact.add(separatorMainNumber);
		
		JLabel lblAalborgKia = new JLabel("Aalborg Kia");
		lblAalborgKia.setForeground(SystemColor.activeCaption);
		lblAalborgKia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAalborgKia.setBounds(331, 328, 158, 16);
		panelContact.add(lblAalborgKia);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText("72 25 04 55");
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(331, 358, 169, 22);
		panelContact.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(331, 388, 169, 2);
		panelContact.add(separator);

		setEmpInfo(); // Not auto generated code.

	}

	/**
	 * To setup controllers etc.
	 */
	private void setup() {
		try {
			empCon = new EmployeeController();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Set the info for the employee.
	 */
	private void setEmpInfo() {
		Main.employee = empCon.findEmployeeByEmpID(Main.car.getEmp_Id());
		textFieldName.setText(Main.employee.getFirstName() + " " + Main.employee.getLastName());
		textFieldPhone.setText(Main.employee.getPhoneNo());
		textFieldEmail.setText(Main.employee.getEmail());
	}
}
