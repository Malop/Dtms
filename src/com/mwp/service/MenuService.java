package com.mwp.service;

import java.util.List;

import com.mwp.dao.model.Menu;
import com.mwp.dao.model.User;

/**
 * 菜单接口
 * @author mwp
 *
 */
public interface MenuService {

	public List<Menu> getAllMenu();
	
	public List<Menu> getMenuByUser(User user);
	
	public int deleteMenu(int menuId);
	
	public Menu addMenu(Menu menu);
	
}
