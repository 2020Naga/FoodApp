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



@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null) {
            String itemIdStr = req.getParameter("itemId");
            if (itemIdStr != null) {
                try {
                    int itemId = Integer.parseInt(itemIdStr);
                    cart.remove(itemId);
                    session.setAttribute("cart", cart);
                } catch (NumberFormatException e) {
                   
                    e.printStackTrace();
                }
            }
        }
        
       
        resp.sendRedirect("cart.jsp");
    }
}
