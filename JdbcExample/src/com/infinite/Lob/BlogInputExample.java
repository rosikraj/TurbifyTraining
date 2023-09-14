package com.infinite.Lob;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BlogInputExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection on = null;
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Step1 loading the driver
			on =DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
			System.out.println("connetion established to database succefully");
			PreparedStatement ps=on.prepareStatement("insert into imgtable values(?,?)");  
			ps.setString(1,"sonoo");
			
			FileInputStream fin=new FileInputStream("D:\\images\\inputs.png");  
			ps.setBinaryStream(2,fin,fin.available());  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
	}
		catch(SQLException e1)
		{
			System.out.println(e1);
		}
 
        catch(Exception e)
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
