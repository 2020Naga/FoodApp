package com.FoodApp.servlet;

import java.io.IOException;

import com.FoodApp.Daoimpliment.UserDaoImpl;
import com.FoodApp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet
{
	private UserDaoImpl userDaoImpl;
	public void init() throws ServletException {
		userDaoImpl = new UserDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	   User user = (User) req.getSession().getAttribute("user");
		userDaoImpl.insert(user);
		resp.sendRedirect("Login.jsp");
		}
}
