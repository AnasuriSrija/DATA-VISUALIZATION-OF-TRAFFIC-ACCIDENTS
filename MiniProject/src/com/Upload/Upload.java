package com.Upload;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;

public class Upload extends HttpServlet{
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		/*
		 * Connection con = null; PreparedStatement ps = null; PrintWriter out = null;
		 * String username = req.getParameter("username").toString(); String password =
		 * req.getParameter("password").toString(); //System.out.println(password);
		 * String pass = new String(); try{ Class.forName("org.sqlite.JDBC"); out =
		 * res.getWriter(); con =
		 * DriverManager.getConnection("jdbc:sqlite:D:\\test.db"); PreparedStatement
		 * stmt =
		 * con.prepareStatement("SELECT Password FROM UserDataBase WHERE UserName= ?");
		 * stmt.setString(1,username); ResultSet rs; rs = stmt.executeQuery();
		 * 
		 * while(rs.next()) { pass = rs.getString("Password"); if(pass.equals(password))
		 * req.getRequestDispatcher("/Home.jsp").forward(req,res); }
		 * 
		 * } catch(Exception e){ e.printStackTrace(); }
		 */
		
			FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
		    dialog.setMode(FileDialog.LOAD);
		    dialog.setVisible(true);
		    String path = dialog.getDirectory()+dialog.getFile();
		    //System.out.println(path);
			// now process the file
		    // path consists of csv file
		    
		    String command = "ipython D:/MiniProject/MiniProject.py ";
		     
		    Process process = Runtime.getRuntime().exec(command+" "+path);
		    try {
	            int exitValue = process.waitFor();
	            System.out.println("\n\nExit Value is " + exitValue);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}
}
