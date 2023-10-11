package com.infinite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Hikari {

	private static DataSource datasource=null;
		
		public static DataSource getDataSource(){
			if (datasource == null){
				HikariConfig config = new HikariConfig();
				config.setJdbcUrl("jdbc:mysql://localhost:3306/train");
				config.setUsername("root");
				config.setPassword("mysql@123");
				config.setMaximumPoolSize(10);
				config.setAutoCommit(true);
				config.addDataSourceProperty("cachePrepStmts", "true");
				config.addDataSourceProperty("PrepStmtCacheSize", "250");
				config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
				datasource = new HikariDataSource(config);
			}
			return datasource;
	}
}

