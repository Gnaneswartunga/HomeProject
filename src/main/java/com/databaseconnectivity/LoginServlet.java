package com.databaseconnectivity;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	//taking input from user
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Perform database validation
        boolean isValidUser = DataBaseActions.validateUser(username, password);
        //boolean userType = DataBaseActions.userType(username);
        
        // Redirect based on validation result
        if (isValidUser) {
        		response.sendRedirect("home.html");
        } else {
            response.sendRedirect("welcome.html");
        }
    }

}

