package com.infinite.app;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

 

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

 

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.infinite.datasource.HikariCPTest;

 

@Controller

public class LoginController {

 

	@RequestMapping("/login")

	public String login(HttpServletRequest request,HttpServletResponse response){

		Connection con=null;

		String user=request.getParameter("username");

		String pass=request.getParameter("password");

		PreparedStatement ps=null;

		ResultSet rs=null;

		try{

			DataSource datasource=HikariCPTest.getDataSource();

			con=datasource.getConnection();

			ps=con.prepareStatement("Select * from login where username=?");

			ps.setString(1, user);

			rs=ps.executeQuery();

			while(rs.next()){

			if(rs.getString(1).equals(user)){

				if(rs.getString(2).equals(pass)){	

					return "login";

				}

				else{

					return "invalid";

				}

			}

				else{

					return "invalid";

				}

			}

		}

			catch(SQLException e){

			e.printStackTrace();

		}finally{

			try{

				con.rollback();

			}catch(Exception e){

				e.printStackTrace();

			}

		}

		return "invalid";

	}

}
