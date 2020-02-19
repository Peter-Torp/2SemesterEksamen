package gui;

import javax.swing.JPanel;
import java.awt.Color;

import java.awt.CardLayout;

public class FrontpagePanel extends JPanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7937406788994097943L;
	private JPanel parentPanel;
	private Frontpage frontpage;
	private FrontpageCar frontpageCar;
	
	/**
	 * Create the panel.
	 */
	public FrontpagePanel() {
		setLayout(new CardLayout(0, 0));

		parentPanel = new JPanel(new CardLayout());
		parentPanel.setBackground(Color.DARK_GRAY);
		add(parentPanel, "parentPanelFront");
		parentPanel.setLayout(new CardLayout(0, 0));
		
		frontpage = new Frontpage();
		parentPanel.add(frontpage, "frontpage");
		
		frontpageCar = new FrontpageCar();
		parentPanel.add(frontpageCar, "frontpagecar");
	}
	
	
	
}
