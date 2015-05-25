package com.gmo.core.constant;

import java.util.HashMap;
import java.util.Map;
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
	
	/**
	 * 用户状态
	 */
	public static final String TERMINALUSER_STATUS_ONLINE = "ONLINE";//正常
	public static final String TERMINALUSER_STATUS_OFFLINE = "OFFLINE";//离线
	public static final String TERMINALUSER_STATUS_LOCKED = "LOCKED";//锁定
	


	public static final String USER_STATUS_ONLINE = "ONLINE";
	public static final String USER_STATUS_OFFLINE = "OFFLINE";

	/**
	 * 设备状态
	 */
	public static final String DEVICE_STATUS_ONLINE = "ONLINE";//正常
	public static final String DEVICE_STATUS_OFFLINE = "OFFLINE";//离线
	public static final String DEVICE_STATUS_LOCKED = "LOCKED";//锁定
	
	/**
	 * 设备类型3.0
	 * */
	public static final String DEVICE_TYPE_BAS = "BAS";
	public static final String DEVICE_TYPE_AC = "AC";
	public static final String DEVICE_TYPE_FIT_AP = "FIT_AP";
	public static final String DEVICE_TYPE_FAT_AP = "FAT_AP";
	public static final String DEVICE_TYPE_VLAN = "VLAN";
	
	/**
	 * 设备类型 2.8以前
	 */
	public static final String DEVICE_TYPE_CUSTOMIZED_AP = "CUSTOMIZED_AP";
	public static final String DEVICE_TYPE_STANDARD_AP = "STANDARD_AP";
	public static final String DEVICE_TYPE_THIRD_ACCESS = "THIRD_ACCESS";
	
	
	/**
	 * 用户认证日志状态
	 */
	public static final String TERMINALUSER_AUTH_LOG_STATUS_ONLINE = "ONLINE";//正常
	public static final String TERMINALUSER_AUTH_LOG_STATUS_OFFLINE = "OFFLINE";//离线
	

	/**
	 * 用户-设备状态
	 */
	public static final String TERMINALUSER_DEVICE_STATUS_NORMAL = "NORMAL";//正常
	public static final String TERMINALUSER_DEVICE_STATUS_LOCKED = "LOCKED";//锁定
	
	/**
	 * 数据库操作类型
	 */
	public static final String OPT_TYPE_INSERT = "Insert";
	public static final String OPT_TYPE_UPDATE = "Update";
	public static final String OPT_TYPE_DELETE = "Delete";
	
	/**
	 * 表名
	 */
	public static final String AAA_VIRTUAL_DEVICE_TBL = "aaa_virtual_device";
	public static final String ACCOUNT_HAS_TERMINAL_USER_TBL = "account_has_terminal_user";
	public static final String COMPONENT_TBL = "component";
	public static final String DEVICE_TBL = "device";
	public static final String DEVICE_GROUP_TBL = "device_group";
	public static final String DEVICE_HAS_DEVICE_GROUP_TBL = "device_has_device_group";
	public static final String DEVICE_MODEL_TBL = "device_model";
	public static final String LOCATION_TBL = "location";
	public static final String PRODUCED_DEVICE_TBL = "produced_devices";
	public static final String SSID_VIRTUAL_DEVICE_TBL = "ssid_virtual_device";
	public static final String TERMINAL_USER_TBL = "terminal_user";
	public static final String TERMINAL_USER_AUTHENTICATION_LOG_TBL = "terminal_user_authentication_log";
	public static final String TERMINAL_USER_HAS_DEVICE_TBL = "terminal_user_has_device";
	public static final String THIRD_PART_AUTH = "third_part_auth";
	public static final String THIRD_PLATFORM = "third_platform";
	public static final String USER_BLACKLIST = "user_blacklist";
	public static final String USER_WHITELIST = "user_whitelist";
	public static final String VLAN_VIRTUAL_DEVICE_TBL = "vlan_virtual_device";
	
	public static final String RADIUS_VIRTUAL_DEVICE_TBL = "radius_virtual_device";
	public static final String FIT_AP_VIRTUAL_DEVICE_TBL = "fit_ap_virtual_device";
	public static final String TELECOM_VIRTUAL_DEVICE_TBL = "telecom_virtual_device";
	
	
	
	//#######################################
	public static final String DEVICE_TASK_LOG_ID = "task_log_id";
	public static final String DEFAULT_EXPIRED_URL = "/device/taskexpired.htm";
	public static final String DEFAULT_CALLBACK_URL = "/device/taskfinished.htm";
	
	public static final String DEFAULT_API_EXPIRED_URL = "/api10/taskexpired.htm";
	public static final String DEFAULT_API_CALLBACK_URL = "/api10/taskfinished.htm";
	//#######################################
	/**
	 * 省份ID和省份名称键
	 */
	public static final String PROVINCE_ID = "PROVINCE_ID";
	public static final String PROVINCE_NAME = "PROVINCE_NAME";
	
	public static final String ACCOUNT_GEO_LEVEL_1 = "1";//全国级
	public static final String ACCOUNT_GEO_LEVEL_1_CN = "L1 - 全国";
	public static final String ACCOUNT_GEO_LEVEL_2 = "2";//省级
	public static final String ACCOUNT_GEO_LEVEL_2_CN = "L2 - 省级";
	public static final String ACCOUNT_GEO_LEVEL_3 = "3";//市级
	public static final String ACCOUNT_GEO_LEVEL_3_CN = "L3 - 市级";
	public static final String ACCOUNT_GEO_LEVEL_4 = "4";//区级
	public static final String ACCOUNT_GEO_LEVEL_4_CN = "L4 - 县区级";
	
	public static final String ACCOUNT_TYPE_SUPER_MAN_CN = "超级管理员";
	public static final String ACCOUNT_TYPE_SUPER_MAN_EN = "SUPER_MAN";
	public static final String ACCOUNT_TYPE_ADMINISTRATOR_CN = "管理员";
	public static final String ACCOUNT_TYPE_ADMINISTRATOR_EN = "ADMINISTRATOR";
	public static final String ACCOUNT_TYPE_REPRESENTATIVE_CN = "代理商"; 
	public static final String ACCOUNT_TYPE_REPRESENTATIVE_EN = "REPRESENTATIVE"; 
	public static final String ACCOUNT_TYPE_MERCHANT_CN = "商户";
	public static final String ACCOUNT_TYPE_MERCHANT_EN = "MERCHANT";
	public static final String ACCOUNT_TYPE_MANUFACTURER_CN = "设备厂商";
	public static final String ACCOUNT_TYPE_MANUFACTURER_EN = "MANUFACTURER";
	public static final String ACCOUNT_TYPE_DEVICE_ADMIN_CN = "设备管理员";
	public static final String ACCOUNT_TYPE_DEVICE_ADMIN_EN = "DEVICE_ADMIN";

	public static final String PERMISSION_SUBADMIN_MGMT_CN = "下属管理员管理";
	public static final String PERMISSION_SUBADMIN_MGMT_EN = "SUBADMIN_MGMT";
	public static final String PERMISSION_REPRESENTATIVE_MGMT_CN = "代理商管理";
	public static final String PERMISSION_REPRESENTATIVE_MGMT_EN = "REPRESENTATIVE_MGMT";
	public static final String PERMISSION_MERCHANT_MGMT_CN = "商户管理";
	public static final String PERMISSION_MERCHANT_MGMT_EN = "MERCHANT_MGMT";
	public static final String PERMISSION_MANUFACTURER_MGMT_CN = "设备厂商管理";
	public static final String PERMISSION_MANUFACTURER_MGMT_EN = "MANUFACTURER_MGMT";
	public static final String PERMISSION_DEVICE_ADMIN_MGMT_CN = "设备管理员管理";
	public static final String PERMISSION_DEVICE_ADMIN_MGMT_EN = "DEVICE_ADMIN_MGMT";
	public static final String PERMISSION_USER_MGMT_CN = "用户管理";
	public static final String PERMISSION_USER_MGMT_EN = "USER_MGMT";
	public static final String PERMISSION_DEVICE_MGMT_CN = "设备管理";
	public static final String PERMISSION_DEVICE_MGMT_EN = "DEVICE_MGMT";
	public static final String PERMISSION_PORTAL_MGMT_CN = "WiFi门户管理";
	public static final String PERMISSION_PORTAL_MGMT_EN = "PORTAL_MGMT";
	public static final String PERMISSION_PROFILE_MGMT_CN = "基本信息管理";
	public static final String PERMISSION_PROFILE_MGMT_EN = "PROFILE_MGMT";
	public static final String PERMISSION_SYSTEM_CFG_MGMT_CN = "系统配置管理";
	public static final String PERMISSION_SYSTEM_CFG_MGMT_EN = "SYSTEM_CFG_MGMT";
	public static final String PERMISSION_MANU_DEVICE_MGMT_CN = "厂商设备管理";
	public static final String PERMISSION_MANU_DEVICE_MGMT_EN = "MANU_DEVICE_MGMT";
	
	
	
	/**
	 * 服务端口号
	 */
	public static final String PLAT_HTTP_PORT = "httpPort";
	
	/**
	 * method type
	 */
	
	public static final String METHOD_TYPE_GET="GET";
	public static final String METHOD_TYPE_POST="POST";
	
	/**
	 * challenge result type
	 */
	public static final int TYPE_CHALLENGE_SUCCESS = 0;
	public static final int	TYPE_CHALLENGE_DENIED = 1;
	public static final int	TYPE_CHALLENGE_EXIST = 2;
	public static final int	TYPE_CHALLENGE_WAIT = 3;
	public static final int	TYPE_CHALLENGE_FAILED = 4;
	
	/**
	 * 模块名称
	 */
	public static final String MODULE_THIRD_PARTY = "thirdParty";
	
	/**
	 * 项目型平台第三方验证类型--0:短信认证，1：第三方认证
	 */
//	public static final String THIRD_PARTY_ACCESS_TYPE_MSG = "0";
//	public static final String THIRD_PARTY_ACCESS_TYPE_THIRD_PARTY = "1";
	public static final String[] THIRD_PARTY_ACCESS_TYPE = new String[]{"0","1"};
	
	/**
	 * 项目型平台第三方认证结果--0：成功， 1：失败
	 */
//	public static final String THIRD_PARTY_ACCESS_SATTUS_SUCCESS = "0";
//	public static final String THIRD_PARTY_ACCESS_STATUS_FAIL = "1";
	public static final String[] THIRD_PARTY_ACCESS_STATUS = new String[]{"0","1"};

	/**
	 * TOB平台返回结果code
	 */
	public static final double TOB_RESULT_CODE_OK = 0.0;
	public static final double TOB_RESULT_CODE_FAIL = 1.0;
	
	/**
	 * 淘WIFI请求类型：上线和下线
	 */
	public static final String TAO_WIFI_REQUEST_TYPE_LOGIN = "login";
	public static final String TAO_WIFI_REQUEST_TYPE_LOGOUT = "logout";
	
	/**
	 * 淘WIFI用户默认免登陆时间--7天，单位分钟
	 */
	public static final String TAO_WIFI_DEFAULT_ONLINE_TIME = "10080";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public static final Long TAO_WIFI_ID = 1L;
	
	/**
	 * client_mq数据收集通道
	 */
	public static final String CLIENT_MQ_RECEVER = "S400";
	
	/**
	 * 终端用户验证类型
	 */
	public static final String AUTH_TYPE_WECHAT = "WECHAT";
}