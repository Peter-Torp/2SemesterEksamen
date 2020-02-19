package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import module.Car;
import module.Employee;
import module.Service;

public class ServiceDB implements ServiceDBIF {
	
	private static final String FIND_ALL_SERVICES_Q = "SELECT * FROM " + 
			"Service S " + 
			"INNER JOIN ServicePrice SP " + 
			"ON SP.price_Id = S.price_Id";
	private PreparedStatement findAllServices; 
	
	Connection con;
	
	public ServiceDB() throws DataAccessException {
		init();
	}

	private void init() throws DataAccessException {
		con = DBConnection.getInstance().getConnection();

		try { // Prepare the statements
			findAllServices = con.prepareStatement(FIND_ALL_SERVICES_Q);

		} catch (SQLException e) { // Throw custom message

			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
	

	@Override
	public List<Service> findAllServices(Car car, int km) throws DataAccessException {
		ResultSet rs;
		try {
			rs = this.findAllServices.executeQuery();
			List<Service> services = buildObjects(rs);
			return services;
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
	
	/**
	 * Create list of services read from database and return
	 * @param ResultSet rs
	 * @return List res
	 * @throws DataAccessException
	 */
	private List<Service> buildObjects(ResultSet rs) throws DataAccessException {
		List<Service> res = new ArrayList<>(); 
		
		try {
			while(rs.next()) {
				Service currService = buildObject(rs);
				res.add(currService);
			}
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e); 
		}
		
		return res; 
	}
	
	
	/**
	 * Create an object from data read from database
	 * @param ResultSet rs
	 * @return currService
	 * @throws DataAccessException
	 */
	private Service buildObject(ResultSet rs) throws DataAccessException {
		Service currService = new Service(null, 0,0,0,0); 
		
		try {
			currService.setType(rs.getString("type")); 
			currService.setTimeIntensity(rs.getInt("timeIntensity")); 
			currService.setPrice(rs.getDouble("price"));
			currService.setPrice_Id(rs.getInt("price_Id"));
			currService.setService_Id(rs.getInt("service_Id"));
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e); 
		}
		
		return currService; 
		
	}
	
	
	
	
}
