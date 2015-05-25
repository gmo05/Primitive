package com.gmo.core.util.rules;

import org.apache.commons.lang.StringUtils;

import com.gmo.core.util.PropertiesUtil;

public class Numeric extends Rule {
	
	public Numeric() {
		
	}
	
	@Override
	public boolean valid() throws Exception {
		if(this.getValue() == null || this.getValue().equals("")){
			return true;
		}else{
			if (StringUtils.isNumeric(this.getValue())) {
				return true;
			}
			else {
				this.setMessage(PropertiesUtil.confProperties.getProperty("rule.numeric"));
				return false;
			}
		}
	}

}
