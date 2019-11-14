<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="gbk"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    System.out.println(request.getAttribute("s"));
    System.out.println(request.getParameter("s"));
    System.out.println(request.getParameterMap().size());
    Enumeration<String> e = request.getAttributeNames();
    while(e.hasMoreElements()){
        System.out.println(e.nextElement());
    }
%>
<h2>
    Welcome to "" Login System!
</h2>
This is the first javaWeb Project!
</body>
</html>