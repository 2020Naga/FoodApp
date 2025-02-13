package com.FoodApp.servlet;

import java.io.IOException;
import java.util.Map;

import com.FoodApp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ClearCart")
public class ClearCartServlet  extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	 HttpSession   session=req.getSession();
    	 Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
    	 if(cart!=null)
    	 {
    	    cart.clear();
    	 }
    	 session.setAttribute("cart", cart);  
         resp.sendRedirect("cart.jsp"); 
    	 
    }
}
