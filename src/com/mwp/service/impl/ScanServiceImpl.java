package com.mwp.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwp.common.util.PropertiesFileUtil;
import com.mwp.control.ScanController;
import com.mwp.dao.mapper.MFileMapper;
import com.mwp.dao.model.MFile;
import com.mwp.dao.model.User;
import com.mwp.service.ScanService;

@Service
public class ScanServiceImpl implements ScanService{

	private static Logger _log = LoggerFactory.getLogger(ScanServiceImpl.class);
	//文件大小默认最大5M
	private static long fileSizeMAX = 1024 * 1024 *5 ;
	
	//文件对象操作对象fileMapper
	@Autowired
	MFileMapper mFileMapper;
	
	//文件存储路径
	private static String fileSavePath = PropertiesFileUtil.getInstance().getString("fileSavePath");
	
	@Override
	@Transactional
	@Description(value="上传文件到服务器")
	public boolean upload(List<FileItem> fileList,User user) {
		_log.info("the filesavepath is:"+fileSavePath);
		try{
			String fileName="";//文件名
			long fileSize = 0L;
			int insertFlag=0;
			File savaFile = null;//要写到服务器上的文件对象
			MFile mFile = null;//要插入到数据库的文件对象
			if(fileList != null){
				for(FileItem fileItem : fileList){
					fileName = fileItem.getName();
					fileSize = fileItem.getSize();
					//文件名为空，大小不符则跳到下一个循环
					if(fileName == null || fileName.equals("") || fileSize == 0 || fileSize > fileSizeMAX)
						continue;
					mFile = new MFile();
					mFile.setMfileid(fileName);
					mFile.setMfiletype("1");
					mFile.setMfileurl(fileSavePath);
					mFile.setUserid(user.getUserid());
					//先插数据库，成功后再写传上服务器，若失败则删记录
					insertFlag = mFileMapper.insert(mFile);
					if(insertFlag==0){
						//数据库插入失败则删除记录
						mFileMapper.deleteByPrimaryKey(fileName);
					}else{
						//数据库成功则写入服务器
						savaFile = new File(fileSavePath+""+fileName);
						fileItem.write(savaFile);//写入文件
					}
				}
				
			}else{
				return false;
			}
		}catch(Exception e){
			
		}
		return false;
	}

}
