package com.infinite.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infinite.datasource.HikariCPTest;

@Controller
public class InsertController {
	Connection con = null;

	@RequestMapping("/insert")
	public String insertrecord(HttpServletRequest request, HttpServletResponse response) {
		String medicine = request.getParameter("medicine");
		String expiredate = request.getParameter("expiredate");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int codeno = Integer.parseInt(request.getParameter("codeno"));
		
		
		// getting connection to database
		
		try {
			// statement to insert values
			DataSource datasource = HikariCPTest.getDataSource();
			con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into pharma values(?,?,?,?,?)");
			ps.setString(1, medicine);
			ps.setString(2, expiredate);
			ps.setInt(3, cost);
			ps.setInt(4, quantity);
			ps.setInt(5, codeno);
			int x = ps.executeUpdate();
			if (x != 0) { // condition for inserting values into  the table

				return "inserted";
			}
			}

		 catch (SQLException e) {
			 e.printStackTrace();
		 }
			 finally{
		 }

				try{

					con.rollback();

				}catch(Exception e){

					e.printStackTrace();

				}

		return "insert";
	
		
}
}