package com.mwp.service;

import java.util.List;
import java.util.Map;

import com.mwp.dao.model.PartyMember;

/**
 * 党员信息接口服务
 * @author mwp
 *
 */
public interface PartyMemberService {

	public PartyMember getPartyMember(String name);
	
	public PartyMember getPartyMemberByCertId(String certId);
	
	public int deletPartyMember(List<String> partyMemberList);
	
	public int deleteByCertids(String[] certids);
	
	public PartyMember addPartyMember(PartyMember partyMember);
	
	public String updatePartyMember(PartyMember partyMember);
	
	//按条件查询总数
	public int countForOffsetPage(Map<String,Comparable> map);
	//查询分页用户信息
	public List<PartyMember> selectPartyMemberForOffsetPage(Map<String,Comparable> map);
	
	//按excel导入用户信息
	public int importPartyMember(List<String> partyMemberList);
}
