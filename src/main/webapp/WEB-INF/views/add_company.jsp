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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Add Company</h1>
<form action="/addCompany" method="post">
    <div class="form-group">
        <label for="companyName">Company name</label>
        <input class="form-control" name="companyName" id="companyName" aria-describedby="companyName"
               placeholder="Enter company name">
    </div>
    <div class="form-group">
        <label for="locatedCountry">Located country</label>
        <input type="text" class="form-control" name="locatedCountry" id="locatedCountry" placeholder="Enter located country">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
