package com.gmo.base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
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

import com.gmo.service.system.SystemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
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
	
	public static void main(String[] args) {
	}
}
