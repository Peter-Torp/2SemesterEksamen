package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.sql.*;

import module.Appointment;
import module.Appointment.AppState;
import module.Car;
import module.Employee;
import module.Person.PersonType;
import module.Service;

public class AppointmentDB implements AppointmentDBIF{
	
	/**
	 * Creating final variables containing SQL statements to insert into prepareStatements
	 */
	private static final String FIND_ALL_APP_BY_CAR_Q = "SELECT * FROM appointment WHERE regNo = ?"; 
	private static final String FIND_APP_BY_APP_ID_Q = "SELECT * FROM appointment WHERE app_Id = ?";
	private PreparedStatement findAllAppsByCar, findAppByAppId; 
	
	private static final String INSERT_SERV_APP_INTERMEDIATE_Q = "INSERT INTO ServiceIntermediate VALUES (?,?,?)";
	private static final String INSERT_APP_Q = "INSERT INTO appointment (orderDate, appDate, totalPrice, state, regNo, ws_id, timeTo, timeFrom) values"
			+ "(?,?,?,?,?,?,?,?) ";
	private PreparedStatement insertApp, insertServAppIntermediate; 
	
	private static final String DELETE_APP_Q = "DELETE FROM appointment WHERE app_id = ?"; 
	private PreparedStatement deleteAppById; 
	
	private static final String FIND_ALL_APP_BY_DATE_Q = "SELECT * FROM Appointment WHERE appDate = ? AND ws_Id = ? ORDER BY timeFrom";
	private PreparedStatement findAllAppsByDate;
	//Connect to database
	Connection con = DBConnection.getInstance().getConnection(); 

	
	//Constructor
	public AppointmentDB() throws DataAccessException {
		init(); 
	}
	
	/**
	 * Connecting prepare Statements.
	 * @throws DataAccessException
	 */
	private void init() throws DataAccessException {
		
		try {		//Prepare the statements 
			findAllAppsByCar = con.prepareStatement(FIND_ALL_APP_BY_CAR_Q); 
			findAppByAppId = con.prepareStatement(FIND_APP_BY_APP_ID_Q);
			
			insertApp = con.prepareStatement(INSERT_APP_Q, insertApp.RETURN_GENERATED_KEYS); 
			insertServAppIntermediate = con.prepareStatement(INSERT_SERV_APP_INTERMEDIATE_Q);
			
			deleteAppById = con.prepareStatement(DELETE_APP_Q); 
			
			findAllAppsByDate = con.prepareStatement(FIND_ALL_APP_BY_DATE_Q);
			
		} catch(SQLException e) {		//Throw custom message
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e); 
		}
	}
	
	
	@Override
	public List<Appointment> findAllAppointments(Car car) throws DataAccessException {
		List<Appointment> res = null; 
		
		try {
			if(car != null) {
				findAllAppsByCar.setString(1, car.getRegNo());
			}
			ResultSet rs = findAllAppsByCar.executeQuery(); 
			res = buildObjects(rs); 
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e); 
		}
		
		return res; 
		
	}

	
	/**
	 * Looping a list and getting the data
	 * Save data in a list<> = res
	 * @param rs
	 * @return return res / ResultSet
	 * @throws DataAccessException
	 * @throws SQLException 
	 */
	private List<Appointment> buildObjects(ResultSet rs) throws DataAccessException, SQLException {
		List<Appointment> res = new ArrayList<>(); 
			while(rs.next()) {
				res.add(buildObject(rs)); 
			}
				
		return res;
	}
	
	
	/**
	 * Creating empty object = currApp
	 * Getting data from database and setting the data in currApp
	 * Returning currApp 
	 * @param rs
	 * @return Appointment object
	 * @throws DataAccessException
	 * @throws SQLException 
	 */
	private Appointment buildObject(ResultSet rs) throws DataAccessException, SQLException {
		Appointment currApp;
		
		try {
			currApp = new Appointment(
					rs.getDouble("totalPrice"),
					AppState.valueOf(rs.getString("state")),
					rs.getString("timeTo"),
					rs.getString("timeFrom"),
					rs.getDate("appDate"),
					rs.getString("regNo"),
					20000,
					rs.getInt("app_Id"),
					rs.getInt("ws_Id")
					); 
			
 		}
		catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e); 
		}
		
		return currApp; 
	}

	
	
	@Override
	public int insertAppointment(Appointment appointment, List<Service> services) throws DataAccessException, SQLException {
		con.setAutoCommit(false); // Start transaction.
		

		
		int rowAppointmentAffected = 0;
		insertApp.setDate(1, new java.sql.Date(appointment.getOrderDate().getTime())); // Convert java.util.Date to java.sql.Date
		insertApp.setDate(2,  new java.sql.Date(appointment.getAppDate().getTime()));
		insertApp.setDouble(3, appointment.getTotalPrice());
		insertApp.setString(4, appointment.getState().toString());
		insertApp.setString(5, appointment.getRegNo());
		insertApp.setInt(6, appointment.getWs_Id());
		insertApp.setString(7, appointment.getTimeTo());
		insertApp.setString(8, appointment.getTimeFrom());
		rowAppointmentAffected = insertApp.executeUpdate();
		
		// To get the auto generated key.
		ResultSet keyAppRS = insertApp.getGeneratedKeys();
		int app_Id = 0;
		if (keyAppRS.next()) {
			app_Id = keyAppRS.getInt(1);
		}
		
		if(rowAppointmentAffected == 1) {
			/* 
			 * Loop through the services, and insert a service intermediate for each.
			 */
			for(Service service: services) {
				insertServAppIntermediate.setInt(1, app_Id);
				insertServAppIntermediate.setInt(2, service.getService_Id());
				insertServAppIntermediate.setInt(3, service.getPrice_Id());
				int rowUpdate = insertServAppIntermediate.executeUpdate();
				
				if(rowUpdate != 1) {
					con.rollback();
				} 
			}
		} else {
			con.rollback();
		}
		con.commit();
		return app_Id;
	}
	
	

	@Override
	public boolean confirmAppointment(Appointment appointment, Car car) throws DataAccessException, SQLException {
		return false;			//gør insert ikke dette?
			
	}
	
	/**
	 * Find appointment by app_Id
	 * @param int app_Id
	 * @return appointment object
	 */
	public Appointment findAppointmentByAppId(int app_Id) throws DataAccessException {
		try {
			findAppByAppId.setInt(1, app_Id);
			ResultSet rs = findAppByAppId.executeQuery();
			Appointment appointment= null;
			if (rs.next()) {
				appointment = buildObject(rs);
			}
			return appointment;
		} catch (SQLException e) {
			System.out.println("SQL exception thrown  :" + e);
		}
		return null;
	}
	
	/**
	 * Find appointments associated with a RegNo
	 * @param String regNo 
	 * @return List of appointments[]
	 */
	public List<Appointment> findAppointmentsByRegNo(String RegNo) throws DataAccessException {
		ResultSet rs;
		try {
			findAppByAppId.setString(1, RegNo);
			rs = this.findAllAppsByCar.executeQuery();
			List<Appointment> appointments = buildObjects(rs);
			return appointments;
		} catch (SQLException e) {

		}
		return null;
	}
	

	@Override
	public Date getDates(int Timeintensity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * find appointments by date
	 * WS_ID is hardcoded atm.
	 * @param Appointment appointment
	 * @return list of appointments[]
	 * @throws DataAccessException
	 */
	private List<Appointment> findAppointmentsByDate(Appointment appointment) throws DataAccessException{
		ResultSet rs;
		List<Appointment> appointments = null;
		try {
			findAllAppsByDate.setDate(1, new java.sql.Date(appointment.getAppDate().getTime()));
			findAllAppsByDate.setInt(2, 1);
			rs = findAllAppsByDate.executeQuery();
			appointments = buildObjects(rs);
			return appointments;
		} catch (SQLException e) {

		}
		return null;
	}
	
	/**
	 * 
	 */
	public HashMap<String,Integer> timestamps(Appointment appointment) throws DataAccessException {
		List<Appointment> appointments = findAppointmentsByDate(appointment);
		HashMap<String, Integer> timeIntappStartMap = new HashMap<String, Integer>(); // To pair a closing time of one appointment, with how many minutes til next appointment.

		for(int i = 0; i < appointments.size(); i++) {
			Appointment currentAppointment = appointments.get(i);
			Appointment nextAppointment = null;
			int nextI = i + 1;
			if(nextI < appointments.size()) {
				nextAppointment = appointments.get(nextI);
			}
			int timeAvailability = appointment.calcTimeDifference(currentAppointment, nextAppointment);
			timeIntappStartMap.put(currentAppointment.getTimeTo(),timeAvailability);
			System.out.println("Hash map key and value : " + currentAppointment.getTimeTo() + " +" + timeIntappStartMap.get(currentAppointment.getTimeTo()) + " minutes");
		}
		
		return timeIntappStartMap;
	}
	
	
	@Override
	public void deleteApp(String appId) throws SQLException {
		
		deleteAppById.setString(1, appId); 
		
		 
	}


		
	

}
