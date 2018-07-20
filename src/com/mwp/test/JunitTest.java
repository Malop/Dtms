package com.mwp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mwp.dao.mapper.PartyMemberMapper;
import com.mwp.dao.model.PartyMember;
import com.mwp.service.PartyMemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {

	@Autowired
	PartyMemberService partyMemberService;
	
	@Test
	public void test() {
		PartyMember partyMember = new PartyMember();
		partyMember.setCertid("330106195705270012");
		partyMember.setPartyname("蒋继海");
		partyMember.setIsout("1");
		partyMember.setOuttime("2018-07-20");
		
		partyMemberService.updatePartyMember(partyMember);
	}

}
