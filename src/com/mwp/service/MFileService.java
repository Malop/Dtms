package com.mwp.service;

import java.util.List;

import com.mwp.dao.model.MFile;
import com.mwp.dao.model.MFileExample;

/**
 * 党员档案文件接口服务
 * @author mwp
 *
 */
public interface MFileService {
	
	public int countMFileByExample(MFileExample mFileExample);
	
	//按党员信息查找档案文件信息
	public List<MFile> selectMFileByExample(MFileExample mFileExample);
	
	//增加档案文件信息
	public void addMFile(MFile mf);
	
	//删除档案文件信息
	public void delMFile(MFile mf);
}
