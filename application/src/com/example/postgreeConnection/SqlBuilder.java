package com.example.postgreeConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class SqlBuilder {
	
	private DataBaseManager dbManager = new DataBaseManager();
	private PreparedStatement preparedStatement = null;
	
	public SqlBuilder() {
	}
	
	
	/**
	 * This method throws org.postgresql.util.PSQLException: 
	 * ERROR: syntax error at or near "$1" 
	 *
	 * I Will try to concat the string
	 */
	public void insertInto(int id, String name, int age, String address, double salary) {
		String query = "INSERT INTO CUSTOMERS(?, ?, ?, ?, ?)";		
		
		try {
			preparedStatement = dbManager.connectToDatabase().prepareStatement(query);
			//preparedStatement.setString(1, tableName);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, address);
			preparedStatement.setDouble(5, salary);
			
			preparedStatement.executeUpdate();//automatically use that query above
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String insertInto2(String tableName, int id, String name, int age, String address, double salary) {
		String query = String.format("INSERT INTO %s(id, name, age, address, salary)\n"
									+"VALUES(%d, '%s', %d,'%s', %.2f);"
									, tableName, id, name, age, address, salary);
		
		return query;
	}

	
}
