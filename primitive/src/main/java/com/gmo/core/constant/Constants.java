package com.gmo.core.constant;

import java.util.regex.Pattern;



/**
 * 常量
 * @ClassName Constants
 * @CreateDate 2014-3-19
 * @Version V1.0
 */
public final class Constants {
	
	private Constants() {}
	
	public static final Long SUPER_ADMIN_ACCOUNT_ID = new Long("1");
	
	/**
	 * 用户登录后存放用户信息的Session名
	 */
	public static final String LOGIN_ACCOUNT_INFO = "login_account_info";
	
	/**
	 * 认证长度
	 */
	public static final int AUTH_TOKEN_LENGTH = 10;
	public static final int AUTH_CODE_LENGTH = 6;
	
	/**
	 * portal协议超时时间
	 */
	public static final int AUTH_PORTAL_TIMEOUT = 15;
	
	/**
	 * 站点认证方式
	 */
	public static final String PORTAL_AUTH_TYPE_3RD_PART_MOBILE = "3RD_PART_MOBILE";
	public static final String PORTAL_AUTH_TYPE_CHINANET_MOBILE = "CHINANET_MOBILE";
	public static final String PORTAL_AUTH_TYPE_MOBILE = "MOBILE";
	public static final String PORTAL_AUTH_TYPE_WECHAT = "WECHAT";
	public static final String PORTAL_AUTH_TYPE_EMAIL = "EMAIL";
	public static final String PORTAL_AUTH_TYPE_USERPWD = "USERPWD";
	public static final String PORTAL_AUTH_TYPE_OPTION = "OPTION";
	public static final String PORTAL_AUTH_TYPE_EXTEND = "EXTEND";
	public static final String PORTAL_AUTH_TYPE_APPMOBILE = "APPMOBILE";
	//静态用户认证
	public static final String PORTAL_AUTH_TYPE_STATICUSER = "STATICUSER";
	
	/**
	 * 语言选择
	 */
	public static final String LANGUAGE_CN = "CN";
    public static final String LANGUAGE_CHINESE = "CHINESE";
    public static final String LANGUAGE_EN = "EN";
    public static final String LANGUAGE_ENGLISH = "ENGLISH";
    
    /**
	 * 系统默认所有帐号都是超级管理员的子帐号
	 */
	public static final String DEFAULT_PARENTIDS= "{\"directParentIds\":[\"1\"], \"totalParentIds\":[\"1\"]}";
	
	/**
	 * 第三方接入认证
	 */
	public static final String THIRD_PART_AUTH_STATUS_NORMAL = "NORMAL";
	public static final String THIRD_PART_AUTH_STATUS_LOCKED = "LOCKED";
	
	/**
	 * 二级平台（第三方平台）认证方式
	 */
	public static final String APP_AUTH_TYPE_THIRD = "THIRD_AUTH";//二级平台认证-接口对接方式
	public static final String APP_AUTH_TYPE_AAA = "AAA_AUTH";//AAA认证
	public static final String APP_AUTH_TYPE_AP = "AP_AUTH";//胖AP认证
	public static final String APP_AUTH_TYPE_AC = "AC_AUTH";//AC直连认证
	
    /**
	 * 正则表达式
	 */
	//^(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])$
	//\\b((?!\\d\\d\\d)\\d+|0\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|0\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|0\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|0\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\b
	public static final Pattern IP_PATTERN = Pattern.compile("^(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])$");
	//邮箱
	public static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"); 
	//手机号码
	public static final Pattern CELLPHONE_PATTERN = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
	//日期
	public static final Pattern DATE_PATTERN = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
	//UUID
	public static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}$");
	//MAC
	public static final Pattern MAC_PATTERN = Pattern.compile("^[0-9A-F]{12}$");
	//HOUR
	public static final Pattern HOUR_PATTERN = Pattern.compile("^([1]?[0-9])|2[0-3]$");
	
	//Number
	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
	//只能为英文、数字或半角字符
	public static final Pattern AC_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]|[\u0000-\u00FF]+$");
	
    /**
	 * 电信- 手机号码段 （2G号段（CDMA网络）133、153， 3G号段（CDMA2000网络）180、181、189， 虚拟运营商-1700）
	 */
	public static final Pattern TELCOM_CELL_NUMBERS = Pattern.compile("^[1](33|53|8[0-1]|89)[0-9]{8}|[1](700)[0-9]{7}$");
	public static final String TELCOM_EN_NAME = "TELCOM";
	/**
	 * 联通- 手机号码段 （2G号段（GSM网络）130、131、132、155、156，3G号段（WCDMA网络）185、186， 4G号段 176， 虚拟运营商-1709）
	 */
	public static final Pattern UNICOM_CELL_NUMBERS = Pattern.compile("^[1](3[0-2]|5[5-6]|8[5-6]|76)[0-9]{8}|[1](709)[0-9]{7}$");
	public static final String UNICOM_EN_NAME = "UNICOM";
	/**
	 * 移动- 手机号码段 （139、138、137、136、135、134x（0-8）、159、158、152、151、150、182、183、184，3G号段（WCDMA网络）157、188、187， 4G号段 178， 虚拟运营商-1705）
	 */
	public static final Pattern MOBILE_CELL_NUMBERS = Pattern.compile("^[1](3[5-9]|5[0-2]|5[7-9]|8[2-4]|8[7-8]|78)[0-9]{8}|[1](34[0-8]|709)[0-9]{7}$");
	public static final String MOBILE_EN_NAME = "MOBILE";
	/**
	 * 默认短信网关
	 */
	public static final String SMS_GATEWAY = "http://122.224.104.155:8009/SMGPService.asmx/SendMsg?tell=%s&msg=%s";
	
	/**
	 * 短信网关系统配置 key
	 */
	public static final String SYS_CFG_SMSGW_KEY = "sms_gateway";
	
	/**
	 * 组件状态
	 */
	public static final String COMPONENT_STATUS_NORMAL = "NORMAL";
	public static final String COMPONENT_STATUS_LOCKED = "LOCKED";
	public static final String COMPONENT_STATUS_DELETED = "DELETED";
	public static final String COMPONENT_STATUS_DRAFT = "DRAFT";
	
	public static final String COMPONENT_TYPE_FIRMWARE = "FIRMWARE";
	public static final String COMPONENT_TYPE_COMPONENT_PORTAL = "COMPONENT_PORTAL";
	public static final String COMPONENT_TYPE_COMPONENT_TASK = "COMPONENT_TASK";

    public static final String DEVICE_SERVICE_NAME_PORTAL = "twifi-portal";
    public static final String DEVICE_SERVICE_NAME_TASK = "twifi-task";

	public static final String COMPONENT_SUPPORTED_BRAND = "brand";
	public static final String COMPONENT_SUPPORTED_MODEL = "model";
	
	/**
	 * 缩略图生成 成功
	 */
	public static final String THUMB_GENE_STD_RESULT ="wkhtmltoimage execution result: '0'";
	public static final String THUMB_RESIZE_SUCCESS = "resize thumbnail successfully";
	


	
	
	
	//#######################################
	public static final String DEVICE_TASK_LOG_ID = "task_log_id";
	public static final String DEFAULT_EXPIRED_URL = "/device/taskexpired.htm";
	public static final String DEFAULT_CALLBACK_URL = "/device/taskfinished.htm";
	
	public static final String DEFAULT_API_EXPIRED_URL = "/api10/taskexpired.htm";
	public static final String DEFAULT_API_CALLBACK_URL = "/api10/taskfinished.htm";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
}