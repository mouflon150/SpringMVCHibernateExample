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
    <title>Teacher Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">List Teachers</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Email</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>
                <a href="/findTeacher/${teacher.id}">${teacher.firstName}</a>
            </td>
            <td>${teacher.lastName}</td>
            <td>${teacher.email}</td>
            <td>
                <form action="/editTeacher/${teacher.id}" method="get">
                    <button style="background-color: blue" type="submit">UPDATE</button>
                </form>
                <form action="/deleteTeacher/${teacher.id}" method="get">
                    <button style="background-color: red" type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/teacherForm" method="get">
    <button style="background-color: white" type="submit">ADD-TEACHER</button>
</form>
<form action="/clearTeachers" method="get">
    <button style="background-color: white" type="submit">CLEAR</button>
</form>
<form action="/courses" method="get">
    <button style="background-color: white" type="submit">BACK</button>
</form>
</body>
</html>