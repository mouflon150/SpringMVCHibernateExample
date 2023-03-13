<%--
  Created by IntelliJ IDEA.
  User: 30056685(03)
  Date: 11.03.2023
  Time: 1:14
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
<h1>Update Student</h1>
<form action="/updateStudent/${student.id}" method="post">
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input class="form-control" name="firstName" id="firstName" aria-describedby="firstName"
               placeholder="Enter first name">
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter last name">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
        <label for="studyFormat">Study Format</label>
        <input type="text" class="form-control" name="studyFormat" id="studyFormat" placeholder="Enter study format">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
