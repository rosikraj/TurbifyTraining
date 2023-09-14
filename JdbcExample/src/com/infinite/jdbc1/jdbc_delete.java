package com.infinite.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_delete {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Step1 loading the driver
			Connection on=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
			System.out.println("connetion established to database succefully");
			Statement stmt =(Statement) on.createStatement();//create statement
			stmt.executeUpdate("Delete from employee where idno='890' ");
			System.out.println("delete row from employee table");
			on.close();
		}
		catch(SQLException e1)
		{
			System.out.println(e1);
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

}
}
