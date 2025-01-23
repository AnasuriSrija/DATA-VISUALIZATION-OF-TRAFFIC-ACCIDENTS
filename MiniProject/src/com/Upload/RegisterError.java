package com.Upload;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterError extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
		PrintWriter out = res.getWriter();
			
		out.println("<h1>Account with this email Already Exists </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
}
