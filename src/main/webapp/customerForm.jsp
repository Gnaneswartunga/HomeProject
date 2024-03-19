<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
</head>
<body>
    <h2>Customer Form</h2>
    <form action="AddCustomerServlet" method="post">
        <label for="customer_id">Customer ID:</label><br>
        <input type="text" id="customer_id" name="customer_id"><br>
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="liters">Liters:</label><br>
        <input type="text" id="liters" name="liters"><br>
        <label for="date">Date:</label><br>
        <input type="text" id="date" name="date"><br>
        <label for="month">Month:</label><br>
        <input type="text" id="month" name="month"><br>
        <label for="total_liters">Total Liters:</label><br>
        <input type="text" id="total_liters" name="total_liters"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
