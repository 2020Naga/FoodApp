package com.FoodApp.servlet;
import java.io.IOException;
import java.util.List;

import com.FoodApp.Daoimpliment.RestaurantDaoImpl;
import com.FoodApp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	RestaurantDaoImpl rid=new RestaurantDaoImpl();
    	List<Restaurant> restaurantList=rid.fetchAll();
    	HttpSession sesstion=req.getSession();
    	sesstion.setAttribute("restaurantList",restaurantList);
    	resp.sendRedirect("frist.jsp");	
    }
}
