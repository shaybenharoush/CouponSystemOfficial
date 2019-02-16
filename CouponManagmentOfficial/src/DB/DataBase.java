package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Tal Yamin
 *
 */

public class DataBase {

	//DB connection port
	private static String connectionString = "jdbc:derby://localhost:3301/CouponManagment;create=true";
	//DB derby driver
	private static String DriverConnection = "org.apache.derby.jdbc.ClientDriver";
	//static connection - should be in connection pool 
	private static Connection connection;

	
	//get method for DB connection port
	public static String getConnectionString() {
		return connectionString;
	}

	//get method for DB derby driver
	public static String getDriverConnextion() {
		return DriverConnection;
	}

	
	// create Company table
	public static void createCompanyTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "create table Company (" + "ID bigint not null primary key, " + "COMP_NAME varchar(50) not null, "
				+ "PASSWORD varchar(50) not null, " + "EMAIL varchar(50) not null)";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Company table has been created");

		} catch (SQLException e) {
			throw new Exception("unable to create Company table");
		} finally {
			connection.close();
		}

	}

	// create Customer table
	public static void createCustomerTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "create table Customer (" + "ID bigint not null primary key, " + "CUST_NAME varchar(50) not null, "
				+ "PASSWORD varchar(50) not null)";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Customer table has been created");

		} catch (SQLException e) {
			throw new Exception("unable to create Customer table");
		} finally {
			connection.close();
		}

	}

	// create Coupon table
	public static void createCouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "create table Coupon (" + "ID bigint not null primary key, " + "TITLE varchar(50) not null, "
				+ "START_DATE date not null, " + "END_DATE date not null, " + "AMOUNT integer not null, "
				+ "TYPE varchar(50) not null, " + "MESSAGE varchar(50) not null, " + " PRICE float not null, "
				+ "IMAGE varchar(200) not null)";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Coupon table has been created");

		} catch (SQLException e) {
			throw new Exception("unable to create Coupon table");
		} finally {
			connection.close();
		}

	}

	// create Customer_Coupon table
	public static void createCustomer_CouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "create table Customer_Coupon (" + "Customer_ID bigint, " + "Coupon_ID bigint, "
				+ "primary key (Customer_ID, Coupon_ID))";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Customer_Coupon table has been created");

		} catch (SQLException e) {
			throw new Exception("unable to create Customer_Coupon table");
		} finally {
			connection.close();
		}

	}

	// create Company_Coupon table
	public static void createCompany_CouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "create table Company_Coupon (" + "Company_ID bigint, " + "Coupon_ID bigint, "
				+ "primary key (Company_ID, Coupon_ID))";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Company_Coupon table has been created");

		} catch (SQLException e) {
			throw new Exception("unable to create Company_Coupon table");
		} finally {
			connection.close();
		}

	}

	// drop Company table
	public static void dropCompanyTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "drop table Company";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Company Table dropped successfully");

		} catch (SQLException e) {
			throw new Exception("unable to drop Company Table");
		} finally {
			connection.close();
		}
	}

	// drop Customer table
	public static void dropCustomerTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "drop table Customer";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Customer Table dropped successfully");

		} catch (SQLException e) {
			throw new Exception("unable to drop Customer Table");
		} finally {
			connection.close();
		}
	}

	// drop Coupon table
	public static void dropCouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "drop table Coupon";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Coupon Table dropped successfully");

		} catch (SQLException e) {
			throw new Exception("unable to drop Coupon Table");
		} finally {
			connection.close();
		}
	}

	// drop Customer_Coupon table
	public static void dropCustomer_CouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "drop table Customer_Coupon";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Customer_Coupon Table dropped successfully");

		} catch (SQLException e) {
			throw new Exception("unable to drop Customer_Coupon Table");
		} finally {
			connection.close();
		}
	}

	// drop Company_Coupon table
	public static void dropCompany_CouponTable() throws Exception {

		connection = DriverManager.getConnection(DataBase.getConnectionString());

		String sql = "drop table Company_Coupon";

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(sql);

			System.out.println("Company_Coupon Table dropped successfully");

		} catch (SQLException e) {
			throw new Exception("unable to drop Company_Coupon Table");
		} finally {
			connection.close();
		}
	}
	
	public static void BuildDB() throws Exception{
		
		try {
			DataBase.createCompanyTable();
			DataBase.createCustomerTable();
			DataBase.createCouponTable();
			DataBase.createCompany_CouponTable();
			DataBase.createCustomer_CouponTable();
		}catch (SQLException e) {
			throw new Exception("unable to build all tables of DB");
		}	
	}
	
	public static void DropDB() throws Exception{
		
		try {
			DataBase.dropCompanyTable();
			DataBase.dropCustomerTable();
			DataBase.dropCouponTable();
			DataBase.dropCompany_CouponTable();
			DataBase.dropCustomer_CouponTable();
		}catch (SQLException e) {
			throw new Exception("unable to drop all tables of DB");
		}
	}
	
}
