package com.infinite.wallet;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

@WebServlet("/showBalance")

public class ShowBalanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accountIdParam = request.getParameter("id");

        PrintWriter out = response.getWriter();

 

        if (accountIdParam != null && !accountIdParam.isEmpty()) {

            int accountId = Integer.parseInt(accountIdParam);

            double balance = getBalanceFromDatabase(accountId);

 

            if (balance != -1) {

                out.println("Account id: " + accountId);

                out.println("Balance: $" + balance);

            } else {

                out.println("Account not found for ID: " + accountId);

            }

        } else {

            out.println("Invalid account ID.");

        }

    }

 

    private double getBalanceFromDatabase(int accountId) {

        double balance = -1;

 

        // Replace with your actual database connection details

        String jdbcURL = "jdbc:mysql://localhost:3306/wallet_app";

        String username = "root";

        String password = "mysql@123";

 

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {

            String sql = "SELECT balance FROM accounts WHERE id = ?";

            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                preparedStatement.setInt(1, accountId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    balance = resultSet.getDouble("balance");

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

 

        return balance;

    }

}