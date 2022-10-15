package br.com.unifil.mvc.controller.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
