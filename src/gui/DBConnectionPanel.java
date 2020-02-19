package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;



public class DBConnectionPanel extends JPanel {
	
		protected static JLabel lblRED;
		protected static JLabel lblGREEN;
		
		
	/**
	 * Create the panel.
	 */
	public DBConnectionPanel() {
		setBackground(new Color(51, 51, 51));
		
		lblRED = new JLabel("RED");
		lblRED.setIcon(new ImageIcon(DBConnectionPanel.class.getResource("/Images/icons8_Connected_32px_1.png")));
		add(lblRED);

		
		lblGREEN = new JLabel("Green");
		lblGREEN.setIcon(new ImageIcon(DBConnectionPanel.class.getResource("/Images/icons8_Connected_32px.png")));
		add(lblGREEN);

	
		
	}
	
	public void connected()
	{
		System.out.println("IS CONNECTED");
		lblGREEN.setVisible(true);
		lblRED.setVisible(false);
	}
	
	public void notConnected()
	{
		System.out.println("IS NOT CONNECTED");
		lblGREEN.setVisible(false);
		lblRED.setVisible(true);
	}

}
