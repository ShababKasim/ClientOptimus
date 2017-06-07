package com.optimus.client.dao.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.optimus.client.dao.DbConfig;

public class DbUtil  implements DbConfig{

	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DBNAME, USER , PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}

	public static void close() throws SQLException
	{
		connection.close();
	}

}
