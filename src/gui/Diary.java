package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.AppointmentController;
import controller.CarController;
import database.DataAccessException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;


public class Diary extends JPanel {

	private DiaryTable diaryTable;
	private CarTable carTable;
	
	/**
	 * 
	 */

	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public Diary() throws DataAccessException  {
		setLayout(new CardLayout(0, 0));
		
		JPanel panelDiary = new JPanel(new CardLayout());
		panelDiary.setBackground(Color.DARK_GRAY);
		add(panelDiary, "name_2511302589058900");
		panelDiary.setLayout(null);
		
		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 13, 296, 11);
		panelDiary.add(separatorTopLeft);
		
		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(455, 13, 296, 11);
		panelDiary.add(separatorTopRight);
		
		JLabel lblDiary = new JLabel("Dagbog");
		lblDiary.setForeground(Color.WHITE);
		lblDiary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiary.setBounds(348, 0, 78, 29);
		panelDiary.add(lblDiary);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setForeground(SystemColor.activeCaption);
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setBounds(22, 37, 583, 465);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);
		panelDiary.add(scrollPane);
		

		diaryTable = new DiaryTable() {

			public boolean isCellEditable(int row, int column) { // Cant double click to edit in table but single click
																	// to select
				return false;
			}
		};
		
		diaryTable.setSelectionBackground(SystemColor.activeCaption);
		diaryTable.setGridColor(Color.WHITE);
		diaryTable.setForeground(SystemColor.activeCaption);
		diaryTable.setBackground(Color.DARK_GRAY);
		diaryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(diaryTable);
		
		JButton btnShowReport = new JButton("Vis Rapport");
		btnShowReport.setIcon(new ImageIcon(Diary.class.getResource("/Images/icons8_Report_Card_32px.png")));
		btnShowReport.setFocusable(false);
		btnShowReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpToDiaryPanel();
				//fetchTableRowInfo();
			}
		});
		btnShowReport.setHorizontalTextPosition(SwingConstants.LEFT);
		btnShowReport.setForeground(SystemColor.activeCaption);
		btnShowReport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShowReport.setContentAreaFilled(false);
		btnShowReport.setAlignmentX(1.0f);
		btnShowReport.setBounds(628, 461, 168, 41);
		panelDiary.add(btnShowReport);
		
		updateTable();
	}
		private void jumpToDiaryPanel() {					// skifter side til Contact (Kontakt)
		super.getParent();
		//CardLayout cl = (CardLayout) (((Container) AppointmentPanel.panelService).getLayout()); //giver sig selv nullpointer
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); //NullPointer ved 209
		cl.show(getParent(), "diaryreport");
	}
		
		public void updateTable()  {
			if (Main.car.getRegNo() != null) {
				try {
					diaryTable.doUpdate(Main.car);
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Kan jeg kommer jeg ind? det her");
			}

		}
		

}

