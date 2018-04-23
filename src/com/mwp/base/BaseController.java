package com.mwp.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UnknownUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.mwp.control.LoginController;

/**
 * 父控制器控制异常跳转
 * @author mwp
 *
 */
public abstract class BaseController {

	private final static Logger _log = LoggerFactory.getLogger(BaseController.class);
	
	public ModelAndView exceptionHandler(HttpServletRequest request,HttpServletResponse response,Exception exception){
		_log.error("统一异常处理:",exception);
		request.setAttribute("ex", exception);
		request.setAttribute("loginPath", LoginController.LOGIN_URL);
		if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            request.setAttribute("requestHeader", "ajax");
        }
		ModelAndView mav = new ModelAndView();
		mav.addObject("ex",exception);
		mav.addObject("loginUrl",LoginController.LOGIN_URL);
		if(exception instanceof UnknownUserException){
			mav.setViewName("/405.jsp");
		}else{
			mav.setViewName("/404.jsp");
		}
		return mav;
	}
}
