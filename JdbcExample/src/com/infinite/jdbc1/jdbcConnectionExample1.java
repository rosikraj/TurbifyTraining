package com.infinite.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * @author karnatir
 *
 */
public class jdbcConnectionExample1 {

	public static void main(String[] args) {
		Connection on = null;
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName(args[0000]);//Step1 loading the driver
			on =DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
			System.out.println("connetion established to database succefully");
			PreparedStatement ps =on.prepareStatement("Insert into employee value(?,?,?,?)");//create statement
			System.out.println("fullName");
			ps.setString(1,sc.next());
			System.out.println("idno");
			ps.setInt(2,sc.nextInt());
			
			System.out.println("department");
			ps.setString(3,sc.next());
			
			System.out.println("gender");
			ps.setString(4,sc.next());
			int status = ps.executeUpdate();
			if(status == 1)
				System.out.println("Record inserted Successfully");
			else
				System.out.println("Record Failed");
			
	         	/*while (st.next())
	         	{
	         		System.out.println(st.getString(1));
	         	}*/
		}
		catch(SQLException e1)
		{
			System.out.println(e1);
		}
 
        catch(ClassNotFoundException e)
		{
        	System.out.println(e);
		}
		finally
		{
			try
			{
				on.close();
				
			}catch (Exception e){
				System.out.println(e);
			}
		}
		
	}

}
