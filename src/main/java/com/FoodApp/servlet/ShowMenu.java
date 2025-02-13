package com.FoodApp.servlet;

import java.io.IOException;
import java.util.List;

import com.FoodApp.Daoimpliment.MenuDaoImpl;
import com.FoodApp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet
{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     int id=Integer.parseInt(req.getParameter("id"));
	     MenuDaoImpl menu=new MenuDaoImpl();
	     List<Menu> menuList=menu.getonId(id);
	     HttpSession session=req.getSession();
	     session.setAttribute("menuList",menuList);
	     resp.sendRedirect("Menu.jsp");	     
}
}
