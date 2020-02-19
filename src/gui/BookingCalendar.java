package gui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controller.AppointmentController;
import database.DataAccessException;
import module.Appointment;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class BookingCalendar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4055404923785054979L;

	private AppointmentController appCtr;

	private JCalendar calendar;

	private Date date;
	private List<String> validTimes;
	private Map<String, JCheckBox> timeMap;

	/**
	 * Create the panel.
	 */
	public BookingCalendar() {
		setLayout(null);

		timeMap = new HashMap<String, JCheckBox>();
		validTimes = new ArrayList<>();

		try {
			appCtr = new AppointmentController();
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel panelCalendar = new JPanel();
		panelCalendar.setBackground(Color.DARK_GRAY);
		panelCalendar.setBounds(0, 0, 810, 656);
		add(panelCalendar);

		JSeparator separatorTopLeft = new JSeparator();
		separatorTopLeft.setBounds(10, 15, 221, 11);

		JSeparator separatorTopRight = new JSeparator();
		separatorTopRight.setBounds(525, 15, 221, 11);

		JLabel lblCalendar = new JLabel("Kalender");
		lblCalendar.setBounds(332, 5, 111, 29);
		lblCalendar.setForeground(Color.WHITE);
		lblCalendar.setFont(new Font("Tahoma", Font.BOLD, 16));

		calendar = new JCalendar();
		calendar.setBounds(164, 45, 408, 231);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 311, 221, 11);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(525, 311, 221, 11);

		JLabel lblTime = new JLabel("Tidspunkt");
		lblTime.setBounds(332, 293, 111, 29);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));

		ButtonGroup checkBoxes = new ButtonGroup();

		JCheckBox checkBox0730 = new JCheckBox("07:30");
		checkBox0730.setBounds(20, 320, 97, 23);
		checkBox0730.setForeground(SystemColor.activeCaption);
		checkBox0730.setContentAreaFilled(false);
		checkBox0730.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0730.setEnabled(false); // Set if selectable
		checkBoxes.add(checkBox0730);

		JCheckBox checkBox0745 = new JCheckBox("07:45");
		checkBox0745.setBounds(170, 320, 97, 23);
		checkBox0745.setForeground(SystemColor.activeCaption);
		checkBox0745.setContentAreaFilled(false);
		checkBox0745.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0745.setEnabled(false);
		checkBoxes.add(checkBox0745);

		JCheckBox checkBox0800 = new JCheckBox("08:00");
		checkBox0800.setBounds(320, 320, 97, 23);
		checkBox0800.setForeground(SystemColor.activeCaption);
		checkBox0800.setContentAreaFilled(false);
		checkBox0800.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0800.setEnabled(false);
		checkBoxes.add(checkBox0800);

		JCheckBox checkBox0815 = new JCheckBox("08:15");
		checkBox0815.setBounds(470, 320, 97, 23);
		checkBox0815.setForeground(SystemColor.activeCaption);
		checkBox0815.setContentAreaFilled(false);
		checkBox0815.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0815.setEnabled(false);
		checkBoxes.add(checkBox0815);

		JCheckBox checkBox0830 = new JCheckBox("08:30");
		checkBox0830.setBounds(620, 320, 97, 23);
		checkBox0830.setForeground(SystemColor.activeCaption);
		checkBox0830.setContentAreaFilled(false);
		checkBox0830.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0830.setEnabled(false);
		checkBoxes.add(checkBox0830);
		
		JCheckBox checkBox0845 = new JCheckBox("08:45");
		checkBox0845.setBounds(20, 360, 97, 23);
		checkBox0845.setForeground(SystemColor.activeCaption);
		checkBox0845.setContentAreaFilled(false);
		checkBox0845.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0845.setEnabled(false);
		checkBoxes.add(checkBox0845);

		JCheckBox checkBox1000 = new JCheckBox("10:00");
		checkBox1000.setBounds(20, 400, 97, 23);
		checkBox1000.setForeground(SystemColor.activeCaption);
		checkBox1000.setContentAreaFilled(false);
		checkBox1000.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1000.setEnabled(false);
		checkBoxes.add(checkBox1000);

		JCheckBox checkBox1115 = new JCheckBox("11:15");
		checkBox1115.setBounds(20, 440, 97, 23);
		checkBox1115.setForeground(SystemColor.activeCaption);
		checkBox1115.setContentAreaFilled(false);
		checkBox1115.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1115.setEnabled(false);
		checkBoxes.add(checkBox1115);

		JCheckBox checkBox1230 = new JCheckBox("12:30");
		checkBox1230.setBounds(20, 480, 97, 23);
		checkBox1230.setForeground(SystemColor.activeCaption);
		checkBox1230.setContentAreaFilled(false);
		checkBox1230.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1230.setEnabled(false);
		checkBoxes.add(checkBox1230);

		JCheckBox checkBox1345 = new JCheckBox("13:45");
		checkBox1345.setBounds(20, 520, 97, 23);
		checkBox1345.setForeground(SystemColor.activeCaption);
		checkBox1345.setContentAreaFilled(false);
		checkBox1345.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1345.setEnabled(false);
		checkBoxes.add(checkBox1345);
		
		JCheckBox checkBox0900 = new JCheckBox("09:00");
		checkBox0900.setBounds(170, 360, 97, 23);
		checkBox0900.setForeground(SystemColor.activeCaption);
		checkBox0900.setContentAreaFilled(false);
		checkBox0900.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0900.setEnabled(false);
		checkBoxes.add(checkBox0900);

		JCheckBox checkBox0915 = new JCheckBox("09:15");
		checkBox0915.setBounds(320, 360, 97, 23);
		checkBox0915.setForeground(SystemColor.activeCaption);
		checkBox0915.setContentAreaFilled(false);
		checkBox0915.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0915.setEnabled(false);
		checkBoxes.add(checkBox0915);
		
		JCheckBox checkBox0930 = new JCheckBox("09:30");
		checkBox0930.setBounds(470, 360, 97, 23);
		checkBox0930.setForeground(SystemColor.activeCaption);
		checkBox0930.setContentAreaFilled(false);
		checkBox0930.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0930.setEnabled(false);
		checkBoxes.add(checkBox0930);
		
		JCheckBox checkBox0945 = new JCheckBox("09:45");
		checkBox0945.setBounds(620, 360, 97, 23);
		checkBox0945.setForeground(SystemColor.activeCaption);
		checkBox0945.setContentAreaFilled(false);
		checkBox0945.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox0945.setEnabled(false);
		checkBoxes.add(checkBox0945);
		
		JCheckBox checkBox1015 = new JCheckBox("10:15");
		checkBox1015.setBounds(170, 400, 97, 23);
		checkBox1015.setForeground(SystemColor.activeCaption);
		checkBox1015.setContentAreaFilled(false);
		checkBox1015.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1015.setEnabled(false);
		checkBoxes.add(checkBox1015);
		
		JCheckBox checkBox1030 = new JCheckBox("10:30");
		checkBox1030.setBounds(320, 400, 97, 23);
		checkBox1030.setForeground(SystemColor.activeCaption);
		checkBox1030.setContentAreaFilled(false);
		checkBox1030.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1030.setEnabled(false);
		checkBoxes.add(checkBox1030);
		
		JCheckBox checkBox1045 = new JCheckBox("10:45");
		checkBox1045.setBounds(470, 400, 97, 23);
		checkBox1045.setForeground(SystemColor.activeCaption);
		checkBox1045.setContentAreaFilled(false);
		checkBox1045.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1045.setEnabled(false);
		checkBoxes.add(checkBox1045);
		
		JCheckBox checkBox1100 = new JCheckBox("11:00");
		checkBox1100.setBounds(620, 400, 97, 23);
		checkBox1100.setForeground(SystemColor.activeCaption);
		checkBox1100.setContentAreaFilled(false);
		checkBox1100.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1100.setEnabled(false);
		checkBoxes.add(checkBox1100);
		
		JCheckBox checkBox1130 = new JCheckBox("11:30");
		checkBox1130.setBounds(170, 440, 97, 23);
		checkBox1130.setForeground(SystemColor.activeCaption);
		checkBox1130.setContentAreaFilled(false);
		checkBox1130.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1130.setEnabled(false);
		checkBoxes.add(checkBox1130);
			
		JCheckBox checkBox1145 = new JCheckBox("11:45");
		checkBox1145.setBounds(320, 440, 97, 23);
		checkBox1145.setForeground(SystemColor.activeCaption);
		checkBox1145.setContentAreaFilled(false);
		checkBox1145.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1145.setEnabled(false);
		checkBoxes.add(checkBox1145);
		
		JCheckBox checkBox1200 = new JCheckBox("12:00");
		checkBox1200.setBounds(470, 440, 97, 23);
		checkBox1200.setForeground(SystemColor.activeCaption);
		checkBox1200.setContentAreaFilled(false);
		checkBox1200.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1200.setEnabled(false);
		checkBoxes.add(checkBox1200);
		
		JCheckBox checkBox1215 = new JCheckBox("12:15");
		checkBox1215.setBounds(620, 440, 97, 23);
		checkBox1215.setForeground(SystemColor.activeCaption);
		checkBox1215.setContentAreaFilled(false);
		checkBox1215.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1215.setEnabled(false);
		checkBoxes.add(checkBox1215);
		
		JCheckBox checkBox1245 = new JCheckBox("12:45");
		checkBox1245.setBounds(170, 480, 97, 23);
		checkBox1245.setForeground(SystemColor.activeCaption);
		checkBox1245.setContentAreaFilled(false);
		checkBox1245.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1245.setEnabled(false);
		checkBoxes.add(checkBox1245);
		
		JCheckBox checkBox1300 = new JCheckBox("13:00");
		checkBox1300.setBounds(320, 480, 97, 23);
		checkBox1300.setForeground(SystemColor.activeCaption);
		checkBox1300.setContentAreaFilled(false);
		checkBox1300.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1300.setEnabled(false);
		checkBoxes.add(checkBox1300);
		
		JCheckBox checkBox1315 = new JCheckBox("13:15");
		checkBox1315.setBounds(470, 480, 97, 23);
		checkBox1315.setForeground(SystemColor.activeCaption);
		checkBox1315.setContentAreaFilled(false);
		checkBox1315.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1315.setEnabled(false);
		checkBoxes.add(checkBox1315);
		
		JCheckBox checkBox1330 = new JCheckBox("13:30");
		checkBox1330.setBounds(620, 480, 97, 23);
		checkBox1330.setForeground(SystemColor.activeCaption);
		checkBox1330.setContentAreaFilled(false);
		checkBox1330.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1330.setEnabled(false);
		checkBoxes.add(checkBox1330);
			
		JCheckBox checkBox1400 = new JCheckBox("14:00");
		checkBox1400.setBounds(170, 520, 97, 23);
		checkBox1400.setForeground(SystemColor.activeCaption);
		checkBox1400.setContentAreaFilled(false);
		checkBox1400.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1400.setEnabled(false);
		checkBoxes.add(checkBox1400);
		
		JCheckBox checkBox1415 = new JCheckBox("14:15");
		checkBox1415.setBounds(320, 520, 97, 23);
		checkBox1415.setForeground(SystemColor.activeCaption);
		checkBox1415.setContentAreaFilled(false);
		checkBox1415.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1415.setEnabled(false);
		checkBoxes.add(checkBox1415);
		
		JCheckBox checkBox1430 = new JCheckBox("14:30");
		checkBox1430.setBounds(470, 520, 97, 23);
		checkBox1430.setForeground(SystemColor.activeCaption);
		checkBox1430.setContentAreaFilled(false);
		checkBox1430.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox1430.setEnabled(false);
		checkBoxes.add(checkBox1430);
		
		JButton btnNext = new JButton("Kvittering");
		btnNext.setFocusable(false);
		btnNext.setBounds(562, 556, 155, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jumpToReceipt();
				JCheckBox checkBox = isSelected();
				addDate(date, checkBox);
			}
		});
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.setIcon(new ImageIcon(BookingCalendar.class.getResource("/Images/icons8_Right_32px_1.png")));
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNext.setForeground(SystemColor.activeCaption);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNext.setContentAreaFilled(false);

		JButton btnBack = new JButton("Services");
		btnBack.setFocusable(false);
		btnBack.setBounds(20, 557, 133, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jumpBackToServices();
			}
		});
		btnBack.setIcon(new ImageIcon(BookingCalendar.class.getResource("/Images/icons8_Left_32px.png")));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setForeground(SystemColor.activeCaption);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setContentAreaFilled(false);
		panelCalendar.setLayout(null);
		panelCalendar.add(separatorTopLeft);
		panelCalendar.add(separatorTopRight);
		panelCalendar.add(lblCalendar);
		panelCalendar.add(calendar);
		panelCalendar.add(separator);
		panelCalendar.add(separator_1);
		panelCalendar.add(lblTime);

		// Associate checkbox with time string. Used to access objects by key.
		timeMap.put("07:30", checkBox0730);
		timeMap.put("07:45", checkBox0745);
		timeMap.put("08:00", checkBox0800);
		timeMap.put("08:15", checkBox0815);
		timeMap.put("08:30", checkBox0830);
		timeMap.put("08:45", checkBox0845);
		timeMap.put("09:00", checkBox0900);
		timeMap.put("09:15", checkBox0915);
		timeMap.put("09:30", checkBox0930);
		timeMap.put("09:45", checkBox0945);
		timeMap.put("10:00", checkBox1000);
		timeMap.put("10:15", checkBox1015);
		timeMap.put("10:30", checkBox1030);
		timeMap.put("10:45", checkBox1045);
		timeMap.put("11:00", checkBox1100);
		timeMap.put("11:15", checkBox1115);
		timeMap.put("11:30", checkBox1130);
		timeMap.put("11:45", checkBox1145);
		timeMap.put("12:00", checkBox1200);
		timeMap.put("12:15", checkBox1215);
		timeMap.put("12:30", checkBox1230);
		timeMap.put("12:45", checkBox1245);
		timeMap.put("13:00", checkBox1300);
		timeMap.put("13:15", checkBox1315);
		timeMap.put("13:30", checkBox1330);
		timeMap.put("13:45", checkBox1345);
		timeMap.put("14:00", checkBox1400);
		timeMap.put("14:15", checkBox1415);
		timeMap.put("14:30", checkBox1430);
		
		getDates();

		panelCalendar.add(checkBox0730);
		panelCalendar.add(checkBox0745);
		panelCalendar.add(checkBox0800);
		panelCalendar.add(checkBox0815);
		panelCalendar.add(checkBox0830);
		panelCalendar.add(checkBox0845);
		panelCalendar.add(checkBox1000);
		panelCalendar.add(checkBox1115);
		panelCalendar.add(checkBox1230);
		panelCalendar.add(checkBox1345);
		panelCalendar.add(checkBox0900);
		panelCalendar.add(checkBox0915);
		panelCalendar.add(checkBox0930);
		panelCalendar.add(checkBox0945);
		panelCalendar.add(checkBox1015);
		panelCalendar.add(checkBox1030);
		panelCalendar.add(checkBox1045);
		panelCalendar.add(checkBox1100);
		panelCalendar.add(checkBox1130);
		panelCalendar.add(checkBox1145);
		panelCalendar.add(checkBox1200);
		panelCalendar.add(checkBox1215);
		panelCalendar.add(checkBox1245);
		panelCalendar.add(checkBox1300);
		panelCalendar.add(checkBox1315);
		panelCalendar.add(checkBox1330);
		panelCalendar.add(checkBox1400);
		panelCalendar.add(checkBox1415);
		panelCalendar.add(checkBox1430);
		
				JCheckBox checkBox1445 = new JCheckBox("14:45");
				checkBox1445.setBounds(620, 520, 97, 23);
				checkBox1445.setForeground(SystemColor.activeCaption);
				checkBox1445.setContentAreaFilled(false);
				checkBox1445.setFont(new Font("Tahoma", Font.BOLD, 13));
				checkBox1445.setEnabled(false);
				timeMap.put("14:45", checkBox1445);
				panelCalendar.add(checkBox1445);
		panelCalendar.add(btnNext);
		panelCalendar.add(btnBack);

	}

	private void jumpToReceipt() { // skifter side til Contact (Kontakt)
		super.getParent();
		// CardLayout cl = (CardLayout) (((Container)
		// AppointmentPanel.panelService).getLayout()); //giver sig selv nullpointer
		CardLayout cl = (CardLayout) (((getParent()).getLayout())); // NullPointer ved 209
		cl.show(getParent(), "receipt");
	}

	private void jumpBackToServices() {
		CardLayout cl = (CardLayout) (((getParent()).getLayout()));
		cl.show(getParent(), "service");
	}

	/**
	 * Check jCalender update date.
	 * If updated get time values that is eligible for the appointment.
	 * Makes the available times checkboxes clickable.
	 */
	private void getDates() {
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			int i = 0; // Quick fix for load at start of initiation.
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				System.out.println(i);
				
				if(i >= 1) {
				cleanUp(timeMap);
				date = calendar.getDate();
				validTimes = getValidTimes(AppointmentPanel.appointment);
				System.out.println(date);
				/**
				 * Iterate through array with valid times, set them as clickable for the user.
				 */
				for (String time : validTimes) {
					/**
					 * If no appointments, set all to clickable. 
					 * NOT GOOD - DOES NOT CALCULATE TIME THAT APPOINTMENT WILL HAVE.
					 */
					if (validTimes.get(0) == "none") {
						System.out.println("No appointments this day");
						for (JCheckBox tempCheck : timeMap.values()) {
							tempCheck.setEnabled(true);
						}
					} else {
						// Where hashmap and array has same entry.
						if (timeMap.containsKey(time)) {
							timeMap.get(time).setEnabled(true);
						}
					}

				}
			}
				i++;
			}
		});
	}

	/**
	 * Iterate through checkboxes that are clickable, set them to not clickable
	 */
	private void cleanUp(Map<String, JCheckBox> timeMap) {
		for (JCheckBox tempCheckBox : timeMap.values()) {
			  tempCheckBox.setEnabled(false);
			}
	}
	
	/**
	 * Apparently button group does not come with a selected, so needs to be done manually.
	 */
	private JCheckBox isSelected() {
		JCheckBox tempCheck = null;
		for (JCheckBox checkBox : timeMap.values()) {
			  if(checkBox.isSelected()) {
				  return checkBox;
			  }
			}
		return tempCheck;
	}
	
	/**
	 * Add the date to appointment.
	 */
	private void addDate(Date date, JCheckBox checkBox) {
        
		System.out.println(date + " at " + checkBox.getText());
		appCtr.addDate(AppointmentPanel.appointment, date);
		AppointmentPanel.appointment.setTimeFrom(checkBox.getText());
		
		
		//AppointmentPanel.appointment.setTimeFrom(time);
	}

	/**
	 * Get the valid times for chosen date.
	 */
	private List<String> getValidTimes(Appointment appointment) {
		appointment.setAppDate(date);
		return appCtr.checkTimes(appointment);
	}

}
