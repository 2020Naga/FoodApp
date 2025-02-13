package com.FoodApp.Dao;
import java.util.List;

import com.FoodApp.model.User;

public interface UserDao 
{
  int insert(User u);
 List<User>fetchAll();
 User fetchSpecific(int uid);
 int updateUser(User user);
 int deleteUser(int uid);
 User isValidate(String email);
}
