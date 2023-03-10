<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 30056685(03)
  Date: 09.03.2023
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">List Courses</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Course Name</th>
        <th scope="col">Duration</th>
        <th scope="col">Teacher</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>
                <a href="/findCourse/${course.id}">${course.courseName}</a>
            </td>
            <td>${course.duration}</td>
            <td>
                <form action="/teachers" method="get">
                    <button type="submit">Teacher</button>
                </form>
            </td>
                <%--            <td>--%>
                <%--                <form action="/" method="get">--%>
                <%--                    <button type="submit">Group</button>--%>
                <%--                </form>--%>
                <%--            </td>--%>
            <td>
                <form action="/editCourse/${course.id}" method="get">
                    <button style="background-color: blue" type="submit">UPDATE</button>
                </form>
                <form action="/deleteCourse/${course.id}" method="get">
                    <button style="background-color: red" type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/courseForm" method="get">
    <button style="background-color: white" type="submit">ADD-COURSE</button>
</form>
<%--<form action="/clearCourses" method="get">--%>
<%--    <button style="background-color: white" type="submit">CLEAR</button>--%>
<%--</form>--%>
<form action="/" method="get">
    <button style="background-color: white" type="submit">BACK</button>
</form>
</body>
</html>