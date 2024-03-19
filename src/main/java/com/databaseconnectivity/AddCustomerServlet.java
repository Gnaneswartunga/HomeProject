package com.databaseconnectivity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/eclipse";
        String user = "root";
        String password = "SVECIT50";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO customer_data (customer_id, name, liters, date, month, total_liters) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(request.getParameter("customer_id")));
            statement.setString(2, request.getParameter("name"));
            statement.setInt(3, Integer.parseInt(request.getParameter("liters")));
            statement.setString(4, request.getParameter("date"));
            statement.setString(5, request.getParameter("month"));
            statement.setInt(6, Integer.parseInt(request.getParameter("total_liters")));
            statement.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("customerForm.jsp");
    }
}
