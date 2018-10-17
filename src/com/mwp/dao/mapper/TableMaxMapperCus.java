package com.mwp.dao.mapper;

import com.mwp.dao.model.TableMax;

import tk.mybatis.mapper.common.Mapper;

public interface TableMaxMapperCus extends Mapper<TableMax>{

	public String getSerialNo(String tableName,String columnName);
}
