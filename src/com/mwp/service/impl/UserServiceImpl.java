package com.mwp.service.impl;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwp.dao.mapper.UserMapper;
import com.mwp.dao.mapper.UserCustomizeMapper;
import com.mwp.dao.model.User;
import com.mwp.dao.model.UserExample;
import com.mwp.service.UserService;

/**
 * 登入接口实现
 * @author mwp
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	//注入userMapper
	@Autowired
	UserMapper userMapper;
	
	//注入自定义Mapper
	@Autowired
	UserCustomizeMapper userCustomizeMapper;
	
	@Transactional
	@Description(value="根据username查用户")
	public User getUser(String name){
		User user = userCustomizeMapper.selectUserByName(name);
		return user;
	}
	
	@Transactional
	@Description(value="删除用户")
	public int deleteUser(List<String> userList){
		//添加条件，按用户列表删除
		UserExample ue= new UserExample();
		ue.createCriteria().andUseridIn(userList);//and userid in (userlist)
		
		int count = userMapper.deleteByExample(ue);
		
		return count;
	}
	
	@Transactional
	@Description("新增用户")
	public User addUser(User user){
		UserExample ue = new UserExample();
		ue.createCriteria().andUseridEqualTo(user.getUserid());
		long userExists = userMapper.countByExample(ue);
		if(userExists > 0){
			_log.info("user "+user.getUserid()+" is exist!");
			return null;
		}
		userMapper.insert(user);
		return user;
	}
	
	@Transactional
	@Description("按excel数据导入用户")
	public int importUser(List<String> userList){
		User userFromExcel  = new User(userList);
		
		
		UserExample ue = new UserExample();
		ue.createCriteria().andUseridEqualTo(userFromExcel.getUserid());
		User userExists = userMapper.selectByPrimaryKey(userFromExcel.getUserid());
		if(userExists != null){
			_log.info("user "+userExists.getUserid()+" is exist!");
			return 0;
		}
		userMapper.insert(userFromExcel);
		return 1;
	}
	
	@Transactional
	@Description(value="修改用户信息")
	public String updateUser(User user){
		int count = userMapper.updateByPrimaryKeySelective(user);
		if(count == 1)
			return "SUCCESS";
		else
			return "FAIL";
	}

	@Description(value="根据条件查询总数")
	public int countForOffsetPage(Map<String,Comparable> map) {
		
		return userCustomizeMapper.countForOffsetPage(map);
		
	}

	@Description(value="分页查询用户列表")
	public List<User> selectUserForOffsetPage(Map<String,Comparable> map) {
		List<User> userList = userCustomizeMapper.selectUserForOffsetPage(map);
		return userList;
	}
}
