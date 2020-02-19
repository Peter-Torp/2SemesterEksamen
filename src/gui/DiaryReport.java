package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiaryReport extends JPanel {
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private JPanel panelDiaryReport;
	private JTextField textFieldKm;
	private JTextField textFieldPrice;
	private JTextField textFieldBrand;
	private JTextField textFieldModel;
	private JTextField textFieldRegNo;
	private JTextField textFieldYear;
	private JTextField textFieldServiceType;
	private JTextField textFieldServiceDate;
	private JTextField textFieldEndTime;

	/**
	 * Create the panel.
	 */
	public DiaryReport() {
		setLayout(new CardLayout(0, 0));

		panelDiaryReport = new JPanel();
		panelDiaryReport.setBackground(Color.DARK_GRAY);
		add(panelDiaryReport, "name_854021927745700");
		panelDiaryReport.setLayout(null);

		JLabel lblServiceOverview = new JLabel("Service Oversigt");
		lblServiceOverview.setForeground(Color.WHITE);
		lblServiceOverview.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServiceOverview.setBounds(332, 0, 165, 29);
		panelDiaryReport.add(lblServiceOverview);

		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(477, 15, 319, 9);
		panelDiaryReport.add(separatorTopRight);

		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 15, 319, 9);
		panelDiaryReport.add(separatorTopLeft);

		JLabel lblServiceReport = new JLabel("Synsdetaljer");
		lblServiceReport.setForeground(SystemColor.activeCaption);
		lblServiceReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServiceReport.setBounds(76, 37, 165, 29);
		panelDiaryReport.add(lblServiceReport);

		JLabel lblServiceType = new JLabel("Synstype");
		lblServiceType.setForeground(SystemColor.activeCaption);
		lblServiceType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServiceType.setBounds(76, 77, 158, 16);
		panelDiaryReport.add(lblServiceType);

		textFieldServiceType = new JTextField();
		textFieldServiceType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldServiceType.setEditable(false);
		textFieldServiceType.setForeground(Color.WHITE);
		textFieldServiceType.setColumns(10);
		textFieldServiceType.setCaretColor(Color.WHITE);
		textFieldServiceType.setBorder(null);
		textFieldServiceType.setBackground(Color.DARK_GRAY);
		textFieldServiceType.setBounds(76, 102, 169, 22);
		panelDiaryReport.add(textFieldServiceType);

		JSeparator separatorServiceType = new JSeparator();
		separatorServiceType.setBounds(76, 131, 169, 2);
		panelDiaryReport.add(separatorServiceType);

		JLabel lblServiceDate = new JLabel("Synsdato");
		lblServiceDate.setForeground(SystemColor.activeCaption);
		lblServiceDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServiceDate.setBounds(76, 161, 158, 16);
		panelDiaryReport.add(lblServiceDate);

		textFieldServiceDate = new JTextField();
		textFieldServiceDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldServiceDate.setEditable(false);
		textFieldServiceDate.setForeground(Color.WHITE);
		textFieldServiceDate.setColumns(10);
		textFieldServiceDate.setCaretColor(Color.WHITE);
		textFieldServiceDate.setBorder(null);
		textFieldServiceDate.setBackground(Color.DARK_GRAY);
		textFieldServiceDate.setBounds(76, 191, 169, 22);
		panelDiaryReport.add(textFieldServiceDate);

		JSeparator separatorServiceDate = new JSeparator();
		separatorServiceDate.setBounds(76, 221, 169, 2);
		panelDiaryReport.add(separatorServiceDate);

		JLabel lblEndTime = new JLabel("Sluttid");
		lblEndTime.setForeground(SystemColor.activeCaption);
		lblEndTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndTime.setBounds(76, 251, 158, 16);
		panelDiaryReport.add(lblEndTime);

		textFieldEndTime = new JTextField();
		textFieldEndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEndTime.setEditable(false);
		textFieldEndTime.setForeground(Color.WHITE);
		textFieldEndTime.setColumns(10);
		textFieldEndTime.setCaretColor(Color.WHITE);
		textFieldEndTime.setBorder(null);
		textFieldEndTime.setBackground(Color.DARK_GRAY);
		textFieldEndTime.setBounds(76, 281, 169, 22);
		panelDiaryReport.add(textFieldEndTime);

		JSeparator separatorEndtime = new JSeparator();
		separatorEndtime.setBounds(76, 311, 169, 2);
		panelDiaryReport.add(separatorEndtime);
		
		JLabel lblKm = new JLabel("Km-Stand");
		lblKm.setForeground(SystemColor.activeCaption);
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKm.setBounds(76, 339, 158, 16);
		panelDiaryReport.add(lblKm);
		
		textFieldKm = new JTextField();
		textFieldKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldKm.setText((String) null);
		textFieldKm.setForeground(Color.WHITE);
		textFieldKm.setEditable(false);
		textFieldKm.setColumns(10);
		textFieldKm.setCaretColor(Color.WHITE);
		textFieldKm.setBorder(null);
		textFieldKm.setBackground(Color.DARK_GRAY);
		textFieldKm.setBounds(76, 369, 169, 22);
		panelDiaryReport.add(textFieldKm);
		
		JSeparator separatorKm = new JSeparator();
		separatorKm.setBounds(76, 399, 169, 2);
		panelDiaryReport.add(separatorKm);
		
		JLabel lblCar = new JLabel("K\u00F8ret\u00F8j");
		lblCar.setForeground(SystemColor.activeCaption);
		lblCar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCar.setBounds(477, 30, 165, 29);
		panelDiaryReport.add(lblCar);
		
		JLabel lblPrice = new JLabel("Pris");
		lblPrice.setForeground(SystemColor.activeCaption);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(76, 435, 158, 16);
		panelDiaryReport.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrice.setText((String) null);
		textFieldPrice.setForeground(Color.WHITE);
		textFieldPrice.setEditable(false);
		textFieldPrice.setColumns(10);
		textFieldPrice.setCaretColor(Color.WHITE);
		textFieldPrice.setBorder(null);
		textFieldPrice.setBackground(Color.DARK_GRAY);
		textFieldPrice.setBounds(76, 465, 169, 22);
		panelDiaryReport.add(textFieldPrice);
		
		JSeparator separatorPrice = new JSeparator();
		separatorPrice.setBounds(76, 495, 169, 2);
		panelDiaryReport.add(separatorPrice);
		
		JLabel lblBrand = new JLabel("M\u00E6rke");
		lblBrand.setForeground(SystemColor.activeCaption);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrand.setBounds(466, 70, 158, 16);
		panelDiaryReport.add(lblBrand);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBrand.setForeground(Color.WHITE);
		textFieldBrand.setEditable(false);
		textFieldBrand.setColumns(10);
		textFieldBrand.setCaretColor(Color.WHITE);
		textFieldBrand.setBorder(null);
		textFieldBrand.setBackground(Color.DARK_GRAY);
		textFieldBrand.setBounds(466, 100, 169, 22);
		panelDiaryReport.add(textFieldBrand);
		
		JSeparator separatorBrand = new JSeparator();
		separatorBrand.setBounds(466, 130, 169, 2);
		panelDiaryReport.add(separatorBrand);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setForeground(SystemColor.activeCaption);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModel.setBounds(466, 160, 158, 16);
		panelDiaryReport.add(lblModel);
		
		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldModel.setText((String) null);
		textFieldModel.setForeground(Color.WHITE);
		textFieldModel.setEditable(false);
		textFieldModel.setColumns(10);
		textFieldModel.setCaretColor(Color.WHITE);
		textFieldModel.setBorder(null);
		textFieldModel.setBackground(Color.DARK_GRAY);
		textFieldModel.setBounds(466, 190, 169, 22);
		panelDiaryReport.add(textFieldModel);
		
		JSeparator separatorModel = new JSeparator();
		separatorModel.setBounds(466, 220, 169, 2);
		panelDiaryReport.add(separatorModel);
		
		JLabel lblRegNo = new JLabel("Registreringsnummer");
		lblRegNo.setForeground(SystemColor.activeCaption);
		lblRegNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegNo.setBounds(466, 250, 158, 16);
		panelDiaryReport.add(lblRegNo);
		
		textFieldRegNo = new JTextField();
		textFieldRegNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldRegNo.setForeground(Color.WHITE);
		textFieldRegNo.setEditable(false);
		textFieldRegNo.setColumns(10);
		textFieldRegNo.setCaretColor(Color.WHITE);
		textFieldRegNo.setBorder(null);
		textFieldRegNo.setBackground(Color.DARK_GRAY);
		textFieldRegNo.setBounds(466, 280, 169, 22);
		panelDiaryReport.add(textFieldRegNo);
		
		JSeparator separatorRegNo = new JSeparator();
		separatorRegNo.setBounds(466, 310, 169, 2);
		panelDiaryReport.add(separatorRegNo);
		
		JLabel lblYear = new JLabel("\u00C5rstal");
		lblYear.setForeground(SystemColor.activeCaption);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(466, 340, 158, 16);
		panelDiaryReport.add(lblYear);
		
		textFieldYear = new JTextField();
		textFieldYear.setText((String) null);
		textFieldYear.setForeground(Color.WHITE);
		textFieldYear.setEditable(false);
		textFieldYear.setColumns(10);
		textFieldYear.setCaretColor(Color.WHITE);
		textFieldYear.setBorder(null);
		textFieldYear.setBackground(Color.DARK_GRAY);
		textFieldYear.setBounds(466, 370, 169, 22);
		panelDiaryReport.add(textFieldYear);
		
		JSeparator separatorYear = new JSeparator();
		separatorYear.setBounds(466, 400, 169, 2);
		panelDiaryReport.add(separatorYear);
		
		JButton btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpBackToDiary();
			}
		});
		btnBack.setIcon(new ImageIcon(DiaryReport.class.getResource("/Images/icons8_Left_32px.png")));
		btnBack.setForeground(SystemColor.activeCaption);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setFocusable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(76, 532, 137, 33);
		panelDiaryReport.add(btnBack);

	}
	
	private void jumpBackToDiary()
	{
		CardLayout cl = (CardLayout) (((getParent()).getLayout()));
		cl.show(getParent(), "diary");
	}
}
