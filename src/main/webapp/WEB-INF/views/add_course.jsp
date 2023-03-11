<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Add Course</h1>
<form action="/courses/addCourse" method="post">
    <div class="form-group">
        <label for="courseName">Course name</label>
        <input class="form-control" name="courseName" id="courseName" aria-describedby="courseName"
               placeholder="Enter course name">
    </div>
    <div class="form-group">
        <label for="duration">Duration</label>
        <input type="text" class="form-control" name="duration" id="duration" placeholder="Enter duration">
        <c:forEach items="${companyId}" var="company">
            <input type="radio" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.companyName}</label>
        </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary" value="add_course">Submit</button>
</form>
</body>
</html>
