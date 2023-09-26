package com.infinite.Coding2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Company_Details
 */
public class Company_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection on = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ServletConfig cg = getServletConfig();
			Class.forName(cg.getInitParameter("mysql"));
			on = DriverManager.getConnection(cg.getInitParameter("mysqlurl"), cg.getInitParameter("mysqlusername"),
					cg.getInitParameter("mysqlpassword"));
			//Statement st=on.createStatement();
			//Scanner s=new Scanner(System.in);
			PreparedStatement ps=on.prepareStatement("Insert into Company value(?,?,?,?,?);");
			ps.setString(1,request.getParameter("companyname"));
			ps.setInt(2,Integer.valueOf(request.getParameter("address")));
			ps.setInt(3,Integer.valueOf(request.getParameter("No_of_employees")));
			ps.setString(4,request.getParameter("status"));
			ps.setString(4,request.getParameter("country"));
			ps.executeUpdate();
			ps.close();
			response.sendRedirect("Success.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try{
				on.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	}


