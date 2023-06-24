<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bg.model.User" %>
    <%User auth = (User) request.getSession().getAttribute("auth");
    if(auth!=null)
    {
    	request.setAttribute("auth", auth);
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<h2>hello</h2>

<%@include file="includes/footer.jsp" %>
</body>
</html>