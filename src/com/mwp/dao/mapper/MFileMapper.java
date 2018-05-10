package com.mwp.dao.mapper;

import com.mwp.dao.model.MFile;
import com.mwp.dao.model.MFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MFileMapper {
    long countByExample(MFileExample example);

    int deleteByExample(MFileExample example);

    int deleteByPrimaryKey(String mfileid);

    int insert(MFile record);

    int insertSelective(MFile record);

    List<MFile> selectByExample(MFileExample example);

    MFile selectByPrimaryKey(String mfileid);

    int updateByExampleSelective(@Param("record") MFile record, @Param("example") MFileExample example);

    int updateByExample(@Param("record") MFile record, @Param("example") MFileExample example);

    int updateByPrimaryKeySelective(MFile record);

    int updateByPrimaryKey(MFile record);
}