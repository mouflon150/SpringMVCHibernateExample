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
<h1>Update Company</h1>
<form action="/courses/updateCourse/${course.id}" method="post">
    <div class="form-group">
        <label for="courseName">Course name</label>
        <input class="form-control" name="companyName" id="courseName" aria-describedby="courseName"
               placeholder="Enter course name">
    </div>
    <div class="form-group">
        <label for="duration">Duration</label>
        <input type="text" class="form-control" name="duration" id="duration" placeholder="Enter duration">
    </div>
    <button type="submit" class="btn btn-primary" value="update_course">Submit</button>
</form>
</body>
</html>
