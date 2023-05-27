package com.lec.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider2 {

	private static Connection getConnection2() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dpcp:guestbook");

	}
	
}
