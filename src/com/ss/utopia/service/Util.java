package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/utopia?serverTimezone=UTC";
	private static final String username = "root"; // change this and password
	private static final String password = "rootpassword";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Registers the driver
		Class.forName(driver);
		// creates Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE);
		// when set to false, commits are not executed without being specified.
		// Everything is soft, not hard commit. saved temporarly
		return conn;

	}
}
