package com.gmo.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String driver = PropertiesUtil.confProperties.getProperty("db.jdbc.driver");
		String url = PropertiesUtil.confProperties.getProperty("db.jdbc.url");
		String username = PropertiesUtil.confProperties.getProperty("db.jdbc.user");
		String password = PropertiesUtil.confProperties.getProperty("db.jdbc.password");

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
}
