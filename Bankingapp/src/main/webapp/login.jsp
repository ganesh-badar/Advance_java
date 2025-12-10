<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
	String id = request.getParameter("uid");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?useSSL=false","root","Ganesh@1351");
	PreparedStatement pst = con.prepareStatement("select * from registeruser where uid=? and password=?");
	pst.setString(1, id);
	pst.setString(2,request.getParameter("pwd"));
	ResultSet rs=pst.executeQuery();
	if(rs.next())
	{
		%>
		<form action="validate.jsp" method="post">
		<input type="hidden" name="uid" value="<%=id %>">
		Account No<input type="text" name="accno">
		<input type="submit" value="Print Balance">
		</form>
		<%	
	}
	else
	{
		out.println("<h2>Sorry..User is not present... </h2>");
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








