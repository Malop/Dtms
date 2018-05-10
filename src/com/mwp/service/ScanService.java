package com.mwp.service;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.mwp.dao.model.User;


/**
 * 扫描上传文件接口
 * @author mwp
 *
 */
public interface ScanService {
	
	public boolean upload(List<FileItem> fileList,User user);
	
}
