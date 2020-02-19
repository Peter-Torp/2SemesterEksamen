package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;

import controller.CarController;
import module.Car;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontpageCar extends JPanel {

	

	/**
	 * 
	 */

	private JPanel panelFrontpageCar;
	private static JTextField textFieldBrand;
	private static JTextField textFieldModel;
	private static JTextField textFieldRegNo;
	private static JTextField textFieldYear;
	private static JTextField textFieldKm;
	private static JTextField textFieldColor;
	
	private CarController carCon;

	/**
	 * Create the panel.
	 */
	public FrontpageCar() {
		setLayout(new CardLayout(0, 0));

		panelFrontpageCar = new JPanel();
		panelFrontpageCar.setBackground(Color.DARK_GRAY);
		add(panelFrontpageCar, "name_852302494019287");
		panelFrontpageCar.setLayout(null);

		JLabel lblCarOverview = new JLabel("Bil Oversigt");
		lblCarOverview.setForeground(Color.WHITE);
		lblCarOverview.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarOverview.setBounds(355, 0, 146, 29);
		panelFrontpageCar.add(lblCarOverview);

		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(477, 15, 319, 9);
		panelFrontpageCar.add(separatorTopRight);

		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(12, 15, 319, 9);
		panelFrontpageCar.add(separatorTopLeft);
		
		JLabel lblBrand = new JLabel("M\u00E6rke");
		lblBrand.setForeground(SystemColor.activeCaption);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrand.setBounds(148, 160, 158, 16);
		panelFrontpageCar.add(lblBrand);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBrand.setForeground(Color.WHITE);
		textFieldBrand.setEditable(false);
		textFieldBrand.setColumns(10);
		textFieldBrand.setCaretColor(Color.WHITE);
		textFieldBrand.setBorder(null);
		textFieldBrand.setBackground(Color.DARK_GRAY);
		textFieldBrand.setBounds(148, 190, 169, 22);
		panelFrontpageCar.add(textFieldBrand);
		
		JSeparator separatorBrand = new JSeparator();
		separatorBrand.setBounds(148, 220, 169, 2);
		panelFrontpageCar.add(separatorBrand);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setForeground(SystemColor.activeCaption);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModel.setBounds(148, 269, 158, 16);
		panelFrontpageCar.add(lblModel);
		
		textFieldModel = new JTextField();
		textFieldModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldModel.setText((String) null);
		textFieldModel.setForeground(Color.WHITE);
		textFieldModel.setEditable(false);
		textFieldModel.setColumns(10);
		textFieldModel.setCaretColor(Color.WHITE);
		textFieldModel.setBorder(null);
		textFieldModel.setBackground(Color.DARK_GRAY);
		textFieldModel.setBounds(148, 299, 169, 22);
		panelFrontpageCar.add(textFieldModel);
		
		JSeparator separatorModel = new JSeparator();
		separatorModel.setBounds(148, 329, 169, 2);
		panelFrontpageCar.add(separatorModel);
		
		JLabel lblRegNo = new JLabel("Registreringsnummer");
		lblRegNo.setForeground(SystemColor.activeCaption);
		lblRegNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegNo.setBounds(148, 70, 158, 16);
		panelFrontpageCar.add(lblRegNo);
		
		textFieldRegNo = new JTextField();
		textFieldRegNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldRegNo.setForeground(Color.WHITE);
		textFieldRegNo.setEditable(false);
		textFieldRegNo.setColumns(10);
		textFieldRegNo.setCaretColor(Color.WHITE);
		textFieldRegNo.setBorder(null);
		textFieldRegNo.setBackground(Color.DARK_GRAY);
		textFieldRegNo.setBounds(148, 100, 169, 22);
		panelFrontpageCar.add(textFieldRegNo);
		
		JSeparator separatorRegNo = new JSeparator();
		separatorRegNo.setBounds(148, 130, 169, 2);
		panelFrontpageCar.add(separatorRegNo);
		
		JLabel lblYear = new JLabel("\u00C5rgang");
		lblYear.setForeground(SystemColor.activeCaption);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(477, 269, 158, 16);
		panelFrontpageCar.add(lblYear);
		
		textFieldYear = new JTextField();
		textFieldYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldYear.setText((String) null);
		textFieldYear.setForeground(Color.WHITE);
		textFieldYear.setEditable(false);
		textFieldYear.setColumns(10);
		textFieldYear.setCaretColor(Color.WHITE);
		textFieldYear.setBorder(null);
		textFieldYear.setBackground(Color.DARK_GRAY);
		textFieldYear.setBounds(477, 299, 169, 22);
		panelFrontpageCar.add(textFieldYear);
		
		JSeparator separatorYear = new JSeparator();
		separatorYear.setBounds(477, 329, 169, 2);
		panelFrontpageCar.add(separatorYear);
		
		JLabel lblKM = new JLabel("Kilometerafstand");
		lblKM.setForeground(SystemColor.activeCaption);
		lblKM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKM.setBounds(477, 70, 158, 16);
		panelFrontpageCar.add(lblKM);
		
		textFieldKm = new JTextField();
		textFieldKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldKm.setForeground(Color.WHITE);
		textFieldKm.setEditable(false);
		textFieldKm.setColumns(10);
		textFieldKm.setCaretColor(Color.WHITE);
		textFieldKm.setBorder(null);
		textFieldKm.setBackground(Color.DARK_GRAY);
		textFieldKm.setBounds(477, 100, 169, 22);
		panelFrontpageCar.add(textFieldKm);
		
		JSeparator separatorKm = new JSeparator();
		separatorKm.setBounds(477, 130, 169, 2);
		panelFrontpageCar.add(separatorKm);
		
		JLabel lblColor = new JLabel("Farve");
		lblColor.setForeground(SystemColor.activeCaption);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblColor.setBounds(477, 160, 158, 16);
		panelFrontpageCar.add(lblColor);
		
		textFieldColor = new JTextField();
		textFieldColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldColor.setForeground(Color.WHITE);
		textFieldColor.setEditable(false);
		textFieldColor.setColumns(10);
		textFieldColor.setCaretColor(Color.WHITE);
		textFieldColor.setBorder(null);
		textFieldColor.setBackground(Color.DARK_GRAY);
		textFieldColor.setBounds(477, 190, 169, 22);
		panelFrontpageCar.add(textFieldColor);
		
		JSeparator separatorColor = new JSeparator();
		separatorColor.setBounds(477, 220, 169, 2);
		panelFrontpageCar.add(separatorColor);
		
		JButton btnChangeCar = new JButton("Skift Bil");
		btnChangeCar.setFocusable(false);
		btnChangeCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpBackToFrontpageChangeCar();
			}
		});
		btnChangeCar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangeCar.setIcon(new ImageIcon(FrontpageCar.class.getResource("/Images/icons8_Car_32px.png")));
		btnChangeCar.setForeground(SystemColor.activeCaption);
		btnChangeCar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChangeCar.setContentAreaFilled(false);
		btnChangeCar.setBounds(46, 506, 137, 33);
		panelFrontpageCar.add(btnChangeCar);
		

	}
	
		public static void getCarInfo(Car car) 
		{ 	
			textFieldRegNo.setText(car.getRegNo());
			textFieldBrand.setText(car.getBrand());
			textFieldModel.setText(car.getModel());
			textFieldKm.setText(Integer.toString(car.getKm()));
			textFieldColor.setText(car.getColor());
			textFieldYear.setText(Integer.toString(car.getYear()));

		}
		
		private void jumpBackToFrontpageChangeCar()
		{
				CardLayout cl = (CardLayout) (((getParent()).getLayout()));
				cl.show(getParent(), "frontpage");
		}
}
