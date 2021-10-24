package com.example.main;

import com.example.postgreeConnection.DataBaseManager;
import com.example.postgreeConnection.SqlBuilder;

public final class Main {
	
	private static String createTable = "CREATE TABLE IF NOT EXISTS CUSTOMERS " +
									"(ID INT PRIMARY KEY	NOT NULL," +
									" NAME           TEXT	NOT NULL, " +
									" AGE            INT	NOT NULL, " +
									" ADDRESS        CHAR(50), " +
									" SALARY         REAL)";
	
	private static String insertInformations = "INSERT INTO CUSTOMERS(id, name, age, address, salary)" +
											   "VALUES(1, 'RICHARD', 20, 'AV. PAULISTA', 18000.00)";
	
	private static String dropTable = "DROP TABLE IF EXISTS CUSTOMERS";
	
	public static void main(String args[]) {
		
		DataBaseManager dbManager = new DataBaseManager();
		SqlBuilder sqlBuilder = new SqlBuilder();
		
		dbManager.executeStatement(dropTable);
		dbManager.executeStatement(createTable);
		dbManager.executeStatement(sqlBuilder.insertInto2("CUSTOMERS", 1, "RICHARD", 20, "AV. PAULISTA", 18000.00));
		dbManager.executeStatement(sqlBuilder.insertInto2("CUSTOMERS", 2, "RICARDO", 20, "AV. SANTISTA", 81000.00));
		
		dbManager.showAll();
	
	}
}
