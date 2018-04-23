package com.mwp.common.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 资源文件读取工具类
 * @author mwp
 *
 */
public class PropertiesFileUtil {

	//打开多个资源文件时，用hashma缓存
	private static HashMap<String,PropertiesFileUtil> configMap = new HashMap<String,PropertiesFileUtil>();
	//默认文件名称
	private static final String NAME = "config";
	//超时时间
	private static final Integer TIME_OUT = 60*1000;	
	
	//加载时间，判断是否超时
	private Date loadTime = null;
	
	//资源文件
	private ResourceBundle resourceBundle = null;
	
	//私有构造方法，单例模式
	private PropertiesFileUtil(String name){
		this.loadTime = new Date();
		this.resourceBundle = ResourceBundle.getBundle(name);
	}
	
	public Date getLoadTime() {
		return loadTime;
	}
	
	//获得实例
	public static synchronized PropertiesFileUtil getInstance(){
		return getInstance(NAME);
	}
	//按资源名称获得实例
	public static synchronized PropertiesFileUtil getInstance(String name){
		PropertiesFileUtil propUtil = configMap.get(name);//先从缓存中取
		if(null == propUtil){
			propUtil = new PropertiesFileUtil(name);
			configMap.put(name,propUtil);
		}
		//判断打开一个资源文件的时间是否超时
		if((new Date().getTime() - propUtil.getLoadTime().getTime()) > TIME_OUT){
			propUtil = new PropertiesFileUtil(name);//超时重新打开
			configMap.put(name, propUtil);//打开后放入缓存
		}
		return propUtil;
	}
	
	public String getString(String key){
		try{
			return resourceBundle.getString(key);
		}catch(MissingResourceException e){
			return "";
		}
	}
	
	public Integer getInt(String key){
		try{
			String value = getString(key);
			return Integer.parseInt(value);
		}catch(MissingResourceException e){
			return null;
		}
	}
	
	public Boolean getBoolean(String key){
		try{
			String value = getString(key);
			if("true".equals(value))
				return true;
			else
				return false;
		}catch(MissingResourceException e){
			return false;
		}
	}
	
	public Map<String,String> getMap(){
		Map<String,String> resultMap = new HashMap<String,String>();
		for(Enumeration<String> e = resourceBundle.getKeys();e.hasMoreElements();){
			String key = e.nextElement();
			resultMap.put(key,resourceBundle.getString(key));
		}
		return resultMap;
	}
}
