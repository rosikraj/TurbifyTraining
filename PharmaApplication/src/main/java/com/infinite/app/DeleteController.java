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
public class DeleteController {
	Connection con = null;
	@RequestMapping("/delete")
	public String deleterecord (HttpServletRequest request, HttpServletResponse response) {
		
		String modelno = request.getParameter("codeno");//getting user values
		//getting connection to database 
		
		try {
			//statement to delete values
			DataSource datasource = HikariCPTest.getDataSource();
			con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from pharma where codeno = ?");
			ps.setString(1, modelno);
			int x = ps.executeUpdate();
			if (x!=0) {
				//condition for user entered correct values in table or not
				return "deleted";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally{
		 }

				try{

					con.rollback();

				}catch(Exception e){

					e.printStackTrace();

				}
		return "delete";
	}

}
