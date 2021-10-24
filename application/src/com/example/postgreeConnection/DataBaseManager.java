package com.example.postgreeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseManager {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public DataBaseManager() {
		
	}
	
	Connection connectToDatabase() {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "123abc");	
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("The connection to postgreesql wasn't accoured sucessfully!");
			}
			return null;
	}
	
	public boolean executeStatement(String sqlQuery) {
		try {
			statement = connectToDatabase().createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Query runned sucessfully!");
			closeAll();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void closeAll() {
		try {
			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("-- One close operation occured an error! --");
		} catch(NullPointerException e) {
			//execute when connection, statement or resultSet cannot 
			//be closed, because it not have a connection activated!
		}
	}
	
	public void showAll() {
		try {
			connectToDatabase().setAutoCommit(false);
			statement = connectToDatabase().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CUSTOMERS;");
			
			printInformationsFromTable(resultSet);
			
			closeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Occured an error in read something from postgree database!");
		}
	}
	
	private void printInformationsFromTable(ResultSet resultSet) throws SQLException {
			while (resultSet.next()) {
			    int id = resultSet.getInt("id");
			    String  name = resultSet.getString("name");
			    int age  = resultSet.getInt("age");
			    String  address = resultSet.getString("address");
			    float salary = resultSet.getFloat("salary");
			    
			    printTableInformations(id, name, age, address, salary);
			}
	}
	
	private void printTableInformations(int id, String name, int age, String address, float salary) {
		System.out.println(tablePromptFormating(id, name, age, address, salary));
	}
	
	private String tablePromptFormating(int id, String name, int age, String address, float salary) {
		return String.format("ID = %d\n"
							+"NAME = %s\n"
							+"AGE = %d\n"
							+"ADDRESS = %s\n"
							+"SALARY = %.2f\n",
							id, name, age, address, salary);
	}
	
	
}
