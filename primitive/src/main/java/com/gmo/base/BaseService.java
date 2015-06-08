package com.gmo.base;

import java.util.HashMap;
import java.util.Map;



import com.google.gson.Gson;

public class BaseService {

	
	public Gson gson = new Gson();
	/**
	 * 默认sql执行结果影响记录数
	 */
	protected int result = 0;
	

	
	protected Map<String, Object> getResult(String message, String result){
        Map<String, Object> rltMap = new HashMap<String, Object>();
        rltMap.put("message", message);
        rltMap.put("result", result);
    	return rltMap;
    }
    
    protected Map<String, Object> getResult(String message){
        Map<String, Object> rltMap = new HashMap<String, Object>();
        rltMap.put("message", message);
        rltMap.put("result", "FAIL");
    	return rltMap;
    }
    
    protected Map<String, Object> getResult(){
    	Map<String, Object> rltMap = new HashMap<String, Object>();
        rltMap.put("result", "OK");
    	return rltMap;
    }

}
