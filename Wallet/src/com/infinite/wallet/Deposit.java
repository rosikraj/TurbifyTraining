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
import javax.servlet.http.HttpSession;

import com.infinite.wallet.Database;
/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
		float deposit,newbal;
		ResultSet rs;
		//servlet for deposit function
		try {
			conn = Database.getMyconnection("mysql");
			HttpSession session = request.getSession();
			int uid =(Integer) session.getAttribute("uid");
			deposit = Float.parseFloat(request.getParameter("deposit"));
			PreparedStatement ps1 = conn.prepareStatement("select balance from accounts where accountID=?");
			ps1.setInt(1,uid);
			rs=ps1.executeQuery();
			if(rs.next()){
				float balance = rs.getFloat("balance");
				newbal = balance + deposit;
			session.setAttribute("da", deposit);
			session.setAttribute("bal", newbal);
			PreparedStatement ps2 = conn.prepareStatement("update accounts set balance=? where accountID=?");
			ps2.setFloat(1,newbal);
			ps2.setInt(2,uid);
			int a = ps2.executeUpdate();
			if(a!=0){
					response.getWriter().print(""
							+ "<html>"
							+ "<body bgcolor='Bisque'>"
							+ "<center>"
							+ "<h1>Transaction Successfull</h1><br>"
							+ "<form action='PrintDeposit.jsp'>"
							+ "<input type='submit' value='OK'>"
							+ "</form>"
							+ "</center>"
							+ "</boby>"
							+ "</html>");
				
			}
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
		}	}

}
