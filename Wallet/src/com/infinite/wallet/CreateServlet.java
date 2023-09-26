package com.infinite.wallet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		//servlet for creating an account.
		try {
			conn = Database.getMyconnection("mysql");
			int a = Integer.parseInt(request.getParameter("accountid"));
			PreparedStatement ps1 = conn.prepareStatement("select accountID from accounts where accountID=?");
			ps1.setInt(1, a);
			rs = ps1.executeQuery();
			while(rs.next()) {
				int aid = rs.getInt("accountID");
				// if account already exists.
				if (aid == a) 
					response.getWriter().print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
							+ "<h1>Account ID already exists!</h1><br>" + "<form action='button.html'>"
							+ "<input type='submit' value='OK'>" + "</form>" + "</center>" + "</boby>" + "</html>");

			}
				
					PreparedStatement ps2 = conn.prepareStatement("insert into accounts values(?,?,?,?)");

					ps2.setString(1, request.getParameter("username"));
					ps2.setString(2, request.getParameter("password"));
					ps2.setInt(3,a);
					ps2.setFloat(4,(float)0.0);
					ps2.executeUpdate();
					
						response.getWriter().print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
								+ "<h1>Account created successfully!!</h1><br>" + "<form action='button.html'>"
								+ "<input type='submit' value='OK'>" + "</form>" + "</center>" + "</boby>" + "</html>");
				
				
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.print(e);
			}
		}
	}

}