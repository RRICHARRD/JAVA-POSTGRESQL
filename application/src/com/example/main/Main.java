package com.example.main;

import com.example.postgreeConnection.DataBaseManager;
import com.example.postgreeConnection.SqlBuilder;

public final class Main {
	
	public static void main(String args[]) {
		
		DataBaseManager dbManager = new DataBaseManager();
		SqlBuilder sqlBuilder = new SqlBuilder();
		
		dbManager.executeStatement(sqlBuilder.dropTable("CUSTOMERS"));
		dbManager.executeStatement(sqlBuilder.createTable());
		dbManager.executeStatement(sqlBuilder.insertInto("CUSTOMERS", 1, "RICHARD", 20, "AV. PAULISTA", 18000.00));
		dbManager.executeStatement(sqlBuilder.insertInto("CUSTOMERS", 2, "RICARDO", 20, "AV. SANTISTA", 81000.00));
		dbManager.executeStatement(sqlBuilder.updateColumn("CUSTOMERS", "NAME", "LANCELOT", 1));
		
		dbManager.showAll();
	
	}
}
