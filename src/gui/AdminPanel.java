package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;

public class AdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6519715303247157794L;
	private JPanel parentPanel;
	private CreateCustomer createCustomer;
	private SearchCustomer searchCustomer;
	private UpdateCustomer updateCustomer;
	private DeleteCustomer deleteCustomer;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		setLayout(new CardLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(SystemColor.controlDkShadow);
		add(panelLeft, "name_1904166958888100");
		panelLeft.setLayout(null);
		
		JButton btnCreateUser = new JButton("Opret");
		btnCreateUser.setForeground(SystemColor.activeCaption);
		btnCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpToCreateCustomer();
			}
		});
		btnCreateUser.setIcon(new ImageIcon(AdminPanel.class.getResource("/Images/icons8_Add_User_Male_32px.png")));
		btnCreateUser.setContentAreaFilled(false);
		btnCreateUser.setBorder(null);
		btnCreateUser.setBounds(0, 69, 129, 30);
		panelLeft.add(btnCreateUser);
		
		JButton btnSearch = new JButton("S\u00F8g");
		btnSearch.setForeground(SystemColor.activeCaption);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToSearchCustomer();
			}
		});
		btnSearch.setIcon(new ImageIcon(AdminPanel.class.getResource("/Images/icons8_Search_32px.png")));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		btnSearch.setBounds(0, 130, 129, 30);
		panelLeft.add(btnSearch);
		
		JButton btnUpdate = new JButton("Opdater");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setForeground(SystemColor.activeCaption);
		btnUpdate.setIcon(new ImageIcon(AdminPanel.class.getResource("/Images/icons8_Update_User_32px.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToUpdateCustomer();
			}
		});
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(0, 193, 129, 30);
		panelLeft.add(btnUpdate);
		
		JButton btnSlet = new JButton("Slet");
		btnSlet.setForeground(SystemColor.activeCaption);
		btnSlet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToDeleteCustomer();
			}
		});
		btnSlet.setIcon(new ImageIcon(AdminPanel.class.getResource("/Images/icons8_Denied_32px.png")));
		btnSlet.setContentAreaFilled(false);
		btnSlet.setBorder(null);
		btnSlet.setBounds(0, 253, 129, 30);
		panelLeft.add(btnSlet);
		
		parentPanel = new JPanel (new CardLayout());
		parentPanel.setBounds(141, 0, 733, 679);
		panelLeft.add(parentPanel);
		parentPanel.setBackground(Color.DARK_GRAY);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		createCustomer = new CreateCustomer();
		parentPanel.add(createCustomer, "createCustomer");
		
		searchCustomer = new SearchCustomer();
		parentPanel.add(searchCustomer, "searchCustomer");
		
		updateCustomer = new UpdateCustomer();
		parentPanel.add(updateCustomer, "updateCustomer");
		
		deleteCustomer = new DeleteCustomer();
		parentPanel.add(deleteCustomer, "deleteCustomer");
	}
	
	private void jumpToCreateCustomer() { 				// skifter side til Frontpage (Forside)
		 CardLayout cl = (CardLayout)(parentPanel.getLayout());		// Vi henter vores CardLayout
		cl.show(parentPanel, "createCustomer");			// Vi siger den skal vise vores parentPanel hvor der er et kort der hedder frontpage
	}
	
	private void jumpToSearchCustomer() { 				// skifter side til Frontpage (Forside)
		 CardLayout cl = (CardLayout)(parentPanel.getLayout());		// Vi henter vores CardLayout
		cl.show(parentPanel, "searchCustomer");			// Vi siger den skal vise vores parentPanel hvor der er et kort der hedder frontpage
	}
	
	private void jumpToUpdateCustomer() { 				// skifter side til Frontpage (Forside)
		 CardLayout cl = (CardLayout)(parentPanel.getLayout());		// Vi henter vores CardLayout
		cl.show(parentPanel, "updateCustomer");			// Vi siger den skal vise vores parentPanel hvor der er et kort der hedder frontpage
	}
	
	private void jumpToDeleteCustomer() { 				// skifter side til Frontpage (Forside)
		 CardLayout cl = (CardLayout)(parentPanel.getLayout());		// Vi henter vores CardLayout
		cl.show(parentPanel, "deleteCustomer");			// Vi siger den skal vise vores parentPanel hvor der er et kort der hedder frontpage
	}
}
