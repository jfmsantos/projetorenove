package br.com.renowe.persisntecia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static{
	
	try {  
//	    Class.forName("com.mysql.jdbc.Driver");
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	} catch (ClassNotFoundException e) {  
	    e.printStackTrace();  
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	}
	
	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:mysql://mysql.renowe.com.br/renowe_banco","renowe_user","WEB159");
		return DriverManager.getConnection("jdbc:mysql://localhost/renowe_banco","renowe_user","WEB159");
	}
	
	
	public static void retriveConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel conectar ao banco de dados");  
		}
	}	
	
}
