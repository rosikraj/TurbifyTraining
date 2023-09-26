package com.infinite.security;

import java.io.FileReader;

 import java.io.IOException;

 import java.io.InputStream;

 import java.io.PrintWriter;

 import java.sql.DriverManager;

 import java.sql.PreparedStatement;

 import java.sql.ResultSet;

 import java.sql.Statement;

 import java.util.Properties;

 

import javax.servlet.ServletException;

 import javax.servlet.annotation.WebServlet;

 import javax.servlet.http.HttpServlet;

 import javax.servlet.http.HttpServletRequest;

 import javax.servlet.http.HttpServletResponse;

 

import org.apache.log4j.Logger;

 

import com.infinite.security.JavaSecurity;

 import com.sun.corba.se.pept.transport.Connection;

 

import com.infinite.security.*;

 

/**

 * Servlet implementation class Inserttocompany

 */

 
 @WebServlet("/Inserttocompany")

 public class Inserttocompany extends HttpServlet {

 	private static final Logger logger = Logger.getLogger(Inserttocompany.class);

 	private static final long serialVersionUID = 1L;

 

	// static Connection con=null;

 	/**

 	 * @see HttpServlet#HttpServlet()

 	 */

 	public Inserttocompany() {

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

 		// response.getWriter().append("Served at:

 		// ").append(request.getContextPath());

 	}

 

	/**

 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse

 	 *      response)

 	 */

 	/*

 	 * (non-Javadoc)

 	 * 

 	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.

 	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)

 	 */

 	/*

 	 * (non-Javadoc)

 	 * 

 	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.

 	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)

 	 */

 	protected void doPost(HttpServletRequest request, HttpServletResponse response)

 			throws ServletException, IOException {

 		// TODO Auto-generated method stub

 		java.sql.Connection con = null;

 		PrintWriter out = response.getWriter();

 		try {

 			InputStream inStream = Thread.currentThread().getContextClassLoader()

 					.getResourceAsStream("mysqldb.properties");

 			Properties pr = new Properties();

 			pr.load(inStream);

 			response.setContentType("text/html");


 			out.println("<html><body>");

 			out.println("<h3>Company Details<h3>");

 			out.println("<table border=1><tr>" + "<td><b>Comapany Name</b></td>" + "<td><b>Address </b></td>"

 					+ "<td><b>Country </b></td>" + "<td><b>No.of.employees </b></td>" + "<td><b>Status </b></td>");

 			Class.forName("com.mysql.jdbc.Driver");// driver loaded

 			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");

 					//Javasecurity.decrypt(pr.getProperty("name"), "qwe123"),

 					//Javasecurity.decrypt(pr.getProperty("password"), "qt123"));

 			// connection establised

 			PreparedStatement pd = ((java.sql.Connection) con)

 					.prepareStatement("insert into company values(?,?,?,?,?)");

 

			pd.setString(1, request.getParameter("companyname"));

 			pd.setString(2, request.getParameter("address"));
 			
 			pd.setInt(3, Integer.parseInt(request.getParameter("No_of_employees")));

 			pd.setString(4, request.getParameter("status"));
 			
 			pd.setString(5, request.getParameter("country"));

 			

 			

 			pd.executeUpdate();// excuting

 			Statement st = con.createStatement();

 			// displaying table data

 			st.executeQuery("select * from company;");

 			ResultSet rs = st.getResultSet();

 

			while (rs.next()) {

 				out.println("<tr>" + "<td>" + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"

 						+ "<td>" + rs.getInt(3) + "</td>" + "<td>" + rs.getString(4) + "</td>" + "<td>"

 						+ rs.getString(5) + "</td>");

 			}

 			out.println("</table></body></html>");

 		} catch (Exception e) {

 			out.println(e);

 		} finally {

 			try {

 				con.close();

 			} catch (Exception e) {

 				out.println(e);

 			}

 		}

 	}

 

}
