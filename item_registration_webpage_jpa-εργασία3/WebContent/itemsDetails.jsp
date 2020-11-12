<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Item Registration</title>
   </head>
   <body>
      <%@ page import="java.util.List,hibernate.entity.*" %>
      <h3> Item's Details </h3>
      <%
         List<Item> items = (List<Item>)request.getAttribute("items");
       %>
      <h4> Item registered  </h4>
      <table border="1">
         <tr>
           <td>BARCODE </td> <td> NAME </td> <td> COLOR </td> <td>DESCRIPTION</td>
         </tr>
          <%
           
           Item item = items.get(items.size()-1) ;    
          %>
         <tr> 
           
           <td><%= item.getBarcode() %></td>
           <td><%= item.getName() %></td>
           <td><%= item.getColor() %></td>
           <td><%= item.getDescription() %></td>
           
         </tr>
        
     </table>
    </body>
</html>