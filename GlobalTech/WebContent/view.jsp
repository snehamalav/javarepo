<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><th>eid /name</th> <th>lname</th> <th>password</th><th>contactno</th><th>gender</th><th>email</th><th>dname</th></tr>
<%
List<Employee> plist=(List<Employee>)request.getAttribute("plist");
for(Employee e:plist)
{
%>
<tr>
<td><%=e.getEid() %> </td>
 <td><%=e.getFname() %></td>
<td><%=e.getLname() %></td>
<td><%=e.getPassword() %></td>
<td><%=e.getContactno() %></td>
<td><%=e.getGender() %></td>
<td><%=e.getEmail() %></td>
<td><%=e.getDname() %></td></tr>
<%
}
%>
</table>
</body>
