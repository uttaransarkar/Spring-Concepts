package com.uttaran.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDemo {

	public static void main(String[] args) {
		
		//db url
		String jdbc_url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		
		String user = "hbstudent";		//db username
		String pass = "hbstudent";		//db password
		
		try {
			System.out.println("Connecting to database: " + jdbc_url);
			
			Connection conn = DriverManager.getConnection(jdbc_url,user, pass);
			
			System.out.println("Connected successfully!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
