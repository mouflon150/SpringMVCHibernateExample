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
    <title>Student Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">List Students</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Email</th>
        <th scope="col">Study Format</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>
                <a href="/findStudent/${student.id}">${student.firstName}</a>
            </td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.studyFormat}</td>
            <td>
                <form action="/editStudent/${student.id}" method="get">
                    <button style="background-color: blue" type="submit">UPDATE</button>
                </form>
                <form action="/deleteStudent/${student.id}" method="get">
                    <button style="background-color: red" type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/studentForm" method="get">
    <button style="background-color: white" type="submit">ADD-TEACHER</button>
</form>
<%--<form action="/clearStudents" method="get">--%>
<%--    <button style="background-color: white" type="submit">CLEAR</button>--%>
<%--</form>--%>
<form action="/groups" method="get">
    <button style="background-color: white" type="submit">BACK</button>
</form>
</body>
</html>