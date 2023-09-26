package com.infinite.servlets;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

 

@WebServlet("/Log4jServlet")

public class Log4jServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LogManager.getLogger(Log4jServlet.class);

 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        logger.debug("This is a debug message.");

        logger.info("This is an info message.");

        logger.warn("This is a warning message.");

        logger.error("This is an error message.");

 

        response.getWriter().append("Log messages written. Check console for output.");

    }

}