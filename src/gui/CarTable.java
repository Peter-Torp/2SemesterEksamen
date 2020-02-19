package gui;

import java.util.ArrayList;
import java.util.List;

import controller.CarController;
import database.CarDB;
import guilib.ModelTable;
import module.*;


public class CarTable extends ModelTable<Car> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6533844442643628260L;
	private List<Car> data = new ArrayList<>();
	private CarController carController;
	
	public CarTable() {
		carController = new CarController();
	}
	//Registreringsnummer, Model
	private static final String [] COL_NAMES = {"RegistreringsNummer", "Model"};
	
	@Override
	public String doGetValueOfColumn(Car value, int column) {
		String res = "unknown";
		switch (column) {
		case 0:
			res = value.getRegNo();
			break;
			
		case 1:
			res = value.getModel();
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

	public void doUpdate(int cus_Id) {
		data = carController.getCars(cus_Id);
		
		this.setTableData(data);
	}
	
}
