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
			HikariConfig config = new HikariConfig(); //config is used to set up the configuration for the connection pooling
			config.setDriverClassName("com.mysql.cj.jdbc.Driver");
			config.setJdbcUrl("jdbc:mysql://localhost:3306/training");
			config.setUsername("root");
			config.setPassword("mysql@123");
			config.setMaximumPoolSize(10); //only for 10 requests for connection ,other request should wait
			config.setAutoCommit(true); //if commit is false we cann't add the data to db
			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("prepStmtCacheSize", "250");
			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			datasource = new HikariDataSource(config);

		}
		return datasource;
	

		}

	}


