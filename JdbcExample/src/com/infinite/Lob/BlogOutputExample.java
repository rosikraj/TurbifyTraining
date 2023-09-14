package com.infinite.Lob;
import java.sql.Blob;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BlogOutputExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection on = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Step1 loading the driver
			on =DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
			System.out.println("connetion established to database succefully");
			PreparedStatement ps=on.prepareStatement("select * from imgtable");  
			ResultSet rs =ps.executeQuery();
			
			if(rs.next())
			{
				Blob b=rs.getBlob(2);
				byte barr[]=b.getBytes(1,(int)b.length());
				FileOutputStream fout=new FileOutputStream("d:\\images\\output.png");
				fout.write(barr);
				System.out.println("record displayed");
				fout.close();
			}
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
