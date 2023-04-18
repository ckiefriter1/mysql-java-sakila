package sakila.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sakila.exception.DbException;

public class DbConnection {

	private static final String SCHEMA = "sakila";
	private static final String USER = "sakila";
	private static final String PASSWORD = "sakila";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false&allowPublicKeyRetrieval=true", 
				HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting to database with URL = " + url);
		
		/*
		 * Create and open connection to the database.
		 */
		Connection conn;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Successfully obtained database connection");
			return conn;
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

}
