package com.infinite.controllers;

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
public class LoginController {

	@RequestMapping(value="info",method=RequestMethod.POST)

		public String show() {

			return "traindetails";

		}
	

	Connection con = null;
	PreparedStatement ps = null;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		try {
			DataSource datasource = Hikari.getDataSource();
			con = datasource.getConnection();
			ps = con.prepareStatement("select *from register where username=? and password=?;");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if(rs.getString(3).equals(user))
				{
					if (rs.getString(4).equals(pass))
					{
						return "home";
					} 
					else 
					{
						return "invalid";
					}
				} else
				{
					return "invalid";
				}
		   }

		}

		catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return "invalid";

	}
}
