package com.gmo.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gmo.model.account.AccountWithBLOBs;
import com.gmo.model.system.ExceptionLogWithBLOBs;
import com.gmo.core.util.*;
import com.gmo.dao.system.ExceptionLogMapper;
import com.gmo.model.user.TerminalUserAuthLog;
import com.gmo.service.device.DeviceService;
import com.gmo.service.system.SystemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.gmo.core.constant.Constants;
import com.gmo.core.util.DateUtil;
import com.gmo.core.util.PropertiesUtil;
import com.gmo.core.util.StringUtil;
import com.google.gson.Gson;

@ParentPackage("json-default")
@Results({@Result(name = "error", type = "json", params = {"root", "resultMap" }),
@Result(name = "errorpage", location="/WEB-INF/jsp${jspversion}/error.jsp")
})
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware {
	private static final long serialVersionUID = -4417628200145005068L;
	Logger logger = Logger.getLogger(this.getClass());
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> sessionMap;
	protected HttpSession session;
	protected Gson gson = new Gson();
	protected String returnMessage = StringUtils.EMPTY;
	protected int dbResult = 0;
	
	@Resource(name="systemService")
	protected SystemService systemService;
	
	@Resource(name="deviceService")
	protected DeviceService deviceService;
	
	@Resource(name="exceptionLogMapper")
	protected ExceptionLogMapper exceptionLogMapper;
	
	//返回json数据的map
	protected Map<String, Object> resultMap;
	public Map<String, Object> getResultMap() {
		return resultMap;
    }
	

	
	/*********************************************************/
	public void setServletRequest(HttpServletRequest request) {   
		this.request = request;
		
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		this.session = this.request.getSession();
	}

	
	public String execute() {    
		ActionContext.getContext().getSession().put("msg", "Hello World from Session!");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();        
		HttpSession session = request.getSession();
		return SUCCESS;
	}

	public String getURLWithContextPath() {
		   return this.request.getScheme() + "://" + this.request.getServerName() + ":" + this.request.getServerPort() + this.request.getContextPath();
	}
	
	 
    protected Map<String, Object> getResult(String message, String result){
        Map<String, Object> rltMap = new HashMap<String, Object>();
        rltMap.put("message", message);
        rltMap.put("result", result);
    	return rltMap;
    }
    
    protected Map<String, Object> getResult(String message){
    	Map<String, Object> rltMap = new HashMap<String, Object>();
    	try {
//    		String msg = URLEncoder.encode(message, "UTF-8");
    		String msg = message;
			rltMap.put("message", msg);
			rltMap.put("result", "FAIL");
			URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    	return rltMap;
    }
    
    protected void returnOutTxt(Map<String, Object> resultMap) {
		try {
			this.response.setContentType("text/plain");
			this.response.getWriter().write(resultMap.toString());
			this.response.getWriter().flush();
			this.response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    protected void returnOutXml(String returnMessage) {
		try {
			this.response.setContentType("text/xml");
			this.response.getWriter().write(returnMessage);
			this.response.getWriter().flush();
			this.response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    protected Map<String, Object> getResultOnUTF(String message){
    	Map<String, Object> rltMap = new HashMap<String, Object>();
    	try {
    		String msg = URLEncoder.encode(message, "UTF-8");
			rltMap.put("message", msg);
			rltMap.put("result", "FAIL");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    	return rltMap;
    }
    
    protected Map<String, Object> putMsg(String name ,String message){
    	try {
//    		String msg = URLEncoder.encode(message, "UTF-8");
    		String msg = message;
    		resultMap.put(name, msg);
			URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    	return resultMap;
    }
    
    protected Map<String, Object> getResult(){
    	Map<String, Object> rltMap = new HashMap<String, Object>();
        rltMap.put("result", "OK");
    	return rltMap;
    }
    
    
  

   
	
	/**
	 * 记录异常日志
	 * @param moduleName
	 * @param serviceName
	 * @param sysErrorMssage
	 */
	public void saveExceptionLog(String moduleName, String serviceName, /*Map paramMap,*/ Exception e){
		try {
			ExceptionLogWithBLOBs log = new ExceptionLogWithBLOBs();
			log.setModuleName(moduleName);
			log.setServiceName(serviceName);
			Map<String, Object> param = new HashMap<String, Object>();
			AccountWithBLOBs optAccount = null;
//	        AccountWithBLOBs optAccount = this.getCurLoginAccount();
	        param.put("optAccountId", optAccount == null ? "" : optAccount.getId().toString());
			param.put("parameter", this.request.getParameterMap());
			param.put("method", this.request.getMethod());
			param.put("protocol", this.request.getProtocol());
			param.put("cookies", this.request.getCookies());
			param.put("url", this.request.getHeader("referer"));

			log.setParameter(gson.toJson(param));
			log.setSysErrorMssage(e.toString() + "  " + StringUtil.getExceptionStackTrace(e));
			
			exceptionLogMapper.insertSelective(log);
			
			//send email to administrator
			String subject = "IP: "+InetAddress.getLocalHost().getHostAddress()+", DATE: "+ DateUtil.getNow()+", ExceptionLogId: "+log.getId();
			String emailContent = subject + "\n"
					+ gson.toJson(param) + "\n" 
					+ StringUtil.getExceptionStackTrace(e);
//			
//			systemService.saveEmailNotice(PropertiesUtil.confProperties.getProperty("emailNotice.sender.mail"), 
//					PropertiesUtil.confProperties.getProperty("emailNotice.receiver.mail"),
//					null, null, subject, emailContent, Long.parseLong("1"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
	}
}
