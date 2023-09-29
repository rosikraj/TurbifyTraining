package com.infinite.wallet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Util {
	
	private static final String URL = "jdbc:mysql://localhost:3306/wallet_app";
	private static final String USER = "root";
	private static final String PASSWORD ="mysql@123";

	public static Connection getConnection() {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return connection;
}

}
