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

public class Register extends HttpServlet {
		
	public void doPost(HttpServletRequest req, HttpServletResponse res){
			
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection ;
			
			
			 // create a database connection
		      connection = DriverManager.getConnection("jdbc:sqlite:D:/UserDataBase.db");
		      Statement statement = connection.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.

		     //statement.executeUpdate("drop table if exists User_Database");
		      
		      RequestDispatcher rd =  req.getRequestDispatcher("RegisterError.jsp");
		      
		      		// we create a table if it does not exist's
		      statement.executeUpdate("create table if not exists User_Database (Email string, password string, first_name string, last_name string) ");
		      
		      ResultSet dul = statement.executeQuery("select * from User_Database");
		      
		      
		      // we check if the user already exits
		      boolean isDuplicate = false;
		      while(dul.next()) {
		    	  if(dul.getString("Email").equals(req.getParameter("email"))) {
		    		  	rd.forward(req, res);
		    		  	isDuplicate = true;
		    	  }		    	 
		      }
		      
		      if(!isDuplicate)
		      statement.executeUpdate("insert into User_Database values("+"'"+req.getParameter("email").toString()+"'"+","+"'"+req.getParameter("password").toString()+"'"+","+"'"+req.getParameter("firstname").toString()+"'"+","+"'"+req.getParameter("lastname").toString()+"'"+")");
		   
		      RequestDispatcher red = req.getRequestDispatcher("Home.jsp");
		      red.forward(req, res);
		      
		      
		      //   statement.executeUpdate("insert into User_Database(Email, password) values("+"'"+"sai"+"'"+","+"'"+"password"+"'"+")");
		      
//		      ResultSet rs = statement.executeQuery("select * from User_Database");
//		      while(rs.next())
//		      {
//		        // read the result set
//		        System.out.println("name = " + rs.getString("first_name")+" "+rs.getString("last_name"));
//		        System.out.println("email = " + rs.getString("Email"));
//		        System.out.println("password = "+ rs.getString("password"));
//		      }
	
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
