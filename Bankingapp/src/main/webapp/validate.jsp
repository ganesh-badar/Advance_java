<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
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
	
	PreparedStatement pst=con.prepareStatement("select amount from registeruser where accno=? and uid=?");
	pst.setString(1, request.getParameter("accno"));
	pst.setString(2,request.getParameter("uid"));
	ResultSet rs=pst.executeQuery();
	if(rs.next())
	{
		%>
		<h4>Balance <%=rs.getInt(1) %></h4>
		<%
	}
	else
	{
		%>
		<h3>Please enter proper account no.</h3>
		<%
	}
	rs.close();
	con.close();
}
catch(Exception ex)
{
	System.out.println(ex);
}
%>
</body>
</html>