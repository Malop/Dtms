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

import com.mwp.base.BaseController;
import com.mwp.base.BasePageResult;
import com.mwp.dao.model.Menu;
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
public class ManageControl extends BaseController {
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(ManageControl.class);
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap mp){
		
//		//获取登入的用户
//		User user = (User) request.getSession().getAttribute("user");
//		
//		//获取当前用户拥有的菜单
//		List<Menu> listMenus = menuService.getMenuByUser(user);
//		mp.addAttribute("listMenus",listMenus);
//		
		return "/manage/manageIndex.jsp";
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
		_log.info("total===="+total);
		if(!StringUtils.isBlank(order)){
			parameMap.put("order", order);
		}

		parameMap.put("offset", offset);
		parameMap.put("limit", limit);
	
		
		List<User> userList = userService.selectUserForOffsetPage(parameMap);
		_log.info("userList===="+userList);
		return new BasePageResult<User>(total, userList);
		
	}
}
