package com.example.postgreeConnection;

public final class SqlBuilder {
	
	public SqlBuilder() {
	}
	
	//prepared statement throws errors by doing methods below, $1 for example
	//the reason I use use this strings forms
	
	public String createTable() {
		String query = String.format("CREATE TABLE IF NOT EXISTS CUSTOMERS " +
				"(ID INT PRIMARY KEY	NOT NULL," +
				" NAME           TEXT	NOT NULL, " +
				" AGE            INT	NOT NULL, " +
				" ADDRESS        CHAR(50), " +
				" SALARY         REAL);");
		
		return query;
	}
	
	public String insertInto(String tableName, int id, String name, int age, String address, double salary) {
		String query = String.format("INSERT INTO %s(id, name, age, address, salary)"
								+"VALUES(%d, '%s', %d,'%s', %.2f);"
								, tableName, id, name, age, address, salary);
		
		return query;
	}
	
	public String updateColumn(String tableName, String columnName, String data, int id) {
		String query = String.format("UPDATE %s "
				+ "SET %s= '%s' "
				+ "WHERE ID=%d;", tableName, columnName, data, id);
		
		return query;
	}

	public String dropTable(String tableName) {
		String query = String.format("DROP TABLE IF EXISTS %s;", tableName);
		return query;
	}
	
	@SuppressWarnings("unused")
	private String createDatabase(String databaseName) {
		String query = null;
		return query;
	}
	
	@SuppressWarnings("unused")
	private String dropDatabase(String databaseName) {
		String query = null;
		return query;
	}
}
