<%--
  Created by IntelliJ IDEA.
  User: 30056685(03)
  Date: 11.03.2023
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Company</h1>
<form action="/addCompany" method="post">
    <label>Company name:</label>
    <input type="text" name="companyName">
    <label>Located country:</label>
    <input type="text" name="locatedCountry">
    <input type="submit" value="add_company">
</form>
</body>
</html>
