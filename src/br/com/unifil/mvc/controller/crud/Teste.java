package br.com.unifil.mvc.controller.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unifil.mvc.model.User;

public class Teste {

	public static void main(String[] args) {
		
//		User u = new User();
//		u.setNameUser("edisonsahd");
//		u.setPasswordUser("asd123qwe");
//		u.setFullnameUser("Edison Antonio Sahd Filho");
//		u.setEmailUser("edison.sahd@unifil.br");
		
		CRUDUser crud = new CRUDUser();
		try {
			System.out.println(crud.open());
//			System.out.println(crud.create(u));
			
			//ArrayList<User> res = crud.listAll();
			//for(User u : res) {
			//	System.out.printf("%d: %s\n", u.getIdUser(), u.getFullnameUser());
			//}
			
			User u = crud.findById(1);
			System.out.printf("%d: %s\n", u.getIdUser(), u.getFullnameUser());
			
			crud.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
