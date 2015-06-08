package com.gmo.service.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.gmo.core.constant.Constants;
import com.gmo.core.util.PropertiesUtil;
import com.gmo.dao.system.SystemConfigMapper;
import com.gmo.model.system.SystemConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("systemService")
public class SystemService {


	@Resource(name = "systemConfigMapper")
	private SystemConfigMapper systemConfigMapper;
	
	

	

  
	/**
	 * 获取短信网关
	 * @param phoneNumber
	 * @return
	 */
	public String getSmsGW(String phoneNumber) {
		String gateWay = null;
		String telcomGW = null;
		String unicomGW = null;
		String mobileGW = null;

		List<SystemConfig> configList = this.getAllSystemConfigs();

		// 获取各运行商短信网关
		for (SystemConfig config : configList) {
			if (config.getCfgKey().equalsIgnoreCase(Constants.SYS_CFG_SMSGW_KEY)) {
				String allGateWays = config.getCfgValue();

				Map<String, Object> gwMap = new Gson().fromJson(allGateWays,new TypeToken<Map<String, Object>>(){}.getType());
				telcomGW = gwMap.get(Constants.TELCOM_EN_NAME).toString();
				unicomGW = gwMap.get(Constants.UNICOM_EN_NAME).toString();
				mobileGW = gwMap.get(Constants.MOBILE_EN_NAME).toString();
				break;
			}
		}

		// 电信网关
		Matcher telcom_matcher = Constants.TELCOM_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!telcom_matcher.matches()) {
			gateWay = telcomGW;
		}
		
		// 联通网关
		Matcher unicom_matcher = Constants.UNICOM_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!unicom_matcher.matches()) {
			if (StringUtils.isNotBlank(unicomGW)) {
				gateWay = unicomGW;
				
			} else {
				gateWay = telcomGW;
			}
		}
		
		// 移动网关
		Matcher mobile_matcher = Constants.MOBILE_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!mobile_matcher.matches()) {
			if (StringUtils.isNotBlank(mobileGW)) {
				gateWay = mobileGW;
				
			} else {
				gateWay = telcomGW;
			}
		}

		return gateWay;
	}
	
	/**
	 * 获取短信网关
	 * @param phoneNumber
	 * @return
	 */
	public String getSmsGWFromNoticeConfig(String phoneNumber) {
		String gateWay = null;
		String telcomGW = null;
		String unicomGW = null;
		String mobileGW = null;

		List<SystemConfig> configList = this.getAllSystemConfigs();
		String allGateWays = PropertiesUtil.confProperties.getProperty("sms.GW");
		// 获取各运行商短信网关
		Map<String, Object> gwMap = new Gson().fromJson(allGateWays,new TypeToken<Map<String, Object>>(){}.getType());
		telcomGW = gwMap.get(Constants.TELCOM_EN_NAME).toString();
		unicomGW = gwMap.get(Constants.UNICOM_EN_NAME).toString();
		mobileGW = gwMap.get(Constants.MOBILE_EN_NAME).toString();

		// 电信网关
		Matcher telcom_matcher = Constants.TELCOM_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!telcom_matcher.matches()) {
			gateWay = telcomGW;
		}
		
		// 联通网关
		Matcher unicom_matcher = Constants.UNICOM_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!unicom_matcher.matches()) {
			if (StringUtils.isNotBlank(unicomGW)) {
				gateWay = unicomGW;
				
			} else {
				gateWay = telcomGW;
			}
		}
		
		// 移动网关
		Matcher mobile_matcher = Constants.MOBILE_CELL_NUMBERS.matcher(phoneNumber);
		
		if (!mobile_matcher.matches()) {
			if (StringUtils.isNotBlank(mobileGW)) {
				gateWay = mobileGW;
				
			} else {
				gateWay = telcomGW;
			}
		}

		return gateWay;
	}

	/**
	 * 获取系统配置(目前有：sms_gateway，default_id，authType，sms_unit_price)
	 * @return
	 */
	public List<SystemConfig> getAllSystemConfigs() {
		return systemConfigMapper.getAllSystemConfigs(null);
	}



}
