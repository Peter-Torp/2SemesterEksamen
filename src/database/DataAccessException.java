package database;

public class DataAccessException extends Exception {
	

	
	/**
	 * Throw a message and exception
	 * @param String message
	 * @param Throwable e
	 */
	public DataAccessException(String message, Throwable e) {
		super(message, e); 
	}


}