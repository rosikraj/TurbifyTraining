package com.infinite.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.db.Hikari;

@Controller
public class TrainDetails {
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String details(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		System.out.println(source);
		System.out.println(destination);
		System.out.println("details");
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DataSource datasource = Hikari.getDataSource();
			con = datasource.getConnection();
			ps1 = con.prepareStatement("select * from traindetails");
			// ps.setString(1,source);
			// ps.setString(2,destination);
			rs = ps1.executeQuery();
			out.println("<html><body>");
			out.println("<h3>Train Details<h3>");
			out.println("<table border=1>" + "<tr>" + "<td><b>" + "TrainId" + "</b></td>" + "<td><b>" + "Source"
					+ "</b></td>" + "<td><b>" + "Destination" + "</b></td>" + "<td><b>" + "TrainName" + "</b></td>"
					+ "<td><b>" + "ScheduledlArrivalTime" + "</b></td>" + "<td><b>" + "ExpectedArrivalTime"
					+ "</b></td>" + "</tr>");
			while (rs.next()) {
				System.out.println("1");
				if (rs.getString(3).equalsIgnoreCase(destination)) {
					System.out.println("2");
					if (rs.getString(2).equalsIgnoreCase(source)) {
						System.out.println("3");
						PreparedStatement ps2 = con
								.prepareStatement("select * from traindetails where source=? and destination=?");
						ps2.setString(1, source);
						ps2.setString(2, destination);
						ResultSet rss = ps2.executeQuery();
						if (rss != null) {
							while (rss.next()) {
								System.out.println("IF");
								out.println("<tr>" + "<td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>"
										+ rs.getString(3) + "</td>" + "<td>" + rs.getString(4) + "</td>" + "<td>" + rs.getTime(5)
										+ "</td>" + "<td>" + rs.getTime(6) + "</td>" + "</tr>");
							}
						}
						out.println("</body></html>");
					} else if (rs.getString(5).equalsIgnoreCase(source)) {
						System.out.println("4");
						PreparedStatement ps3 = con
								.prepareStatement("select * from traindetails where Source=? and Destination=?");
						ps3.setString(1, source);
						ps3.setString(2, destination);
						ResultSet rsv = ps3.executeQuery();
						if (rsv != null) {
							System.out.println("5");
							while (rsv.next()) {
								System.out.println("IF");
								out.println("<tr>" + "<td>" + rsv.getString(1) + "</td>" + "<td>" + rsv.getString(2)
										+ "</td>" + "<td>" + rsv.getString(5) + "</td>" + "<td>" + rsv.getString(4)
										+ "</td>" + "<td>" + rsv.getString(8) + "</td>" + "<td>" + rsv.getString(7)
										+ "</td>" + "</tr>");
							}
						}
						out.println("</body></html>");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
