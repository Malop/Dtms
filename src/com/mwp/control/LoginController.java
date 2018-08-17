package com.mwp.control;

import java.util.List;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mwp.common.util.MD5Util;
import com.mwp.common.util.PropertiesFileUtil;
import com.mwp.dao.model.Menu;
import com.mwp.dao.model.User;
import com.mwp.service.MenuService;
import com.mwp.service.UserService;
import com.mwp.base.BaseResult;
import com.mwp.annotation.ControllerLimit;
import com.mwp.base.BaseController;

import io.swagger.annotations.Api;

/**
 * 登入控制器
 * @author mwp
 *
 */
@Controller
@RequestMapping("/index")
@Api(value="登入管理")
public class LoginController extends BaseController{
	
	public static final String LOGIN_URL = PropertiesFileUtil.getInstance().getString("loginUrl");
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginIndex(){
		return LOGIN_URL;
	}
	
	@RequestMapping(value="/redirect",method=RequestMethod.GET)
	public String redirect(){
		return "/index/redirect_index.jsp";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	@ControllerLimit(10)
	public BaseResult login(HttpServletRequest request,ModelMap mp){
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		User userByName = userService.getUser(userName);
		if(userByName == null){
			return new BaseResult(1000,"用户不存在",null);
		}
		
		if(!userByName.getPassword().equals(MD5Util.MD5(passWord))){
			return new BaseResult(1001,"密码错误",null);
		}
		//密码相同，登入成功，将登入用户存到session中
		//mp.addAttribute("user", userByName);
		request.getSession().setAttribute("user", userByName);
		return new BaseResult(0000, "/index/redirect",null);
	}
	
	@RequestMapping(value="/indexhome",method=RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap mp){
		//获取登入的用户
		User user = (User) request.getSession().getAttribute("user");
		_log.info("user is ========"+user.getUsername());
		//获取当前用户拥有的菜单
		List<Menu> userMenuList = menuService.getMenuByUser(user);
		mp.addAttribute("listMenus", userMenuList);
		mp.addAttribute("user", user);
		return "/index/index.jsp";
	}

	@RequestMapping(value="/redirectHome",method=RequestMethod.GET)
	public String redirectHome(){
		
		return "/index/redirect_index.jsp";
	}
	
	@RequestMapping(value="/logout/{username}",method=RequestMethod.GET)
	public String logout(@PathVariable(required=true,value="username") String username,HttpServletRequest request){
		if(username.equals(request.getAttribute("user"))){
			request.getSession().setAttribute("user", null);
		}
		
		return LOGIN_URL;
	}
}
