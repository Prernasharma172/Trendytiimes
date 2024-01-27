package com.product.utility;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * this class is exclusively made to create the connection object.
 * All our tables are made in the same database so again and we will have to
 * write the same code for all method in serviceimpl class.
 * 
 * Instead of repeating same code we have written it once in the makeconnection method.
 * 
 *  Whenever we want to create connection to this database we can simply call this method 
 *  from DBconnection class.
 *  
 *  We have made the makeconnection method as static so taht we can directluu call this mrthod fro 
 *  anywhere just by the class name .
 */
public class DBConnection {
	public static Connection makeConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/watchproject","root", "Prer@123");
			
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
		return con;
		
	}
	
	public static void main(String[] args) {
		Connection con= makeConnection();
		
		if(con!=null)
			System.out.println("successful connected ");
		else
			System.out.println("no");
		
		
		
		
		
		
		
	}
}


