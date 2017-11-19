package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e2) {

		}
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:" + this.getClass().getResource("/").getPath() + "test.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {

		}
		if (conn == null)
			System.out.println("error can't connect to database");
		return conn;
	}
}