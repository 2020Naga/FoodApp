package com.FoodApp.Dao;

import java.util.List;

import com.FoodApp.model.OrderItems;

public interface OrderItemDao
{
	 int insert(OrderItems orderItem); 
	 List<OrderItems> fetchAll();
	 OrderItems fetchSpecific(int orderItemId);
	 int updateOrderItem(OrderItems orderItem);
	 int deleteOrderItem(int orderItemId);
}
