<%@page import="model.Product"%>
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
<jsp:include page="menu.html"></jsp:include>
<table>
<tr><th>product id/name</th> <th>category</th> <th>stock</th><th>price</th></tr>
<%
 List<Product> plist=(List<Product>)request.getAttribute("plist");
for(Product p:plist)
{
%>
<tr>
<td><%=p.getPid() %> <br> <%=p.getPname() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getStock() %></td>
<td><%=p.getUnitprice() %></td></tr>
<%
}
%>
</table>
</body>
