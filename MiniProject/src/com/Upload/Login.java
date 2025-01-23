package com.Upload;

import java.sql.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
		
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		// we get email and password 
		
		String email = req.getParameter("lemail").toString();
		String password = req.getParameter("lpassword").toString();
		
		try {
			
			if(email == null)
				return;
			Class.forName("org.sqlite.JDBC");
			
			Connection connection;
			
			connection = DriverManager.getConnection("jdbc:sqlite:D:/UserDataBase.db");
			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			ResultSet st = statement.executeQuery("Select password from User_DataBase where Email="+"'"+email+"'");
			
			String db_password = st.getString("password");
			
			
			
			if(password.equals(db_password)) {
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
				rd.forward(req,res);
			}
			else {
				RequestDispatcher rs = req.getRequestDispatcher("LoginError.jsp");
				rs.forward(req,res);
			}
				
				
		}
		
		catch(Exception ex){
				ex.printStackTrace();
		}
	}
}
