package com.infinite.wallet;

import com.infinite.wallet.Database;
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

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Withdraw() {
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
		Connection conn = null;
		float withdraw, newbal;
		ResultSet rs;
		//servlet for withdraw function
		try {
			conn = Database.getMyconnection("mysql");
			withdraw = Float.parseFloat(request.getParameter("withdraw"));
			HttpSession session = request.getSession();
			int uid = (Integer) session.getAttribute("uid");
			session.setAttribute("wd", withdraw);
			PreparedStatement ps1 = conn.prepareStatement("select balance from accounts where accountID=?");
			ps1.setInt(1, uid);
			rs = ps1.executeQuery();
			if (rs.next()) {
				float balance = rs.getFloat("balance");

				if (balance >= withdraw) {
					newbal = balance - withdraw;
					session.setAttribute("bal", newbal);
					PreparedStatement ps2 = conn.prepareStatement("update accounts set balance=? where accountID=?");
					ps2.setFloat(1, newbal);
					ps2.setInt(2, uid);
					int a = ps2.executeUpdate();
					if (a != 0) {
						response.getWriter()
								.print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
										+ "<h1>Transaction Successfull</h1><br>" 
										+ "<form action='PrintWithdraw.jsp'>" + "<input type='submit' value='Print'>"
										+ "</form>" + "</center>" + "</boby>" + "</html>");

					}
				} else {
					response.getWriter().print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
							+ "<h1>Insufficient funds!</h1><br>" + "<form action='main.jsp'>"
							+ "<input type='submit' value='OK'>" + "</form>" + "</center>" + "</boby>" + "</html>");
				}
			}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
