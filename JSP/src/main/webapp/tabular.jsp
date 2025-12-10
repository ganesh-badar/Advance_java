<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

<style>
    table {
        width: 60%;
        border-collapse: collapse;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid black;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: lightgray;
    }
</style>

</head>
<body>

<h2 align="center">User Information Table</h2>

<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
    </tr>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userlogin?useSSL=false", "root", "Ganesh@1351");

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM login");

    while (rs.next()) {
%>

    <tr>
        <td><%= rs.getString("uname") %></td>
        <td><%= rs.getString("pwd") %></td>
    </tr>

<%
    }

    rs.close();
    stmt.close();
    con.close();

} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>

</table>

</body>
</html>
