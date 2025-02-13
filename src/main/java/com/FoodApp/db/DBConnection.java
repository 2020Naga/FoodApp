package com.FoodApp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String username = "root";
	private static final String pwd = "root";
	
	private static Connection con = null;
	
	public static Connection getconnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			con=DriverManager.getConnection(url, username, pwd);
			System.out.println(con);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		return con;
	}
}
