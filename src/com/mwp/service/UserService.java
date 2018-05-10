package com.mwp.service;

import java.util.List;
import java.util.Map;

import com.mwp.dao.model.User;
import com.mwp.dao.model.UserExample;

/**
 * 登入接口
 * @author mwp
 *
 */
public interface UserService {

	
	public User getUser(String name);
	
	public User getUserById(String userid);
	
	public int deleteUser(List<String> userList);
	
	public User addUser(User user);
	
	public String updateUser(User user);
	
	//按条件查询你总数
	public int countForOffsetPage(Map<String,Comparable> map);
	//查询分页用户信息
	public List<User> selectUserForOffsetPage(Map<String,Comparable> map);
	
	//按excel导入用户信息
	public int importUser(List<String> userList);
}
