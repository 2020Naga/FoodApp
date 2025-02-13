package com.FoodApp.Dao;
import com.FoodApp.model.Menu;
import java.util.List;
public interface MenuDao {
    void insert(Menu menu);
    List<Menu> fetchAll();
    Menu fetchSpecific(int menuId);
    int updateMenu(Menu menu);
    int deleteMenu(int menuId);
}
