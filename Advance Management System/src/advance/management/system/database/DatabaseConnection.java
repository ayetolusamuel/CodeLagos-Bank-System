package advance.management.system.database;

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

		String msAccDB = "database//database.accdb";
		String dbURL = "jdbc:ucanaccess://" + msAccDB;
		try {
			connection = DriverManager.getConnection(dbURL
					+ ";jackcessOpener=advance.management.system.database.CryptCodecOpener", "", "setnumd");
			System.out.println("Connected");
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
