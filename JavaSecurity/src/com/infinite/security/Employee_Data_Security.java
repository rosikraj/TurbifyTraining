package com.infinite.security;

import java.io.FileReader;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Properties;

import java.util.Scanner;
import com.infinite.security.JavaSecurity;

 

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

 

public class Employee_Data_Security {

    private static final Logger logger = Logger.getLogger(Employee_Data_Security.class);

 

    public static void main(String[] args) {

        Properties pr = null;

        FileReader fr = null;

        Connection conn = null;

        PropertyConfigurator.configure("Log4j.properties");

 

        try {

            fr = new FileReader("mysql.properties");

            pr = new Properties();

            pr.load(fr);

        } catch (Exception e) {

            e.printStackTrace();

        }

 

        try {

            Class.forName(pr.getProperty("drivername"));

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training",

                    JavaSecurity.decrypt("username", "Rosik"), JavaSecurity.decrypt("password", "rosik"));

 

            Scanner sc = new Scanner(System.in);

            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)");

 

            logger.info("Enter fullName:");

            ps.setString(1, sc.next());

 

            logger.info("Enter idno:");

            ps.setInt(2, sc.nextInt());

 

            logger.info("Enter department:");

            ps.setString(3, sc.next());

 

            logger.info("Enter gender:");

            ps.setString(4, sc.next());

 

            int status = ps.executeUpdate();

 

            if (status == 1)

                logger.info("Record inserted Successfully");

            else

                logger.info("Record Failed");

 

        } catch (SQLException | ClassNotFoundException e1) {

            logger.error(e1);

        } finally {

            try {

                if (conn != null)

                    conn.close();

            } catch (SQLException e1) {

                e1.printStackTrace();

            }

        }

    }

}