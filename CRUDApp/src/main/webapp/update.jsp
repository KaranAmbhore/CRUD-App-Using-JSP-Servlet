<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <link rel="stylesheet" href="insert.css">
</head>
<body>
    <div class="container">
        <h1>Update User</h1>
        <form action="UpdateUserServlet" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>"> <!-- Hidden ID field -->
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" required>
            </div>
            <button type="submit" class="btn">Update</button>
            <a href="show.jsp" class="btn">Cancel</a>
        </form>
    </div>
</body>
</html>
