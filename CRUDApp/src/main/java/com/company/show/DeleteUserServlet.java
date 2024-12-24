package com.company.show;

import java.io.IOException;

import com.company.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int id = Integer.parseInt(request.getParameter("id"));

	        // Delete from database (use JDBC)
	        UserDAO userDAO = new UserDAO();
	        userDAO.deleteUser(id);

	        // Redirect to the Show Data page
	        response.sendRedirect("show.jsp");
	}

}
