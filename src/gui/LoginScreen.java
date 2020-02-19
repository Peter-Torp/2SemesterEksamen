package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.EmployeeController;
import database.DataAccessException;
import module.Person;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.Cursor;

public class LoginScreen extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldUsername;
	
	private EmployeeController empCon;
	private CustomerController cusCon;
	
	private static LoginScreen frame;
	
	int xx, xy; // used below for moving the pane around

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginScreen();
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
	public LoginScreen() {
		setup();
		
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.DARK_GRAY);
		panelLeft.setBounds(0, 0, 482, 403);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX(); // makes uggerhøj picture dragable
			     xy = e.getY(); // makes uggerhøj picture dragable
			     
			}
		});
		lblPicture.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen(); // makes uggerhøj picture dragable
	            int y = arg0.getYOnScreen(); // makes uggerhøj picture dragable
	            LoginScreen.this.setLocation(x - xx, y - xy);  // makes uggerhøj picture dragable
				
			}
		});
		lblPicture.setIcon(new ImageIcon(LoginScreen.class.getResource("/Images/Facade_Aalborg175Capa.jpg")));
		lblPicture.setBounds(0, 0, 566, 403);
		panelLeft.add(lblPicture);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(51, 51, 51));
		panelRight.setBounds(482, 0, 350, 403);
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setForeground(SystemColor.activeCaption);
		lblUsername.setBounds(12, 66, 105, 24);
		panelRight.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setForeground(SystemColor.activeCaption);
		lblPassword.setBounds(12, 195, 90, 16);
		panelRight.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFocusable(false);
		btnLogin.setFocusTraversalKeysEnabled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setForeground(SystemColor.activeCaption);
		btnLogin.setBackground(new Color(51, 51, 51));
		btnLogin.setBounds(107, 324, 140, 35);
		panelRight.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		JSeparator separatorUsername = new JSeparator();
		separatorUsername.setBackground(Color.WHITE);
		separatorUsername.setForeground(Color.WHITE);
		separatorUsername.setBounds(12, 144, 326, 2);
		panelRight.add(separatorUsername);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBackground(Color.WHITE);
		separatorPassword.setForeground(Color.WHITE);
		separatorPassword.setBounds(12, 262, 326, 2);
		panelRight.add(separatorPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				pressEnterForLogin(e);
			}
		});
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBorder(null);
		passwordField.setToolTipText("");
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(51, 51, 51));
		passwordField.setBounds(12, 224, 326, 30);
		panelRight.add(passwordField);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setCaretColor(Color.WHITE);
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUsername.setBorder(null);
		textFieldUsername.setForeground(Color.WHITE);
		textFieldUsername.setBackground(new Color(51, 51, 51));
		textFieldUsername.setBounds(12, 103, 326, 30);
		panelRight.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnX = new JButton("");
		btnX.setIcon(new ImageIcon(LoginScreen.class.getResource("/Images/icons8_Exit_32px.png")));
		btnX.setFocusable(false);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setForeground(SystemColor.activeCaption);
		btnX.setContentAreaFilled(false);
		btnX.setBackground(new Color(51, 51, 51));
		btnX.setBorder(null);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX.setBounds(253, 13, 97, 25);
		panelRight.add(btnX);
	}
	
	private void setup() {
		try {
			empCon = new EmployeeController();
			cusCon = new CustomerController();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void login() {
		System.out.println("Login start");
		String username = textFieldUsername.getText();
		String password = passwordField.getText();
		
		if(password != null && username != null) {
			Person person = null;
			try {
				person = cusCon.findPersonByEmail(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(person.getPassword().equals(password)) {
				//Login successful
				Main main = new Main();
				main.main(null, person);
				frame.dispose();
			} else {
				System.out.println("Password do not match");
				wrongLoginCredentials();
			}
		} else {
			System.out.println("Incorrect input");
			fillInLoginCredentials();
		}
	}
	
	private void pressEnterForLogin(java.awt.event.KeyEvent evt)
	{
		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
			login();
		}
	}
	
	private void fillInLoginCredentials()
	{
		
		
		JOptionPane.showMessageDialog(rootPane, "Udfyld Email og Password feltet", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void wrongLoginCredentials()
	{
	
		JOptionPane.showMessageDialog(rootPane, "Forkert Email eller Password, prøv igen", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
