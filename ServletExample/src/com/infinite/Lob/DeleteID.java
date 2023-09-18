package com.infinite.Lob;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteID
 */
public class DeleteID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection on=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ServletConfig cg = getServletConfig();
			Class.forName(cg.getInitParameter("mysql"));
			on = DriverManager.getConnection(cg.getInitParameter("mysqlurl"), cg.getInitParameter("mysqlusername"),
					cg.getInitParameter("mysqlpassword"));
			PreparedStatement ps=on.prepareStatement("delete from student where stdid=?;");
			ps.setInt(1,Integer.valueOf(request.getParameter("stdid")));
			ps.executeUpdate();
			out.println("<html><body>");
			out.println("<h3>Student Details<h3>");

			out.println("<table border=1><tr>" + "<td><b>full Name</b></td>" + "<td><b>std id</b></td>"+"<td><b>Age</b></td>"+"<td><b>Department</b></td>");
			//out.println("<table border=1><tr>" + "<td><b>age</b></td>" + "<td><b>std id</b></td>");
			//out.println("<table border=1><tr>" + "<td><b>department</b></td>" + "<td><b></b></td>");
			//response.sendRedirect("Deleted.html");
			ResultSet rs=ps.executeQuery("select * from student;");
			while(rs.next())
			{
				String name = rs.getString("fullname");
				int stdid = rs.getInt("stdid");
				int age=rs.getInt("age");
				String department=rs.getString("department");

				out.println("<tr>" + "<td>" + name + "</td>" + "<td>" + stdid + "</td>"+"<td>" + age + "</td>"+"<td>"+department+"</td>"+"</tr>");
			}
			out.println("</table></body></html>");
			ps.close();
			out.close();
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

}
