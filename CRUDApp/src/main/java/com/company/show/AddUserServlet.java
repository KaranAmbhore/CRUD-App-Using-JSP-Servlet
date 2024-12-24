package com.company.show;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/crudapp";
		String username = "root";
		String password = "karan@123";
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		try {
			Class.forName(jdbcDriver);
			Connection con = DriverManager.getConnection(url,username,password);
			String query = "INSERT INTO users (name, email) values (?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, email);
			 ;
			 
			 int rowsAffected = pstm.executeUpdate();
			 
			 if(rowsAffected > 0) {
				 System.out.println("Query executed successfully");
			 }else {
				 System.out.println("User Not added..");
			 }
			
			 response.sendRedirect("show.jsp");
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
