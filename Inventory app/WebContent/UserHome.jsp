<%@page import="model.Users"%>
<%@page import="service.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.html"></jsp:include>

<%
String empid=(String)session.getAttribute("empid"); 
String msg=(String)request.getAttribute("msg"); 
if(msg==null)
	msg="";
%>
<%=msg%>
<hr>
Welcome : <%=empid%>
<% 
Users u=new UsersDao().getuserDetails(empid);

%>

name:<%=u.getEname() %>
<br>mailid:<%=u.getMailid() %> &nbsp;&nbsp;
contact no:<%=u.getContactno() %>


</body>
</html>