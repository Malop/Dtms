package com.mwp.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.util.concurrent.RateLimiter;
/**
 * 基于google guava的RateLimiter限流器的限流拦截器
 * @author mwp
 *
 */
public class RateLimitInterceptor implements HandlerInterceptor{

	private static RateLimiter rateLimiter;
	private final static Logger _log = LoggerFactory.getLogger(RateLimitInterceptor.class);
	public RateLimitInterceptor(int rate){
		if(rate > 0){
			rateLimiter = RateLimiter.create(rate);
		}else{
			throw new RuntimeException("rate must greater than zero");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
		if (!rateLimiter.tryAcquire()) {
	         _log.info(request.getRequestURI()+"请求超过限流器速率");
	         return false;
	    }
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
