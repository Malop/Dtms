package com.mwp.dao.mapper;

import com.mwp.dao.model.PartyMember;
import com.mwp.dao.model.PartyMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartyMemberMapper {
    long countByExample(PartyMemberExample example);

    int deleteByExample(PartyMemberExample example);

    int deleteByPrimaryKey(String certid);

    int insert(PartyMember record);

    int insertSelective(PartyMember record);

    List<PartyMember> selectByExample(PartyMemberExample example);

    PartyMember selectByPrimaryKey(String certid);

    int updateByExampleSelective(@Param("record") PartyMember record, @Param("example") PartyMemberExample example);

    int updateByExample(@Param("record") PartyMember record, @Param("example") PartyMemberExample example);

    int updateByPrimaryKeySelective(PartyMember record);

    int updateByPrimaryKey(PartyMember record);
}