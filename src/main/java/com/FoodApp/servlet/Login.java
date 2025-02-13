package com.FoodApp.servlet;

import java.io.IOException;

import com.FoodApp.Daoimpliment.UserDaoImpl;
import com.FoodApp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class Login  extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String email = req.getParameter("email");
      String pass = req.getParameter("password");
      UserDaoImpl userDao = new UserDaoImpl();
      User user = userDao.isValidate(email);
      if (user != null) 
      {
          if (user.getPassword().equals(pass)) 
          {
        	  HttpSession session=req.getSession();
        	  session.setAttribute("Useobj", user);
              resp.sendRedirect("GetRestaurant");
          } else {
        	  req.setAttribute("errorMessage", "Invalid password. Please try again.");
              req.getRequestDispatcher("/Login.jsp").forward(req, resp);
          }
      } else {
       
    	  req.setAttribute("errorMessage", "No user found with the given email .");
          req.getRequestDispatcher("Login.jsp").forward(req, resp);
      }
  }
}