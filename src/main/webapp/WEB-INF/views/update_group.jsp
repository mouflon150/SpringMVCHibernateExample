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
<h1>Update Group</h1>
<form action="/updateGroup/${group.id}" method="post">
    <div class="form-group">
        <label for="groupName">Group name</label>
        <input class="form-control" name="groupName" id="groupName" aria-describedby="groupName"
               placeholder="Enter group name">
    </div>
    <div class="form-group">
        <label for="dateOfStart">Date of start</label>
        <input type="text" class="form-control" name="dateOfStart" id="dateOfStart" placeholder="Enter date of start">
    </div>
    <div class="form-group">
        <label for="dateOfFinish">Date of finish</label>
        <input type="text" class="form-control" name="dateOfFinish" id="dateOfFinish" placeholder="Enter dateOfFinish">
    </div>
    <button type="submit" class="btn btn-primary" value="update_group">Submit</button>
</form>
</body>
</html>
