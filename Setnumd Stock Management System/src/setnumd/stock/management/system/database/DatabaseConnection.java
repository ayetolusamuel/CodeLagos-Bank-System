package setnumd.stock.management.system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public ResultSet resultSet;
	public Connection connection;
	
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public static PreparedStatement getPs() {
		return ps;
	}
	public static void setPs(PreparedStatement ps) {
		DatabaseConnection.ps = ps;
	}
	public Statement statement;
	static PreparedStatement ps=null;
	
	public void open() {

		String msAccDB = "databases//setnumdstocks.accdb";
		String dbURL = "jdbc:ucanaccess://" + msAccDB;
		try {
			connection = DriverManager.getConnection(dbURL
					+ ";jackcessOpener=setnumd.stock.management.system.database.CryptCodecOpener", "", "brem");
			//System.out.println("Connetced");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
	}
			public void close()
			{
				try
				{
					statement.close();
					connection.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		
		
	
}
