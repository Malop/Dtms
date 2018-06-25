package com.mwp.control;

import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mwp.base.BaseController;
import com.mwp.base.BasePageResult;
import com.mwp.base.BaseResult;
import com.mwp.common.util.ExcelUtil;
import com.mwp.dao.model.MFile;
import com.mwp.dao.model.MFileExample;
import com.mwp.dao.model.MFileExample.Criteria;
import com.mwp.dao.model.PartyMember;
import com.mwp.service.MFileService;
import com.mwp.service.PartyMemberService;
import com.mwp.service.UserService;

import io.swagger.annotations.Api;

/**
 * 党员信息控制器
 * @author mwp
 *
 */
@Controller
@RequestMapping("/partymember")
@Api(value="后台管理")
public class PartyMemberController extends BaseController {
	//获得日志记录句柄
	private static Logger _log = LoggerFactory.getLogger(PartyMemberController.class);
	
	@Autowired
	PartyMemberService partyMemberService;
	
	@Autowired
	MFileService mFileService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap mp){
		
		return "/partymember/partyMemberIndex.jsp";
	}
	
	@Description(value="excel文件导入")
	@RequestMapping(value="/fileInput",method=RequestMethod.GET)
	public String fileInput(){
		return "/partymember/fileInput.jsp";
	} 

	@Description(value="党员档案信息浏览")
	@RequestMapping(value="/fileList/{certid}",method=RequestMethod.GET)
	public String fileList(@PathVariable(required=true,value="certid") String certid,ModelMap map){
		_log.info("接受参数:"+certid);
		map.addAttribute("partyMemberCertid", certid);
		return "/partymember/fileList.jsp";
	}
	
	@Description(value="党员档案信息浏览")
	@RequestMapping(value="/fileList/{partyMemberCertid}",method=RequestMethod.POST)
	@ResponseBody
	public BasePageResult<MFile> fileList(@PathVariable(required=true,value="partyMemberCertid") String partyMemberCertid,
			@RequestParam(required=false,value="mFileType") String mfiletype){
		_log.info("post接受参数:"+partyMemberCertid+"---"+mfiletype);
		//设置条件
		MFileExample mfe = new MFileExample();
		Criteria creteria= mfe.createCriteria();
		creteria.andUseridEqualTo(partyMemberCertid);
		
		if(!StringUtils.isBlank(mfiletype)){
			creteria.andMfiletypeEqualTo(mfiletype);
		}
		
		
		int total = mFileService.countMFileByExample(mfe);
		
		List<MFile> mFileList = mFileService.selectMFileByExample(mfe);
		return new BasePageResult<MFile>(total, mFileList);
	}
	@Description(value="新增党员信息")
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String create(){
		return "/partymember/partyMemberCreate.jsp";
	}
	
	
	@Description(value="党员信息保存")
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult create(PartyMember partyMember){
		Date ctTime = new Date();
		partyMember.setCttime(ctTime);
		partyMember = partyMemberService.addPartyMember(partyMember);
		if(null == partyMember){
			return new BaseResult(1001,"该用户已存在",null);
		}
		_log.info("新增党员信息成功certid={},partyname={}", partyMember.getCertid(),partyMember.getPartyname());
		return new BaseResult(1,"操作成功",null);
	}
	
	@Description(value="党员信息详情修改")
	@RequestMapping(value="/info/{certid}", method = RequestMethod.GET)
	public String info(@PathVariable(required=true,value="certid") String certid,ModelMap mp){
		_log.info("修改党员信息:"+certid);
		
		PartyMember partyMember = partyMemberService.getPartyMemberByCertId(certid);
		mp.put("partyMember", partyMember);
		return "/partymember/partyMemberInfo.jsp";
	}
	
	@Description(value="删除记录信息")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResult delete(@RequestParam(required=true,value="certids") String[] certids ){
		_log.info("得到前台参数："+certids.length);
		if(null == certids || certids.length==0){
			return new BaseResult(2,"无效记录",null);
		}
		
		int count = partyMemberService.deleteByCertids(certids);
		if(count > 0){
			return new BaseResult(1,"删除成功",null);
		}
		return new BaseResult(3,"删除出错",null);
		
	}
	
	@Description(value="人员列表")
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public BasePageResult<PartyMember> list(
			@RequestParam(required=false,defaultValue="0",value="offset") int offset,
			@RequestParam(required=false,defaultValue="10",value="limit") int limit,
			@RequestParam(required=false,value="certId") String certId,
			@RequestParam(required=false,value="partyName") String partyName,
			@RequestParam(required=false,value="brithday") String brithday,
			@RequestParam(required=false,value="partyTime") String partyTime,
			@RequestParam(required=false,value="sort") String sort,
			@RequestParam(required=false,value="order") String order){
		Map<String, Comparable> parameMap = new HashMap<String,Comparable>();
		
		if(!StringUtils.isBlank(certId)){
			parameMap.put("certId", certId);
		}
		
		if(!StringUtils.isBlank(partyName)){
			parameMap.put("partyName", partyName);
		}
		if(!StringUtils.isBlank(brithday)){
			parameMap.put("birthDay", brithday);
		}
		if(!StringUtils.isBlank(partyTime)){
			parameMap.put("partyTime", partyTime);
		}

		int total = partyMemberService.countForOffsetPage(parameMap);
		if(!StringUtils.isBlank(order)){
			parameMap.put("order", order);
		}
		
		if(!StringUtils.isBlank(order)){
			parameMap.put("sort", sort);
		}
		_log.info("------获取查询参数:"+parameMap.toString());
		parameMap.put("offset", offset);
		parameMap.put("limit", limit);
		
		List<PartyMember> partyMemberList = partyMemberService.selectPartyMemberForOffsetPage(parameMap);
		return new BasePageResult<PartyMember>(total, partyMemberList);
		
	}
	
	@Description(value="excel文件导入")
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST)
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
	            		 partyMemberService.importPartyMember(datas.get(i));
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
