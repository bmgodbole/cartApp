package com.bg.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
private static Connection connection = null;
public static Connection getConnection() throws ClassNotFoundException, SQLException
{
	if(connection == null)
	{
		Class.forName ("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","rh");
	   
	}
	return connection;
	
}
}
