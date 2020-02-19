package gui;

import javax.swing.JPanel;

import database.DataAccessException;

import java.awt.Color;
import java.awt.CardLayout;

public class DiaryPanel extends JPanel {

	

	private JPanel parentPanel;
	private DiaryReport diaryReport;
	private Diary diary;
	
	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public DiaryPanel() throws DataAccessException {
		setLayout(new CardLayout(0, 0));

		parentPanel = new JPanel(new CardLayout());
		parentPanel.setBackground(Color.DARK_GRAY);
		add(parentPanel, "parentPanelDia");
		parentPanel.setLayout(new CardLayout(0, 0));
		
		diary = new Diary();
		parentPanel.add(diary, "diary");
		
		diaryReport = new DiaryReport();
		parentPanel.add(diaryReport, "diaryreport");
	}
	
}
