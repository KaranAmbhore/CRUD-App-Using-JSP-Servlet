<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
    <link rel="stylesheet" href="insert.css">
</head>
<body>
    <div class="container">
        <h1>Delete User</h1>
        <p>Are you sure you want to delete this user?</p>
        <form action="deleteUserServlet" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <button type="submit" class="btn delete">Yes, Delete</button>
            <a href="show.jsp" class="btn">Cancel</a>
        </form>
    </div>
</body>
</html>
