package com.gmo.service.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.gmo.dao.system.SystemVersionMapper;
import com.gmo.dao.system.ThirdPartAuthMapper;
import com.gmo.model.system.ThirdPartAuth;
import com.gmo.core.constant.Constants;
import com.gmo.core.util.PropertiesUtil;
import com.gmo.dao.system.SystemConfigMapper;
import com.gmo.model.system.Sms;
import com.gmo.model.system.SystemConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gmo.dao.system.ThirdPlatformMapper;
import com.gmo.model.system.ThirdPlatform;

@Service("systemService")
public class SystemService {


	@Resource(name = "systemConfigMapper")
	private SystemConfigMapper systemConfigMapper;
	
	@Resource(name = "thirdPartAuthMapper")
	private ThirdPartAuthMapper thirdPartAuthMapper;
	
	@Resource(name="thirdPlatformMapper")
	private ThirdPlatformMapper thirdPlatformMapper;
	 
	@Resource(name="systemVersionMapper")
    private SystemVersionMapper systemVersionMapper;
	
	/**
	 * 获取所有的third_part_auth记录的ID
	 * @return
	 */
	public List<String> getAllThirdPartAuthVirtualDeviceIds() {
		List<String> virtualDeviceIds = null;
		List<ThirdPartAuth> allAuths = this.getAllThirdPartAuth();
		
		if (allAuths != null && allAuths.size() > 0) {
			virtualDeviceIds = new ArrayList<String>();
			
			for (ThirdPartAuth auth : allAuths) {
				virtualDeviceIds.add(auth.getVirtualDeviceId());
			}
		}

		return virtualDeviceIds;
	}
	
	/**
	 * 获取所有的third_part_auth记录
	 * @return
	 */
	public List<ThirdPartAuth> getAllThirdPartAuth() {
		return this.thirdPartAuthMapper.getAll();
	}
	
	/*
     * 
     * 根据platformCode取得欢迎页的URL
     */
    public ThirdPlatform selectURLByCode(String platformCode){
        return thirdPlatformMapper.selectURLByCode(platformCode);
    }
    
	/**
	 * 根据设备ID获取第三方设备对象
	 * @param deviceId	设备ID
	 * @return
	 */
	public ThirdPartAuth getThirdPartAuthByDeviceId(String deviceId) {
		ThirdPartAuth thirdPartAuth = null;

		if (StringUtils.isNotBlank(deviceId)) {
			thirdPartAuth = this.thirdPartAuthMapper.selectByDeviceId(deviceId);
		}

		return thirdPartAuth;
	}

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

	
	 public ThirdPlatform selectByDomain(String domain){
    	return thirdPlatformMapper.selectByDomain(domain);
    }
	 
	 public String getLatestVersion(){
		return systemVersionMapper.getLatestVersion();
	}
	 
 	/**
	 * 新增第三方app认证请求放行记录
	 * @param domain
	 * @return 
	 */
	public long saveThirdPartyLog(ThirdPartAuth record){
		return this.thirdPartAuthMapper.insertThirdPartLog(record);
	}
	
	/**
	 * 根据id更新app认证请求放行记录的状态
	 * @param domain
	 * @return
	 */
	public void updateThirdPartyLogStatus(ThirdPartAuth record){
		this.thirdPartAuthMapper.updateThirdPartLogById(record);
	}
}
