package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.*;


public class TestDatabaseAccess {
		
		DBConnection con = null;

		/** Fixture for database access. 
		 * @throws DataAccessException */
		@BeforeEach
		public void setUp() throws DataAccessException {
			con = DBConnection.getInstance();
		}
		
		@Test
		public void wasConnected() {
			assertNotNull("Connected - connection cannot be null", con);	
		}
		
		/** Fixture for testing. */
		@AfterEach
		public void cleanUp() {
			DBConnection.closeConnection();
		}	
}
