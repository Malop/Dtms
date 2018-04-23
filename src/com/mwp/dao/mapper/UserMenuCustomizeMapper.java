package com.mwp.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mwp.dao.model.Menu;
import com.mwp.dao.model.User;

@Mapper
public interface UserMenuCustomizeMapper {

	List<Menu> selectMenuByUser(User user);
}
