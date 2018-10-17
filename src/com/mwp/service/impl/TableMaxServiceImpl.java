package com.mwp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import com.mwp.dao.mapper.TableMaxMapper;
import com.mwp.dao.mapper.TableMaxMapperCus;
import com.mwp.dao.model.TableMax;
import com.mwp.service.TableMaxService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class TableMaxServiceImpl implements TableMaxService {
	
	@Autowired
	private TableMaxMapperCus tableMaxMapperCus;
	
	@Autowired
	private TableMaxMapper tableMaxMapper;
	
	/**
	 * 悲观锁获取流水号方式
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public String getSerialNoForUpdate(String tableName, String columnName, String prefix) {
		
		String sNewSerialNo = tableMaxMapperCus.getSerialNo(tableName,columnName);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String sToday = sf.format(new Date());
		
		TableMax tableMax = new TableMax();
		tableMax.setTabname(tableName);
		tableMax.setColname(columnName);
		tableMax.setVersion(1L);
		
		if("".equals(sNewSerialNo)){
			sNewSerialNo = prefix + sToday + "000001";
			tableMax.setMaxserialno(sNewSerialNo);
			tableMaxMapper.insertSelective(tableMax);
		}else{
			if(sNewSerialNo.contains(sToday)){
				int icr = Integer.parseInt(sNewSerialNo.substring(sNewSerialNo.length()-6, sNewSerialNo.length()));
				AtomicInteger atoSerialNo = new AtomicInteger(icr);
				atoSerialNo.getAndIncrement();
				
				sNewSerialNo = sNewSerialNo.substring(0,sNewSerialNo.length()-6)+StringUtils.leftPad(atoSerialNo.toString(), 6, "0");
			}else{
				sNewSerialNo = prefix + sToday + "000001";
			}
			tableMax.setMaxserialno(sNewSerialNo);
			tableMaxMapper.updateByPrimaryKey(tableMax);
		}
		return sNewSerialNo;
	}

	/**
	 * 乐观锁获取流水号方式
	 */
	public String getSerialNoForHappy(String tableName, String columnName, String prefix) {
		String sNewSerialNo="";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String sToday = sf.format(new Date());
		
		Example example = new Example(TableMax.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("tabname",tableName);
		criteria.andEqualTo("colname",columnName);
		
		TableMax tableMax = tableMaxMapper.selectOneByExample(example);
		if(null == tableMax){
			tableMax = new TableMax();
			tableMax.setTabname(tableName);
			tableMax.setColname(columnName);
			tableMax.setVersion(1L);
			sNewSerialNo = prefix + sToday + "000001";
			tableMax.setMaxserialno(sNewSerialNo);
			tableMaxMapper.insertSelective(tableMax);
		}else{
			sNewSerialNo = tableMax.getMaxserialno();
			long version = tableMax.getVersion();
			if(sNewSerialNo.contains(sToday)){
				int icr = Integer.parseInt(sNewSerialNo.substring(sNewSerialNo.length()-6, sNewSerialNo.length()));
				AtomicInteger atoSerialNo = new AtomicInteger(icr);
				atoSerialNo.getAndIncrement();
				
				sNewSerialNo = sNewSerialNo.substring(0,sNewSerialNo.length()-6)+StringUtils.leftPad(atoSerialNo.toString(), 6, "0");
			}else{
				sNewSerialNo = prefix + sToday + "000001";
			}
			criteria.andEqualTo("version",version);
			version++;
			tableMax.setVersion(version);
			tableMax.setMaxserialno(sNewSerialNo);
			tableMaxMapper.updateByExampleSelective(tableMax, example);
		}
		return sNewSerialNo;
	}

	/**
	 * 利用数据库的sequence获取流水号
	 */
	public String getSerialNoForSequence(String prefix,int size) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String sToday = sf.format(new Date());
		String seqStr = String.valueOf(getInt());
		seqStr = StringUtils.leftPad(seqStr, size,"0");
		if("".equals(prefix)){
			return sToday + seqStr;
		}else{
			return prefix + sToday + seqStr;
		}
	}
	
	public int getInt(){
		
		MySQLMaxValueIncrementer sequence = new MySQLMaxValueIncrementer();
		
		long seq =  sequence.nextIntValue();
		if(seq > Integer.MAX_VALUE){
			int ret = (int)((seq)%Integer.MAX_VALUE)*1000+1;
			return ret;
		}else{
			return (int)seq;
		}
	}
}
