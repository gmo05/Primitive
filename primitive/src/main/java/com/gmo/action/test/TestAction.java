package com.gmo.action.test;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.gmo.base.BaseAction;

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
   	
		resultMap = this.getResult("呵呵","OK");
        return SUCCESS;
	}
}
