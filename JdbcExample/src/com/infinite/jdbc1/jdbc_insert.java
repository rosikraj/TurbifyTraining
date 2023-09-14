package com.infinite.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//Step1 loading the driver
				Connection on=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
				System.out.println("connetion established to database succefully");
				Statement stmt =(Statement) on.createStatement();//create statement
				//stmt.executeUpdate("insert into employee(idno,fullname,department,gender) values('33','arun','CSE','male')");
				//stmt.executeUpdate("Delete from employee where idno='333' ");
				System.out.println("insert row from employee table");
				stmt.executeUpdate("Update employee set department='Java Developer' where fullname ='arun' ");
				ResultSet st=stmt.executeQuery("select * from employee");
				
	         	while (st.next())
	         	{
	         		System.out.println(st.getString(1));
					
	         	}
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
