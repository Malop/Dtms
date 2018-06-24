package com.mwp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwp.dao.mapper.MFileMapper;
import com.mwp.dao.model.MFile;
import com.mwp.dao.model.MFileExample;
import com.mwp.service.MFileService;

@Service
public class MFileServiceImpl implements MFileService{

	//获得日志记录句柄
	//private static Logger _log = LoggerFactory.getLogger(MFileServiceImpl.class);

	@Autowired
	MFileMapper mFileMapper;
	
	@Transactional
	public int countMFileByExample(MFileExample mFileExample) {
		int total = (int) mFileMapper.countByExample(mFileExample);
		return total;
	}

	@Transactional
	public List<MFile> selectMFileByExample(MFileExample mFileExample) {
		List<MFile> mFileList = mFileMapper.selectByExample(mFileExample);
		return mFileList;
	}

}
