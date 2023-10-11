package com.infinite.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con = null;

	public static Connection getDatabaseconnection()
	{
		try {
			//loading driver
			Class.forName("com.mysql.jdbc.Driver");
			//connecting to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "mysql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;//return database connection
	}
}

