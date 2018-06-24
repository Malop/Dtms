package com.mwp.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwp.dao.mapper.PartyMemberCustomizeMapper;
import com.mwp.dao.mapper.PartyMemberMapper;
import com.mwp.dao.model.PartyMember;
import com.mwp.dao.model.PartyMemberExample;
import com.mwp.service.PartyMemberService;

@Service
public class PartyMemberServiceImpl implements PartyMemberService{
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(PartyMemberServiceImpl.class);
	
	//注入userMapper
	@Autowired
	PartyMemberMapper partyMemberMapper;
	
	//注入自定义Mapper
	@Autowired
	PartyMemberCustomizeMapper partyMemberCustomizeMapper;
	
	@Transactional
	public PartyMember getPartyMember(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Description(value="根据证件号查询信息")
	public PartyMember getPartyMemberByCertId(String certId) {
		PartyMember partyMember = partyMemberMapper.selectByPrimaryKey(certId);
		if(null == partyMember) return null;
		return partyMember;
	}

	@Transactional
	public int deletPartyMember(List<String> partyMemberList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public int deleteByCertids(String[] certids) {
		return partyMemberCustomizeMapper.deleteByCertids(certids);
	}

	@Transactional
	public PartyMember addPartyMember(PartyMember partyMember) {
		PartyMemberExample pme = new PartyMemberExample();
		pme.createCriteria().andCertidEqualTo(partyMember.getCertid());
		long partyMemberExists = partyMemberMapper.countByExample(pme);
		if(partyMemberExists > 0){
			_log.info("the partyMemberMapper"+partyMember.getPartyname()+" is exists!");
			return null;//如果存在直接返回null
		}
		partyMemberMapper.insert(partyMember);
		return partyMember;
	}

	@Transactional
	public String updatePartyMember(PartyMember partyMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int countForOffsetPage(Map<String, Comparable> map) {
		return partyMemberCustomizeMapper.countForOffsetPage(map);
	}

	@Transactional
	public List<PartyMember> selectPartyMemberForOffsetPage(Map<String, Comparable> map) {
		List<PartyMember> partyMemberList = partyMemberCustomizeMapper.selectUserForOffsetPage(map);
		return partyMemberList;
	}

	@Transactional
	public int importPartyMember(List<String> partyMemberList) {
		PartyMember partyMemberFromExcel  = new PartyMember(partyMemberList);
		
		PartyMemberExample pme = new PartyMemberExample();
		pme.createCriteria().andCertidEqualTo(partyMemberFromExcel.getCertid());
		PartyMember partyMemberExists = partyMemberMapper.selectByPrimaryKey(partyMemberFromExcel.getCertid());
		if(partyMemberExists != null){
			_log.info("PartyMember: "+partyMemberExists.getCertid()+" is exist!");
			return 0;
		}
		partyMemberMapper.insert(partyMemberFromExcel);
		return 1;
	}

}
