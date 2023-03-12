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
    <title>Group Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">List Groups</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Group Name</th>
        <th scope="col">Start</th>
        <th scope="col">Finish</th>
        <th scope="col">Students</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="gro up">
        <tr>
            <td>${group.id}</td>
            <td>
                <a href="/findGroup/${group.id}">${group.groupName}</a>
            </td>
            <td>${group.dateOfStart}</td>
            <td>${group.dateOfFinish}</td>
            <td>
                <form action="/" method="get">
                    <button type="submit">Students</button>
                </form>
            </td>
                <%--            <td>--%>
                <%--                <form action="/" method="get">--%>
                <%--                    <button type="submit">Group</button>--%>
                <%--                </form>--%>
                <%--            </td>--%>
            <td>
                <form action="/editGroup/${group.id}" method="get">
                    <button style="background-color: blue" type="submit">UPDATE</button>
                </form>
                <form action="/deleteGroup/${group.id}" method="get">
                    <button style="background-color: red" type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/groupForm" method="get">
    <button style="background-color: white" type="submit">ADD-GROUP</button>
</form>
<form action="/clearGroups" method="get">
    <button style="background-color: white" type="submit">CLEAR</button>
</form>
<form action="/" method="get">
    <button style="background-color: white" type="submit">BACK</button>
</form>
</body>
</html>