package com.gmo.action.test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.gmo.base.BaseAction;
import com.gmo.core.util.FileUtil;
import com.gmo.model.user.UserTrace;
import com.gmo.util.BeanToMapUtil;
import com.gmo.util.LoggerUtil;
import com.gmo.util.MD5Util;

@Controller
@Scope("prototype")
@Namespace("/test10")
public class TestAction extends BaseAction {
	
	private static final long serialVersionUID = 16426676657004142L;
	Logger logger  =  Logger.getLogger(this.getClass());
	Logger testlogger  = Logger.getLogger("mylogger1");

    /**
	 * test
	 * @return
     * @throws Exception 
	 */
	@Action(value = "test110", results = {
			@Result(name = SUCCESS, type = "json", params = { "root", "resultMap" })})
    public String useroffline() throws Exception {
		String path="C:\\Users\\Administrator\\Desktop\\";
   	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	 String userip = "192.168.10.105";
   	 	UserTrace userTrace = new UserTrace();
   	 	userTrace.setAuthType(userip);
   	 	userTrace.setAuthId2(userip);
   	 	userTrace.setAllotIp(userip);
   	 	userTrace.setActionType(userip);
   	 	userTrace.setCaptureTime(userip);
   	 	userTrace.setCollectSite(userip);
   	 	userTrace.setDataSourceName(userip);
   	 	String idStr =  userTrace.getAuthType()+"\t"+userTrace.getAuthId2()+"\t"+userTrace.getAllotIp()+"\t";
   	 	idStr = idStr+userTrace.getActionType()+"\t"+userTrace.getCaptureTime()+"\t"+userTrace.getCollectSite()+"\t"+userTrace.getDataSourceName();
   	 	idStr = MD5Util.getStringMD5String(idStr);
   	 	userTrace.setId(idStr);
   	 	LinkedHashMap<String, String> map = BeanToMapUtil.convertBean2(userTrace);
		String str = FileUtil.writeModelByMap(map);
		String name = StringUtils.EMPTY;
		name = "test"+userip+"traceLog.bcp";
		Logger tracelogger = LoggerUtil.getLoggerByName(name);
		tracelogger.info(str);
		resultMap = this.getResult("呵呵","OK");
        return SUCCESS;
	}
}
