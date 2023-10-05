package com.infinite.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPTest {

	private static DataSource datasource = null;

	public static DataSource getDataSource() {
		if (datasource == null) {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl("jdbc:mysql://localhost:3306/training");
			config.setUsername("root");
			config.setPassword("mysql@123");
			config.setMaximumPoolSize(10);
			config.setAutoCommit(false);
			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("prepStmtCacheSize", "250");
			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			datasource = new HikariDataSource(config);

		}
		return datasource;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			DataSource datasource = HikariCPTest.getDataSource();
			connection = datasource.getConnection();
			pstmt = connection.prepareStatement("SELECT * FROM book");
			System.out.println("The Connection object is of class: " + connection.getClass());

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3));

			}
		} catch (Exception e) {
			System.out.print(e);

		}

	}
}
