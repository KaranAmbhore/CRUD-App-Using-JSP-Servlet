package com.company.show;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/showDataServlet")
public class ShowDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/crudapp";
        String jdbcUsername = "root";
        String jdbcPassword = "karan@123";
        
        // Query to retrieve all users
        String query = "SELECT * FROM users";
        
        List<User> users = new ArrayList<>();
        
        // Step 1: Establish database connection and retrieve data
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
             
            // Step 2: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                users.add(new User(id, name, email));
                System.out.println("Name: "+resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Set the list of users as a request attribute
        request.setAttribute("users", users);
        
        // Step 4: Forward the request to show.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
        dispatcher.forward(request, response);
    }
}
