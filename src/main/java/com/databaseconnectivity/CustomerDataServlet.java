package com.databaseconnectivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerDataServlet")
public class CustomerDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Customer Data</title></head><body>");
        out.println("<table border='1'>"
        		+ "<tr><th>Customer ID</th>"
        		+ "<th>Name</th>"
        		+ "<th>Liters</th>"
        		+ "<th>Date</th>"
        		+ "<th>Month</th>"
        		+ "<th>Total Liters</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "root", "SVECIT50");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer_data");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getInt(3) + "</td><td>" + rs.getDate(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getInt(6) + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
