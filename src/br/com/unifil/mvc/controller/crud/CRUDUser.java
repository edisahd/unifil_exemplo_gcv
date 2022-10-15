package br.com.unifil.mvc.controller.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.unifil.mvc.model.User;

public class CRUDUser {

	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/EXEMPLO_AULA";
	private final String DATABASE_USERNAME = "root";
	private final String DATABASE_PASSWORD = "root";
	
	private Connection connection;
	
	public boolean open() throws SQLException {
		this.connection = DriverManager.getConnection(
				this.DATABASE_URL, 
				this.DATABASE_USERNAME, 
				this.DATABASE_PASSWORD
		);
		return this.connection != null;
	}
	
	public void close() throws SQLException {
		this.connection.close();
	}
	
	public boolean create(User user) throws SQLException {
		String query = "INSERT INTO USER(USER_NAME, USER_PASSWORD, USER_FULLNAME, USER_EMAIL) VALUES (?, ?, ?, ?)";
		
		PreparedStatement stmt = this.connection.prepareStatement(query);
		stmt.setString(1, user.getNameUser());
		stmt.setString(2, user.getPasswordUser());
		stmt.setString(3, user.getFullnameUser());
		stmt.setString(4, user.getEmailUser());
		
		int n_rows = stmt.executeUpdate();
		return n_rows > 0;
	}
	
	public ArrayList<User> listAll() throws SQLException {
		String query = "SELECT * FROM USER";
		
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<User> result = new ArrayList<User>();
		
		while(rs.next()) {
			User tmp = new User();
			tmp.setIdUser(rs.getInt("USER_ID"));
			tmp.setNameUser(rs.getString("USER_NAME"));
			tmp.setPasswordUser(rs.getString("USER_PASSWORD"));
			tmp.setFullnameUser(rs.getString("USER_FULLNAME"));
			tmp.setEmailUser(rs.getString("USER_EMAIL"));
			result.add(tmp);
		}
		return result;
	}
	
}
