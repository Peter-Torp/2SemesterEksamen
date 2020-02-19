package gui;

import java.util.ArrayList;
import java.util.List;

import controller.ServiceController;
import database.DataAccessException;
import guilib.ModelTable;
import module.*;


public class ServiceTable extends ModelTable<Service> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6533844442643628260L;
	private List<Service> data = new ArrayList<>();
	private ServiceController serviceController;
	
	public ServiceTable() {
		serviceController = new ServiceController();
	}
	//Registreringsnummer, Model
	private static final String [] COL_NAMES = {"Service", "Pris"};
	
	@Override
	public String doGetValueOfColumn(Service value, int column) {
		String res = "unknown";
		switch (column) {
		case 0:
			res = value.getType().toString();
			break;
			
		case 1:
			res = Double.toString(value.getPrice());
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

	public void doUpdate(Car car, int km) {
		try {
			data = serviceController.getServices(car, km);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setTableData(data);
	}
	
	public List<Service> getServices() {
		return data;
	}
	
}
