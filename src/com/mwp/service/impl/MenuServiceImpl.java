package com.mwp.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwp.dao.mapper.UserMenuCustomizeMapper;
import com.mwp.dao.model.Menu;
import com.mwp.dao.model.User;
import com.mwp.service.MenuService;

/**
 * 菜单接口实现
 * @author mwp
 *
 */
@Service
public class MenuServiceImpl implements MenuService{
	
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	UserMenuCustomizeMapper userMenuCustomizeMapper;

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	@Description(value="根据user查可用菜单")
	public List<Menu> getMenuByUser(User user) {
		// TODO Auto-generated method stub
		
		List<Menu> listMenus = userMenuCustomizeMapper.selectMenuByUser(user);
		_log.info("user menus count:"+listMenus.size());
		return listMenus;
	}

	@Override
	public int deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Menu addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
