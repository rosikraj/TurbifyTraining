package com.infinite.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_update {
		public static void main(String[] args)
		{
			// TODO Auto-generated method stub
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//Step1 loading the driver
				Connection on=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
				System.out.println("connetion established to database succefully");
				Statement stmt =(Statement) on.createStatement();//create statement
				stmt.executeUpdate("Update employee set idno=109 where fullname ='rosik' ");
				System.out.println("Update row from employee table");
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
