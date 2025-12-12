<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

</head>
<body>



<table  border="2" width="50%" align="center">
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
    out.println(e);
}
%>

</table>

</body>
</html>
