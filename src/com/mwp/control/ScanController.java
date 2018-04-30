package com.mwp.control;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mwp.common.util.MD5Util;
import com.mwp.common.util.PropertiesFileUtil;
import com.mwp.dao.model.Menu;
import com.mwp.dao.model.User;
import com.mwp.service.MenuService;
import com.mwp.service.UserService;
import com.mwp.base.BaseResult;
import com.mwp.base.BaseController;

import io.swagger.annotations.Api;

/**
 * 高拍仪扫描控制器
 * @author mwp
 *
 */
@Controller
@RequestMapping("/scan")
@Api(value="高拍仪扫描")
public class ScanController extends BaseController{
	
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(ScanController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String loginIndex(){
		return "/scan/scanIndex.jsp";
	}
	
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request,ModelMap mp){
		try {
			request.setCharacterEncoding("GBK");
	        DiskFileItemFactory fac = new DiskFileItemFactory();
	        //设置缓存文件大小
	        fac.setSizeThreshold(1024*1024);
	        //缓存文件位置，这里取的是默认的位置
	        fac.setRepository(fac.getRepository());
	        ServletFileUpload upload = new ServletFileUpload(fac);
	        //设置最大允许上传的文件大小，这里是5MB
	        upload.setFileSizeMax(1024*1024*5);
	        List fileList = upload.parseRequest(request);
        
	        Iterator iter = fileList.iterator();
	        while(iter.hasNext()){
	            FileItem fileItem = (FileItem)iter.next();
	            if(!fileItem.isFormField()){
	                String name = fileItem.getName();
	                String fileSize = new Long(fileItem.getSize()).toString();
	                if(name == null || name.equals("") || fileSize.equals("0"))
	                    continue;
	                //截取出纯文件名
	                name = name.substring(name.lastIndexOf("\\")+1);
	                //存储文件
	                File saveFile = new File("d:\\upload\\"+name);
	                try {
	                    fileItem.write(saveFile);
	                } catch (Exception ex1) {
	                    ex1.printStackTrace();
	                    return "";
	                }
	            }
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "所选文件出错";
        }
        return "上传成功!";
	}
	
}
