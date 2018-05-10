package com.mwp.control;

import java.util.List;

import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mwp.dao.model.User;
import com.mwp.service.ScanService;
import com.mwp.service.UserService;
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
	ScanService scanService;
/*	
	@Description(value="扫描主页")
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String scanIndex(){
		
		return "/scan/scanIndex.jsp";
	}
*/
	@Description(value="扫描主页")
	@RequestMapping(value="/index/{userid}",method=RequestMethod.GET)
	public String scanIndex(@PathVariable("userid") String userid, ModelMap modelMap){
		User user = userService.getUserById(userid);
		modelMap.put("user", user);
		_log.info("selected user is :"+user.getRealname());
		return "/scan/scanIndex.jsp";
	}
	
	@Description(value="图片文档上传服务器")
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request,User user){
		try {
	        DiskFileItemFactory fac = new DiskFileItemFactory();
	        //设置缓存文件大小
	        fac.setSizeThreshold(1024*1024);
	        //缓存文件位置，这里取的是默认的位置
	        fac.setRepository(fac.getRepository());
	        ServletFileUpload upload = new ServletFileUpload(fac);
	        //设置最大允许上传的文件大小，这里是5MB
	        upload.setFileSizeMax(1024*1024*5);
	        
	        List<FileItem> fileList = upload.parseRequest(request);
	        boolean uploadFlag = scanService.upload(fileList,user);;
	        
	        if(uploadFlag == true){
	        	return "上传成功!";
	        }
	        
        } catch (Exception ex) {
            ex.printStackTrace();
            return "所选文件出错";
        }
        return "上传成功!";
	}
	
}
