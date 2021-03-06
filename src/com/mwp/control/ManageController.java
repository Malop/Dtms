package com.mwp.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mwp.base.BaseController;
import com.mwp.base.BasePageResult;
import com.mwp.base.BaseResult;
import com.mwp.common.util.ExcelUtil;
import com.mwp.dao.model.User;
import com.mwp.service.MenuService;
import com.mwp.service.UserService;

import io.swagger.annotations.Api;

/**
 * 后台控制器
 * @author mwp
 *
 */
@Controller
@RequestMapping("/manage")
@Api(value="后台管理")
public class ManageController extends BaseController {
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(ManageController.class);
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap mp){
		
		return "/manage/manageIndex.jsp";
	}
	
	@Description(value="excel文件导入")
	@RequestMapping(value="/fileInput",method=RequestMethod.GET)
	public String fileInput(){
		return "/manage/fileInput.jsp";
	} 

	@Description(value="新增用户信息")
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String create(){
		return "/manage/manageCreate.jsp";
	}
	
	@Description(value="新增用户信息")
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(User user){
		
		return "/manage/manageCreate.jsp";
	}
	
	@Description(value="人员列表")
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public BasePageResult<User> list(
			@RequestParam(required=false,defaultValue="0",value="offset") int offset,
			@RequestParam(required=false,defaultValue="10",value="limit") int limit,
			@RequestParam(required=false,value="userId") String userId,
			@RequestParam(required=false,value="userName") String userName,
			@RequestParam(required=false,value="certId") String certId,
			@RequestParam(required=false,value="order") String order){
		Map<String, Comparable> parameMap = new HashMap<String,Comparable>();
		
		if(!StringUtils.isBlank(userId)){
			parameMap.put("userid", userId);
		}
		if(!StringUtils.isBlank(userName)){
			parameMap.put("username", userName);
		}

		int total = userService.countForOffsetPage(parameMap);
		if(!StringUtils.isBlank(order)){
			parameMap.put("order", order);
		}

		parameMap.put("offset", offset);
		parameMap.put("limit", limit);
		
		List<User> userList = userService.selectUserForOffsetPage(parameMap);
		return new BasePageResult<User>(total, userList);
		
	}
	
	@Description(value="excel文件导入")
	@RequestMapping(value = "/impoerExcel", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult importExcel(@RequestParam(value = "excelFile", required = false) MultipartFile excelFile,HttpServletRequest request) {
		try {
	         if(excelFile!=null){
	        	 //默认读xls文件
	             List<List<String>> datas = null;
	             _log.info("获取文件----"+excelFile.getOriginalFilename());
	             //支持读xls文件
	             if(excelFile.getOriginalFilename().endsWith("xlsx")){
	            	 datas = ExcelUtil.readXlsx(excelFile.getInputStream());
	             }else if(excelFile.getOriginalFilename().endsWith("xls")){
	            	 datas = ExcelUtil.readXls(excelFile.getInputStream());
	             }else{
	            	 return new BaseResult(2,"文件格式无法导入","");
	             }
	             //读到的数据都在datas里面
	             if(datas!=null && datas.size()>0){
	            	 for(int i=0;i<datas.size();i++){
	            		 userService.importUser(datas.get(i));
	            	 }
	                 return new BaseResult(1,"导入成功","");
	             }
	         }else{
	        	 _log.info("出现错误------"+excelFile);
	             return new BaseResult(2,"无效文件","");
	         }
	     } catch (Exception e) {
	    	 _log.info("出现异常------"+e.getMessage());
	         return new BaseResult(2,"出现异常","");
	     }
	     return new BaseResult(2,"出现异常","");
	 }
	
}
