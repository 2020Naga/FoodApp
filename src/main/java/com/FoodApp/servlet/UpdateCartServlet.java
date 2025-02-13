package com.FoodApp.servlet;

import java.io.IOException;
import java.util.Map;

import com.FoodApp.Daoimpliment.CartDaoImpl;
import com.FoodApp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/callUpdateservlet")
public class UpdateCartServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		     int ItemId=Integer.parseInt(req.getParameter("itemId"));
		     int qunantity=Integer.parseInt(req.getParameter("quantity"));
		     Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
	            if (cart != null) {
	                CartDaoImpl cartDao = new CartDaoImpl();
	                cart = cartDao.updateCartItem(ItemId, qunantity, cart);
	                req.getSession().setAttribute("cart", cart);
	            }
	            resp.sendRedirect("cart.jsp");
		   
	}
}
