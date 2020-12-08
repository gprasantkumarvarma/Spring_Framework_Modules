package com.java.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variable
		String user="springstudent";
		String pass ="springstudent";
		String jdbc ="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver ="com.mysql.jdbc.Driver";
		
		
		//get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database : "+jdbc);
			
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbc,user,pass);
			
			out.println("/nConnection Successful");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
