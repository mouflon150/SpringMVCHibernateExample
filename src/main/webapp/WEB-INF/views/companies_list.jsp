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
    <title>Company Management System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">List Companies</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Company Name</th>
        <th scope="col">Located Country</th>
        <th scope="col">Courses</th>
        <th scope="col">Groups</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>
                <a href="/findCompany/${company.id}">${company.companyName}</a>
            </td>
            <td>${company.locatedCountry}</td>
            <td>
                <form action="/courses" method="get">
                    <button type="submit">Course</button>
                </form>
            </td>
            <td>
                <form action="/" method="get">
                    <button type="submit">Group</button>
                </form>
            </td>
            <td>
                <form action="/editCompany/${company.id}" method="get">
                    <button style="background-color: blue" type="submit">UPDATE</button>
                </form>
                <form action="/deleteCompany/${company.id}" method="get">
                    <button style="background-color: red" type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/companyForm" method="get">
    <button style="background-color: white" type="submit">ADD-COMPANY</button>
</form>
<form action="/clearCompanies" method="get">
    <button style="background-color: white" type="submit">CLEAR</button>
</form>
</body>
</html>