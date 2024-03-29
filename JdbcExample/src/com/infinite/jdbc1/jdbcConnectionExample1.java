package com.infinite.jdbc1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





/**
 * @author karnatir
 *
 */
public class jdbcConnectionExample1 {
	private static final Logger logger

    = Logger.getLogger(jdbcConnectionExample1.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		Connection on = null;
		// TODO Auto-generated method stub
		
			
		
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName(args[0000]);//Step1 loading the driver
			on =DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","mysql@123");//establishing connection
			logger.info("connetion established to database succefully");
			PreparedStatement ps =on.prepareStatement("Insert into employee value(?,?,?,?)");//create statement
			logger.info("fullName");
			ps.setString(1,sc.next());
			logger.info("idno");
			ps.setInt(2,sc.nextInt());
			
			logger.info("department");
			ps.setString(3,sc.next());
			
			logger.info("gender");
			ps.setString(4,sc.next());
			int status = ps.executeUpdate();
			if(status == 1)
				logger.info("Record inserted Successfully");
			else
				logger.info("Record Failed");
			
	         	/*while (st.next())
	         	{
	         		logger.info(st.getString(1));
	         	}*/
		}
		catch(SQLException e1)
		{
			logger.error(e1);
		}
 
        catch(ClassNotFoundException e)
		{
        	logger.error(e);
		}
		finally
		{
			try
			{
				
				
			}catch (Exception e){
				logger.error(e);
			}
		}
		
		
	}

}
