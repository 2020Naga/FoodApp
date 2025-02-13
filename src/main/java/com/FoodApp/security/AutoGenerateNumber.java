package com.FoodApp.security;

import com.FoodApp.Daoimpliment.*;

public class AutoGenerateNumber {
	
	public static int generateUniqueOrderId() {
       
        int maxOrderId = OrderDaoImpl.getLastOrderIdFromDatabase();
        System.out.println(maxOrderId );
        
       
        if (maxOrderId == 0) {
            return 1;  
        } else {
            
            return maxOrderId + 1;
        }
    }
}