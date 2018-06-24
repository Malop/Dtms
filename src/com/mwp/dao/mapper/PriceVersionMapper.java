package com.mwp.dao.mapper;

import com.mwp.dao.model.PriceVersion;
import com.mwp.dao.model.PriceVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceVersionMapper {
    long countByExample(PriceVersionExample example);

    int deleteByExample(PriceVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceVersion record);

    int insertSelective(PriceVersion record);

    List<PriceVersion> selectByExample(PriceVersionExample example);

    PriceVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByExample(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByPrimaryKeySelective(PriceVersion record);

    int updateByPrimaryKey(PriceVersion record);
    
    int updateByVersion(PriceVersion record);
}