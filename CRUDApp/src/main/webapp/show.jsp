<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Data</title>
    <link rel="stylesheet" href="show.css">
</head>
<body>
    <div class="container">
        <h1>User Data</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="update.jsp?id=${user.id}&name=${user.name}&email=${user.email}" class="btn">Edit</a>
                            <a href="delete.jsp?id=${user.id}" class="btn delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="insert.jsp" class="btn">Add New User</a>
        <!-- Corrected URL for Show Data Servlet -->
        <a href="showDataServlet" class="btn">Show Data</a>
    </div>
</body>
</html>
