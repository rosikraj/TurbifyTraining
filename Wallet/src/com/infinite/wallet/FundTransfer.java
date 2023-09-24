package com.infinite.wallet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infinite.wallet.Database;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FundTransfer
 */
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FundTransfer() {
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
		ResultSet rs1, rs2;
		float newbal1, newbal2;
		//servlet for fund transfer function.
		try {
			conn = Database.getMyconnection("mysql");
			int accountID = Integer.parseInt(request.getParameter("accountid"));
			float amount = Float.parseFloat(request.getParameter("amount"));
			HttpSession session = request.getSession();
			int uid = (Integer) session.getAttribute("uid");
			PreparedStatement ps1 = conn.prepareStatement("select balance from accounts where accountID=?");
			PreparedStatement ps3 = conn.prepareStatement("select balance from accounts where accountID=?");

			ps3.setInt(1, uid);
			rs2 = ps3.executeQuery();
			ps1.setFloat(1, accountID);
			rs1 = ps1.executeQuery();
			if (rs1.next() && rs2.next()) {
				float balance2 = rs2.getFloat("balance");
				float balance1 = rs1.getFloat("balance");
				if (balance2 >= amount) {
					newbal2 = balance2 - amount;
					newbal1 = balance1 + amount;
					session.setAttribute("bal", newbal2);
					session.setAttribute("faid", accountID);
					session.setAttribute("at", amount);
					PreparedStatement ps2 = conn.prepareStatement("update accounts set balance=? where accountID=? ");
					PreparedStatement ps4 = conn.prepareStatement("update accounts set balance=? where accountID=? ");

					ps2.setFloat(1, newbal1);
					ps2.setInt(2, accountID);
					ps4.setFloat(1, newbal2);
					ps4.setInt(2, uid);
					int a = ps2.executeUpdate();
					int b = ps4.executeUpdate();
					if (a != 0 && b != 0) {

						response.getWriter().print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
								+ "<h1>Transaction Successfull</h1><br>" + "<form action='PrintFundTransfer.jsp'>"
								+ "<input type='submit' value='OK'>" + "</form>" + "</center>" + "</boby>" + "</html>");
					} }else {
						response.getWriter().print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>"
								+ "<h1>Insufficient funds!</h1><br>" + "<form action='main.jsp'>"
								+ "<input type='submit' value='OK'>" + "</form>" + "</center>" + "</boby>" + "</html>");
					}
				}
			else {
				response.getWriter()
						.print("" + "<html>" + "<body bgcolor='Bisque'>" + "<center>" + "<h1>No user found!</h1><br>"
								+ "<form action='main.jsp'>" + "<input type='submit' value='OK'>" + "</form>"
								+ "</center>" + "</boby>" + "</html>");
			
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
}
