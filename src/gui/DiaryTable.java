package gui;

import java.util.ArrayList;
import java.util.List;

import controller.AppointmentController;
import database.DataAccessException;
import guilib.ModelTable;
import module.*;


public class DiaryTable extends ModelTable<Appointment> {
	/**
	 * 
	 */


	private List<Appointment> data = new ArrayList<>();
	private AppointmentController appointmentController;
	
	public DiaryTable() throws DataAccessException {
			appointmentController = new AppointmentController();
		
	}
	//Registreringsnummer, Model
	private static final String [] COL_NAMES = {"Dato", "Status", "Test"};
	
	@Override
	public String doGetValueOfColumn(Appointment value, int column) {
		String res = "unknown";
		switch (column) {
		case 0:
			res = value.getAppDate().toString();
			break;
			
		case 1:
			res = value.getState().toString();
			break;
		
		case 2:
			res = value.getRegNo().toString();
			break;

		}
		return res;
	}

	@Override
	public int doGetColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public String doGetColumnName(int column) {
		return COL_NAMES[column];
	}

	public void doUpdate(Car car) throws DataAccessException {
		
		data = appointmentController.getAppointments(car);
		System.out.println(data.size());
		this.setTableData(data);
	}
	
}
