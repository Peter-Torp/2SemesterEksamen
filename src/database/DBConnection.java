package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import database.DataAccessException;

public class DBConnection {
	private Connection connection = null;
	private static DBConnection dbConnection;
	private static Connection con;
	
    // an instance of the class is generated
    private static DBConnection  instance = null;

	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "dmaa0918_1074189";		//navnet på databasen
	//private static final String serverAddress = "localhost"; // Til Local
	private static final String serverAddress = "kraka.ucn.dk"; // Til Kraka
	private static final int serverPort = 1433;
	//private static final String userName = "sa"; // til local?
	private static final String userName = "dmaa0918_1074189"; // Til Kraka
	private static final String password = "Password1!"; // Til Kraka ?
	//private static final String password = "secret"; // Til Local ?

	private DBConnection() throws DataAccessException {								//private constructor
		// Cheat sheet for the printf() method, the format is also used in the
		// String.format() method
		// http://alvinalexander.com/programming/printf-format-cheat-sheet
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s",	//Hvor skal databasen findes?
				serverAddress, serverPort, dbName, userName, password);
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Missing JDBC driver", e);
			// System.err.println("Could not load JDBC driver");
			// e.printStackTrace();

		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", dbName,
					serverAddress, serverPort, userName), e);
			// System.out.println("Connection string was: " + connectionString.substring(0,
			// connectionString.length() - password.length()) + "....");
			// e.printStackTrace();
		}
		
	}

	public static synchronized DBConnection getInstance() throws DataAccessException {	//synchronized -> Sikrer single connection
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	/**
	 * Isolate the transaction with autocommit = false. 
	 * @throws DataAccessException
	 */
	public void startTransaction() throws DataAccessException {
		try {
			connection.setAutoCommit(false);
			System.out.println("Starter transaktion");
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not start transaction.", e);
		}
	}
	
	
	/**
	 * If transaction went good. Commit it to the database.
	 * @throws DataAccessException
	 */
	public void commitTransaction() throws DataAccessException {
		try {
			try {
				connection.commit();
				System.out.println("Udfører transaktion");
			} catch (SQLException e) {
				throw e;
				// e.printStackTrace();
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not commit transaction", e);
		}
	}
	
	/**
	 * If transaction went wrong. Rollback the transaction.
	 * @throws DataAccessException
	 */
	public void rollbackTransaction() throws DataAccessException {
		try {
			try {
				connection.rollback();
				System.out.println("Transaktionen gik galt!"); 
			} catch (SQLException e) {
				throw e;
				// e.printStackTrace();
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not rollback transaction", e);
		}
	}
	
	public int executeInsertWithIdentity(String sql) throws DataAccessException {
		System.out.println("DBConnection, Inserting: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()) {
			res = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if (res > 0) {
				ResultSet rs = s.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
			// s.close(); -- the try block does this for us now

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert (" + sql + ").", e);
		}
		return res;
	}

	public int executeInsertWithIdentity(PreparedStatement ps) throws DataAccessException {
		// requires perpared statement to be created with the additional argument PreparedStatement.RETURN_GENERATED_KEYS  
		int res = -1;
		try {
			res = ps.executeUpdate();
			if (res > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert", e);
		}
		return res;
	}
	
	/**
	 * 
	 * @return connection of DBConnection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/*
	 * Close connection to database
	 */
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Close the connection to the database
	 */
	public static void closeConnection()
    {
       	try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }//end closeDB
	
	//getDBcon: returns the singleton instance of the DB connection
    public static boolean instanceIsNull()
    {
       return (instance == null);
    }  
	
    //getDBcon: returns the singleton instance of the DB connection
    public Connection getDBcon()
    {
       return con;
    }
    
    public static boolean connected() throws DataAccessException, SQLException {
    	boolean result = false; 
    	
    	
    	
    		boolean isClosed = DBConnection.getInstance().getConnection().isValid(0);  

			if(con != null) {
				result = true; 
			}

		return isClosed;
    }
    
    
    /*public void setTransactionIsolationLvl() {
    	java.sql.DatabaseMetaData db;
    	
    	int TRANSACTION_SERIALIZABLE;
		if (db.supportsTransactionIsolationLevel(TRANSACTION_SERIALIZABLE)
    			   { con.setTransactionIsolation(TRANSACTION_SERIALIZABLE); 
    			   }
    			   
    }*/
    
    
    
    
}