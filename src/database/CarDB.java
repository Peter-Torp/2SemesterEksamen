package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import module.Car;


public class CarDB implements CarDBIF {
	
	Connection con; 
	
	
	private static final String FIND_ALL_Q =
			"SELECT regNo,km,cd.model, b.brand, cd.year, cd.color, emp_Id " + 
			"FROM Car c " + 
			"INNER JOIN CarDescriptor cd " + 
				"ON c.carDesc_Id=cd.carDesc_Id " + 
			"INNER JOIN Brand b " + 
				"ON cd.model=b.model";
	private static final String FIND_ALL_BY_CUS_ID_Q = 
			FIND_ALL_Q + " WHERE cus_Id = ?";
	private static final String FIND_BY_REGNO_Q =
			FIND_ALL_Q + " WHERE regNo = ?";
	
	private static final String DELETE_CAR_BY_REGNO_Q = "DELETE FROM car WHERE regNo = ?";
	
	private static final String INSERT_CAR_Q = "INSERT INTO car (regNo, km, cus_Id, carDesc_Id, emp_Id) VALUES(?,?,?,?,?)"; 
	private static final String INSERT_CAR_CARDESC_Q = "INSERT INTO carDescriptor (model, year, color) VALUES(?,?,?)";
	
	private static final String FIND_BRAND_Q = "SELECT * FROM brand WHERE model = ?";
	private static final String FIND_MODEL_Q = "SELECT * FROM brand WHERE model = ?"; 

	private static final String INSERT_BRAND_AND_MODEL_Q = "INSERT INTO brand (brand, model) VALUES(?,?)";  
	
	
	private PreparedStatement findAll, findByRegNo, findAllByCus_Id, deleteByRegNo, insertCar, findBrand, findModel, insertBrandAndModel, insertCarDesc;
	
	 private static CarDB cardb;
	
	public CarDB() throws DataAccessException {
		
		init(); 
	}
	
	
	public void init() throws DataAccessException {
			con = DBConnection.getInstance().getConnection(); 
		
			try {
				
			findAll = con.prepareStatement(FIND_ALL_Q);
			findByRegNo = con.prepareStatement(FIND_BY_REGNO_Q);
			findAllByCus_Id = con.prepareStatement(FIND_ALL_BY_CUS_ID_Q);
			deleteByRegNo = con.prepareStatement(DELETE_CAR_BY_REGNO_Q); 
			insertCar = con.prepareStatement(INSERT_CAR_Q); 
			findBrand = con.prepareStatement(FIND_BRAND_Q);
			insertBrandAndModel = con.prepareStatement(INSERT_BRAND_AND_MODEL_Q);
			insertCarDesc = con.prepareStatement(INSERT_CAR_CARDESC_Q, insertCarDesc.RETURN_GENERATED_KEYS); 
			findModel = con.prepareStatement(FIND_MODEL_Q); 
						
		} catch (SQLException e){
			throw new DataAccessException("Could not get connection to database", e);
		}
	}
	
	
	/**
	 * Convert a collection of results to Java Objects..
	 * @param rs A collection of results from a DB query of the Objects Car.
	 * @return	An array list of Car.
	 * @throws SQLException
	 */
	private List<Car> buildObjects(ResultSet rs) throws SQLException {
		List<Car> cars = new ArrayList<>(); 
		while (rs.next()) {
			cars.add(buildObject(rs));
		}
		return cars;
	}
	
	/**
	 * Convert a result to Java Object.
	 * @param rs A result from a DB query of the object Car.
	 * @return Car car
	 * @throws SQLException
	 */
	private Car buildObject(ResultSet rs) throws SQLException {
		Car car = new Car(
				rs.getString("brand"),
				rs.getString("model"),
				rs.getString("color"),
				rs.getInt("year"),
				rs.getString("regNo"),
				rs.getInt("km"),
				rs.getInt("emp_Id")
				);
		
		return car;
	}
	
	
	@Override
	public Car findByRegNo(String regNo) {
			Car car = null;
		try {
			findByRegNo.setString(1, regNo);
			ResultSet rs = findByRegNo.executeQuery();
			
			if(rs.next()) {
				car = buildObject(rs);
			}
			
		} catch (SQLException e){
			System.out.println("SQL exception thrown  :" + e);
		}
		return car;
		
	}

	
	@Override
	public List<Car> findCarsByCus_Id(int cus_Id) {
		try {
			findAllByCus_Id.setInt(1, cus_Id);
			ResultSet result;
			result = findAllByCus_Id.executeQuery();
			List<Car> cars = buildObjects(result);
			return cars;
		} catch (SQLException e) {
			System.out.println("SQL exception thrown  :" + e);
		}
		return null;
	}
	
	/**
	 * Singleton. Only one instance of carDB. Return if already exists. Create if null.
	 * @return CarDB carDB
	 */
    public static CarDB getInstance(){
        if(cardb == null){
            try {
				cardb = new CarDB();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return cardb;
    }


	@Override
	public boolean deleteCarByRegNo(String regNo) throws SQLException, DataAccessException {
		
		try {
			
		deleteByRegNo.setString(1, regNo); 
			return true; 
		
		} catch(SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e); 
		}
		
		
	}


	@Override
	public Car insertCar(Car car) throws SQLException, DataAccessException {
		
				
		
		try {
				DBConnection.getInstance().startTransaction();
				System.out.println("Opretter forbindelse til databasen");
				DBConnection.getInstance().getConnection().setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);  
				int transIsoLvl = DBConnection.getInstance().getConnection().getTransactionIsolation();
				System.out.println("Tranaktionens isolations niveau er: " + transIsoLvl);
				
			/*
			 * Check if brand and model exists. 
			 * If not insert new brand and/or model
			 */
			
			findModel.setString(1, car.getModel()); 
			
			ResultSet modelRS = findModel.executeQuery(); 
			int rowBrandAffected = 0; 
			System.out.println("Checker om model eksisterer"); 
			
			if(modelRS.next()) {
				rowBrandAffected = 1; 
			}
			else {														//brand, model
				System.out.println("Indsætter brand and model");
				insertBrandAndModel.setString(1, car.getBrand());
				insertBrandAndModel.setString(2, car.getModel()); 
				rowBrandAffected = insertBrandAndModel.executeUpdate(); 		//executeUpdate returns rows affected in database. 
			}
			
			
			if(rowBrandAffected == 1) {				//model, year, color
				int rowCarDescAffected = 0;
				System.out.println("Indsætter bil deskriptor: model, årstal og farve");
				insertCarDesc.setString(1, car.getModel());
				insertCarDesc.setInt(2,car.getYear()); 
				insertCarDesc.setString(3, car.getColor()); 
				rowCarDescAffected = insertCarDesc.executeUpdate(); 
			
				ResultSet keyCarDescRS = insertCarDesc.getGeneratedKeys(); 
				int carDesc = 0; 
				
				if(keyCarDescRS.next()){
					carDesc = keyCarDescRS.getInt(1); //get generated key
				}
				System.out.println("bil diskriptor Id: " + carDesc);
			
			if(rowCarDescAffected == 1) {					//regNo, km, cus_Id, carDesc_Id, emp_Id
				System.out.println("Indsætter bilen med: regNo, km, cus_Id, carDesc_Id og emp_Id");
				
				insertCar.setString(1, car.getRegNo()); 
				insertCar.setInt(2, car.getKm()); 
				insertCar.setInt(3, 2);
				insertCar.setInt(4, carDesc);
				insertCar.setInt(5, car.getEmp_Id()); 	
					
					
				} else {
					System.out.println("CarDescriptor failed insertion. Rollback"); 
					DBConnection.getInstance().rollbackTransaction();
				}
			} else {
				System.out.println("Car failed insertion. Rollback"); 
				DBConnection.getInstance().rollbackTransaction();
			}
		
			System.out.println("Det hele gik godt!");
			DBConnection.getInstance().commitTransaction();
			
			
		
		} catch(SQLException e) {
			
			DBConnection.getInstance().rollbackTransaction();
			
				throw new DataAccessException(DBMessages.COULD_NOT_INSERT, e); 
			}
		
		
		return car;
	}
	
	
	
	
	
    
    
	

}
