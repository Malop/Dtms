package com.mwp.service;

public interface TableMaxService {

	public String getSerialNoForUpdate(String tbleName,String columnName,String prefix);
	
	public String getSerialNoForHappy(String tableName,String columnName,String prefix);
	
	public String getSerialNoForSequence(String prefix,int size);
}
