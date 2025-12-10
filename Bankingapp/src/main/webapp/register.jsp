<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?useSSL=false","root","Ganesh@1351");
PreparedStatement pst = con.prepareStatement(
        "INSERT INTO registeruser(uid, password, username, accno, amount) VALUES (?, ?, ?, ?, ?)"
    );
pst.setString(1,request.getParameter("uid"));
pst.setString(2,request.getParameter("pwd"));
pst.setString(3,request.getParameter("uname"));
pst.setString(4,request.getParameter("accno"));
pst.setString(5,request.getParameter("amt"));
pst.executeUpdate();
out.println("<h2>User Registration is completed...</h2>");
%>
<jsp:forward page="login.html" />
<% 
con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}
%>
</body>
</html>