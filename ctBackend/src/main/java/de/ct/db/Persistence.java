package de.ct.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Persistence {

	public static final String DB_DRIVER = "org.postgresql.Driver";
	public static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/ctdb";
	public static final String DB_USER = "postgres";
	public static final String DB_PASSWORD = "ChristofIngo2012";
	public Connection dbConnection = null;
	public PreparedStatement preparedStatement = null;
	
	public Connection getDBConnection() {
		try {
			Class.forName(DB_DRIVER).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
