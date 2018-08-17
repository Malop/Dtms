package com.mwp.base;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 限流拦截器，使用计数器方法实现
 * @author mwp
 *
 */
public class LimitInterceptor implements HandlerInterceptor {

	private static int limitCount;
	//自增访问量计数器
	private AtomicInteger count = new AtomicInteger(0);
	
	//请求来的时候的时间
	private static long timestamp = System.currentTimeMillis();
	
	private final static Logger _log = LoggerFactory.getLogger(LimitInterceptor.class);
	
	public LimitInterceptor(int rate){
		if(rate > 0){
			limitCount = rate;
		}else{
			throw new RuntimeException("rate must greater than zero");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
		long now  = System.currentTimeMillis();//当前时间
		 _log.info(request.getRequestURI()+"开始拦截"+count.intValue());
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
