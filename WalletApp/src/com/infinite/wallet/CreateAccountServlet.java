package com.infinite.wallet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.io.IOException;


/**
 * Servlet implementation class CreateAccountServlet
 * 
 */
@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException{
	String accountHolderName = request.getParameter("accountHolderName");
	double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));
	
	try (Connection conn = DBUtil.getConnection()) {
		
		//Insert account information into the database
		
		String sql = "INSERT INTO accounts (account_holder_name,balance) VALUES (?,?)";
		try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.setString(1, accountHolderName);
			preparedStatement.setDouble(2, initialBalance);
			preparedStatement.executeUpdate();
		}
		
		
	} catch (SQLException e){
		e.printStackTrace();
	}
	response.getWriter().println("Account created successfully for " + accountHolderName);
		
	}
	}
	
	


