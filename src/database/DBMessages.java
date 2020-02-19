package database;

public class DBMessages {
	
	/*
	 * Messages to send with dataAccessException
	 */
	static final String COULD_NOT_READ_RESULTSET = "Could not read resultset";
	static final String COULD_NOT_PREPARE_STATEMENT = "Could not prepare statement";
	static final String COULD_NOT_BIND_OR_EXECUTE_QUERY = "Could not bind or execute query";
	public static final String COULD_NOT_BIND_PS_VARS_INSERT = "Could not bind ps variables for insert";
	public static final String COULD_NOT_INSERT = "Could not insert new record";
	public static final String COULD_NOT_CONFIRM = "Could not confirm appointment";
	
	
	/*
	 * Other messages to use elsewhere then DB classes
	 */
	
	public static final String COULD_NOT_CREATE = "Could not create!"; 
}
