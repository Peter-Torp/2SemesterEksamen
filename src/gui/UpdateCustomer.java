package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5324891455136766032L;
	private JTextField textFieldName;
	private JTextField textFieldDOB;
	private JTextField textFieldCity;
	private JTextField textFieldZipcode;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JPasswordField passwordField;
	private JTextField textFieldLastName;
	private JTextField textFieldEnterPhone;

	/**
	 * Create the panel.
	 */
	public UpdateCustomer() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.WHITE);
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, "name_1903393282890500");
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("Fornavn");
		lblFirstName.setForeground(SystemColor.activeCaption);
		lblFirstName.setBounds(12, 140, 65, 20);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDoB = new JLabel("F\u00F8dselsdag");
		lblDoB.setForeground(SystemColor.activeCaption);
		lblDoB.setBounds(12, 320, 110, 20);
		panel.add(lblDoB);
		lblDoB.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCity = new JLabel("By");
		lblCity.setForeground(SystemColor.activeCaption);
		lblCity.setBounds(12, 410, 42, 20);
		panel.add(lblCity);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblAddress = new JLabel("Adresse");
		lblAddress.setForeground(SystemColor.activeCaption);
		lblAddress.setBounds(230, 320, 77, 20);
		panel.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblZipcode = new JLabel("Post#");
		lblZipcode.setForeground(SystemColor.activeCaption);
		lblZipcode.setBounds(12, 500, 65, 20);
		panel.add(lblZipcode);
		lblZipcode.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.activeCaption);
		lblEmail.setBounds(230, 410, 65, 20);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPhone = new JLabel("Telefon");
		lblPhone.setForeground(SystemColor.activeCaption);
		lblPhone.setBounds(230, 500, 53, 20);
		panel.add(lblPhone);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPassword = new JLabel("Adgangskode");
		lblPassword.setForeground(SystemColor.activeCaption);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(230, 230, 121, 16);
		panel.add(lblPassword);
		
		JSeparator separatorName = new JSeparator();
		separatorName.setBounds(12, 200, 169, 2);
		panel.add(separatorName);
		
		textFieldName = new JTextField();
		textFieldName.setEditable(false);
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setCaretColor(Color.WHITE);
		textFieldName.setBackground(Color.DARK_GRAY);
		textFieldName.setBorder(null);
		textFieldName.setBounds(12, 170, 169, 22);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblUpdateCustomer = new JLabel("Opdater Kunde");
		lblUpdateCustomer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdateCustomer.setForeground(Color.WHITE);
		lblUpdateCustomer.setBounds(12, 11, 146, 16);
		panel.add(lblUpdateCustomer);
		
		textFieldDOB = new JTextField();
		textFieldDOB.setEditable(false);
		textFieldDOB.setForeground(Color.WHITE);
		textFieldDOB.setCaretColor(Color.WHITE);
		textFieldDOB.setColumns(10);
		textFieldDOB.setBorder(null);
		textFieldDOB.setBackground(Color.DARK_GRAY);
		textFieldDOB.setBounds(12, 350, 169, 22);
		panel.add(textFieldDOB);
		
		JSeparator separatorDOB = new JSeparator();
		separatorDOB.setBounds(12, 380, 169, 2);
		panel.add(separatorDOB);
		
		textFieldCity = new JTextField();
		textFieldCity.setEditable(false);
		textFieldCity.setForeground(Color.WHITE);
		textFieldCity.setCaretColor(Color.WHITE);
		textFieldCity.setColumns(10);
		textFieldCity.setBorder(null);
		textFieldCity.setBackground(Color.DARK_GRAY);
		textFieldCity.setBounds(12, 440, 169, 22);
		panel.add(textFieldCity);
		
		JSeparator separatorCity = new JSeparator();
		separatorCity.setBounds(12, 470, 169, 2);
		panel.add(separatorCity);
		
		textFieldZipcode = new JTextField();
		textFieldZipcode.setEditable(false);
		textFieldZipcode.setForeground(Color.WHITE);
		textFieldZipcode.setCaretColor(Color.WHITE);
		textFieldZipcode.setColumns(10);
		textFieldZipcode.setBorder(null);
		textFieldZipcode.setBackground(Color.DARK_GRAY);
		textFieldZipcode.setBounds(12, 530, 169, 22);
		panel.add(textFieldZipcode);
		
		JSeparator separatorZipcode = new JSeparator();
		separatorZipcode.setBounds(12, 560, 169, 2);
		panel.add(separatorZipcode);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setEditable(false);
		textFieldAddress.setForeground(Color.WHITE);
		textFieldAddress.setCaretColor(Color.WHITE);
		textFieldAddress.setColumns(10);
		textFieldAddress.setBorder(null);
		textFieldAddress.setBackground(Color.DARK_GRAY);
		textFieldAddress.setBounds(230, 350, 169, 22);
		panel.add(textFieldAddress);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(Color.DARK_GRAY);
		textFieldEmail.setBounds(230, 440, 169, 22);
		panel.add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setEditable(false);
		textFieldPhone.setForeground(Color.WHITE);
		textFieldPhone.setCaretColor(Color.WHITE);
		textFieldPhone.setColumns(10);
		textFieldPhone.setBorder(null);
		textFieldPhone.setBackground(Color.DARK_GRAY);
		textFieldPhone.setBounds(230, 530, 169, 22);
		panel.add(textFieldPhone);
		
		JSeparator separatorPhone = new JSeparator();
		separatorPhone.setBounds(230, 560, 169, 2);
		panel.add(separatorPhone);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBounds(230, 470, 169, 2);
		panel.add(separatorEmail);
		
		JSeparator separatorAddress = new JSeparator();
		separatorAddress.setBounds(230, 380, 169, 2);
		panel.add(separatorAddress);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBounds(230, 290, 169, 2);
		panel.add(separatorPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBounds(230, 260, 169, 22);
		panel.add(passwordField);
		
		JButton btnUpdate = new JButton("Opdater");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setForeground(SystemColor.activeCaption);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(298, 594, 97, 25);
		panel.add(btnUpdate);
		
		JButton btnCancel = new JButton("Annullere");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearText();
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setForeground(SystemColor.activeCaption);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(84, 594, 97, 25);
		panel.add(btnCancel);
		
		JSeparator separatorLastName = new JSeparator();
		separatorLastName.setBounds(12, 290, 169, 2);
		panel.add(separatorLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setEditable(false);
		textFieldLastName.setForeground(Color.WHITE);
		textFieldLastName.setColumns(10);
		textFieldLastName.setCaretColor(Color.WHITE);
		textFieldLastName.setBorder(null);
		textFieldLastName.setBackground(Color.DARK_GRAY);
		textFieldLastName.setBounds(12, 260, 169, 22);
		panel.add(textFieldLastName);
		
		JLabel labelLastName = new JLabel("Efternavn");
		labelLastName.setForeground(SystemColor.activeCaption);
		labelLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLastName.setBounds(12, 230, 77, 20);
		panel.add(labelLastName);
		
		JSeparator separatorAboveName = new JSeparator();
		separatorAboveName.setBounds(12, 110, 169, 2);
		panel.add(separatorAboveName);
		
		JSeparator separatorAbovePW = new JSeparator();
		separatorAbovePW.setBounds(230, 200, 169, 2);
		panel.add(separatorAbovePW);
		
		JLabel labelEnterPhone = new JLabel("Indtast Telefon Nr");
		labelEnterPhone.setForeground(SystemColor.activeCaption);
		labelEnterPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEnterPhone.setBounds(12, 50, 169, 20);
		panel.add(labelEnterPhone);
		
		textFieldEnterPhone = new JTextField();
		textFieldEnterPhone.setForeground(Color.WHITE);
		textFieldEnterPhone.setColumns(10);
		textFieldEnterPhone.setCaretColor(Color.WHITE);
		textFieldEnterPhone.setBorder(null);
		textFieldEnterPhone.setBackground(Color.DARK_GRAY);
		textFieldEnterPhone.setBounds(12, 80, 169, 22);
		panel.add(textFieldEnterPhone);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(169, 110, 169, 2);
		panel.add(separator);
		
		JButton btnSearchCustomer = new JButton("Find Kunde");
		btnSearchCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchCustomer.setForeground(SystemColor.activeCaption);
		btnSearchCustomer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchCustomer.setContentAreaFilled(false);
		btnSearchCustomer.setBounds(230, 79, 108, 25);
		panel.add(btnSearchCustomer);

	}
	
	private void ClearText() {
		textFieldEnterPhone.setText(null);
	}
}
