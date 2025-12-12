<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String nm = (String)session.getAttribute("uname"); 
%>
<h2>user name : <%=nm %></h2>
</body>
</html> 