<%--
  Created by IntelliJ IDEA.
  User: 30056685(03)
  Date: 11.03.2023
  Time: 13:05
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
<div class="container">
    <div class="row">Company</div>
</div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Company Name</th>
        <th scope="col">Located Country</th>
        <th scope="col">Courses</th>
        <th scope="col">Groups</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${company.id}</td>
        <td>${company.companyName}</td>
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
    </tr>
    </tbody>
</table>
<a href="/companies">
    <button type="submit">ROLLBACK</button>
</a>
</body>
</html>
