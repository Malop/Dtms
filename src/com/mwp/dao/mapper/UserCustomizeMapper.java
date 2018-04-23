package com.mwp.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mwp.dao.model.User;

@Mapper
public interface UserCustomizeMapper {

	User selectUserByName(String name);
	
	int countForOffsetPage(Map map);
	
	List<User> selectUserForOffsetPage(Map map);
}
