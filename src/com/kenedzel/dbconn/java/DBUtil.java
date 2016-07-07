package com.kenedzel.dbconn.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static final String ora_dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ora_username = "hr";
	public static final String ora_password = "hr";
	
	static final String mysql_dbUrl = "jdbc:mysql://localhost:3306/world";
	static final String mysql_username = "root";
	static final String mysql_password = "root";
	
	public static Connection getConnection(DBType dbType) throws SQLException
	{
		switch (dbType)
		{
		case ORADB:
			return DriverManager.getConnection(ora_dbUrl, ora_username, ora_password);
		case MYSQLDB:
			return DriverManager.getConnection(mysql_dbUrl, mysql_username, mysql_password);
		default:
			return null;
		}
		
	}
	public static void showErrorMessage(SQLException e)
	{
		System.err.println("Error: " + e.getMessage());
		System.err.println("Error Code: " + e.getErrorCode());
	}
}
