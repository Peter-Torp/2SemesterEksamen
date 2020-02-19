package database;

import java.sql.SQLException;
import java.util.List;

import module.*;

public interface ServiceDBIF {
	
	
	/**
	 * Find all services associated with a car
	 * @param Car car
	 * @param int km
	 * @return List of services[]
	 * @throws DataAccessException
	 */
	public List<Service> findAllServices(Car car, int km) throws DataAccessException;

}
