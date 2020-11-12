<!DOCTYPE HTML>
<html>
<head>
  <title>Register Form</title>
</head>
<body>

<h1>Item Registration</h1>.
 <form action="InsertItemServlet" method="POST">
  <table>
  	
   <tr>
    <td>Barcode :</td>
    <td><input type="text" name="barcode" required></td>
   </tr>
   <tr>
    <td>Name :</td>
    <td><input type="text" name="name" required></td>
   </tr>
   
   <tr>
    <td>Color :</td>
    <td><input type="text" name="color" required></td>
   </tr> 
   
   <tr>
    <td>Description :</td>
    <td><input type="text" name="description" required></td>
   </tr>
   
    <td><input type="submit" value="Submit"></td>
   </tr>
  </table>
 </form>
</body>
</html>