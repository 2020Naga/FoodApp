package com.FoodApp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.FoodApp.Daoimpliment.CartDaoImpl;
import com.FoodApp.Daoimpliment.MenuDaoImpl;
import com.FoodApp.model.CartItem;
import com.FoodApp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                Map<Integer, CartItem> cart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
             if (cart == null) {
            cart = new HashMap<>();  
            System.out.println("New cart created.");
            req.getSession().setAttribute("cart", cart);
        } else {
            System.out.println("Existing cart found.");
        }
        int menuId = Integer.parseInt(req.getParameter("menuid"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        MenuDaoImpl menuDao = new MenuDaoImpl();
        Menu menu = menuDao.fetchSpecific(menuId);
        CartItem ci = new CartItem(menuId, menu.getRid(), menu.getName(), quantity, menu.getPrice());
        CartDaoImpl cartDao = new CartDaoImpl();
        cart = cartDao.addItem(ci,cart);  
        System.out.println("Added Item \n"+cart);
        req.getSession().setAttribute("cart", cart);  
        System.out.println("Cart after adding item: " + cart);
        resp.sendRedirect("cart.jsp");
    }
}
