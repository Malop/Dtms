package com.mwp.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mwp.dao.model.PartyMember;

@Mapper
public interface PartyMemberCustomizeMapper {

	int countForOffsetPage(Map map);
	
	List<PartyMember> selectUserForOffsetPage(Map map);
	
	int deleteByCertids(String[] certids);
}
