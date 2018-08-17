package com.mwp.base;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mwp.annotation.ControllerLimit;

/**
 * 限流注解的实现，基于拦截器
 * @author mwp
 *
 */
public class ControllerLimitInterceptor extends HandlerInterceptorAdapter{

	private static int limitCount;
	//自增访问量计数器
	private AtomicInteger count = new AtomicInteger(0);
	
	//请求来的时候的时间
	private static long timestamp = System.currentTimeMillis();
	
	private final static Logger _log = LoggerFactory.getLogger(ControllerLimitInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		_log.info(request.getRequestURI()+"开始拦截"+count.intValue());
		long now  = System.currentTimeMillis();//当前时间
		if (handler instanceof HandlerMethod) {
			
			HandlerMethod method = (HandlerMethod) handler;
	
	        ControllerLimit annotation = method.getMethodAnnotation(ControllerLimit.class);
	        if (annotation == null) {
	            //没加注解的方法就直接return,不进行拦截
	            return true;
	        }
	        limitCount = annotation.value();
	        _log.info(request.getRequestURI()+"拦截成功"+count.intValue());
			if(now - timestamp < 1000){
				//访问次数未超过阈值
				if(count.intValue() < limitCount){
					//访问次数+1
					count.incrementAndGet();
					return true;
				}else{
					//时间内超过阈值则不予许访问
					 _log.info(request.getRequestURI()+"请求超过计数器限流器速率");
					return false;
				}
			}else{
				//超时的话就重新初始化
				count.set(0);
				timestamp = now;
				return true;
			}
		}
		return true;
		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mav)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		//整个请求访问结束后访问次数减1
		if(count.get()>0){
			count.decrementAndGet();
		}
	}
}
