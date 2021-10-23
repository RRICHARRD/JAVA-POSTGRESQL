package com.example.main;

import com.example.postgreeConnection.DataBaseManager;

public final class Main {
	
	private static String[] sqlCode = {"CREATE TABLE IF NOT EXISTS CUSTOMERS " +
            "(ID INT PRIMARY KEY	NOT NULL," +
            " NAME           TEXT	NOT NULL, " +
            " AGE            INT	NOT NULL, " +
            " ADDRESS        CHAR(50), " +
            " SALARY         REAL)",
            "Table customers was created sucessfully!"};
	
	private static String[] insertInformations = 
		{"INSERT INTO CUSTOMERS(id, name, age, address, salary)" +
		 "VALUES(1, 'RICHARD', 20, 'AV. PAULISTA', 18000.00)",
		"The informations was inserted sucessfully!"};
	
	private static String[] dropTable = {"DROP TABLE IF EXISTS CUSTOMERS",
	                              "Table customers was drop sucessfully!"};
	
	public static void main(String args[]) {
		
		DataBaseManager dbManager = new DataBaseManager();
		
		dbManager.executeStatement(dropTable);
		dbManager.executeStatement(sqlCode);
		dbManager.executeStatement(insertInformations);
		dbManager.showAll();
	
	}
}
