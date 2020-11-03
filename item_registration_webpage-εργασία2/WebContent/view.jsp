<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="test.*"%>
<jsp:useBean id="db" class="test.RegisterDao" scope="page"/>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Item</title>
</head>
<%
	Member m = new Member();
	m = db.getLatestProduct();
%>

<h1>Data entered successfully!</h1>.
<br/><br/>

 <table border="1" width="100%">
<tr>
   <th>Barcode:  <%= m.getBarcode() %></th>
   <th>Name: <%= m.getName() %></th>
   <th>Color: <%= m.getColor() %> </th>
   <th>Description: <%= m.getDescription() %> </th>
   
</tr>

</body>
</html>