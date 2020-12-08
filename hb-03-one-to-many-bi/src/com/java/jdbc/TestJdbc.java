package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String userId = "root";
		String pass = "root";
		try {
			System.out.println("connection to db..."+jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl,userId,pass);
			
			System.out.println("Connection successful!!!");
			
			
			
			

		} catch (Exception e) {
e.printStackTrace();
		}
	}

}
