package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	private final String URL = "jdbc:mysql://localhost:3306/lntfinalproject";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	
	private Connection con;
	
	public void Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement ps(String query) throws SQLException {
		return con.prepareStatement(query);
	}
}
