package codelagos.bank.system2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private ResultSet resultSet;
	private Connection connection;
	private Statement statement;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Statement getStatement() {
        return statement;
    }
	static PreparedStatement ps=null;
	
	public void open() {

		String msAccDB = "database//codelagos_bank_system.accdb";
		String dbURL = "jdbc:ucanaccess://" + msAccDB;
		try {
			connection = DriverManager.getConnection(dbURL
					+ ";jackcessOpener=codelagos.bank.system2.CryptCodecOpener", "", "codelagos");
			//System.out.println("Connected");
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

    public Connection getConnection() {
        return connection;
    }

}
