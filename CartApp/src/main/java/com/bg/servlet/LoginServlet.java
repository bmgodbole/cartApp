package com.bg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.connection.DbCon;
import com.bg.dao.UserDao;
import com.bg.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try(PrintWriter out = response.getWriter())
	{
		out.print("in login servlet");
		String email = request.getParameter("login-email");
		String password = request.getParameter("login-password");
		//out.print(email + password);
		try {
			UserDao udao = new UserDao(DbCon.getConnection());
			User user  = udao.userLogin(email, password);
			if(user!=null)
			{
				out.print("user logged in");
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				out.print("user logged in failed");	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

}
