package br.com.unifil.mvc.model;

public class User {

//	+---------------+--------------+------+-----+---------+----------------+
//	| Field         | Type         | Null | Key | Default | Extra          |
//	+---------------+--------------+------+-----+---------+----------------+
//	| USER_ID       | int(11)      | NO   | PRI | NULL    | auto_increment |
//	| USER_NAME     | varchar(50)  | NO   |     | NULL    |                |
//	| USER_PASSWORD | varchar(50)  | NO   |     | NULL    |                |
//	| USER_FULLNAME | varchar(100) | NO   |     | NULL    |                |
//	| USER_EMAIL    | varchar(50)  | NO   |     | NULL    |                |
//	+---------------+--------------+------+-----+---------+----------------+

	private int idUser;
	private String nameUser;
	private String passwordUser;
	private String fullnameUser;
	private String emailUser;
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getNameUser() {
		return nameUser;
	}
	
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	public String getPasswordUser() {
		return passwordUser;
	}
	
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	
	public String getFullnameUser() {
		return fullnameUser;
	}
	
	public void setFullnameUser(String fullnameUser) {
		this.fullnameUser = fullnameUser;
	}
	
	public String getEmailUser() {
		return emailUser;
	}
	
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
}
