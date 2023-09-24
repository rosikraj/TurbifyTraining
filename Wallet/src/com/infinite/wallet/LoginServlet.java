package com.infinite.wallet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;
import com.infinite.wallet.Database;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn =null;
		//servlet for login function.
		try {
			conn = Database.getMyconnection("mysql");
			int uid=Integer.parseInt(request.getParameter("uid"));
			String password=request.getParameter("password");
			PreparedStatement ps = conn.prepareStatement("select * from accounts where accountID=? and password=?");
			ps.setInt(1,uid);
			ps.setString(2,password);
			ResultSet rt = ps.executeQuery();
			
			if(rt.next()){
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);
				
				response.sendRedirect("main.jsp");
			}
			else{
				response.getWriter().print("Invalid credentials.");
			}
			 }
	catch (SQLException e) {
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
			
	


