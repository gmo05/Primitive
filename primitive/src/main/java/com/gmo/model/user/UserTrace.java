package com.gmo.model.user;

public class UserTrace {
    private String id;

    private String authType;		//认证类型		1020004(手机号)
    private String authId1;			//认证帐号		上网终端的手机号
    private String authId2;			//认证帐号		上网终端的手机号
    private String passWord;		//密码		登录WIFI的密码
    private String callingNum;		//主叫号码 		留空	
    private String calledNum;		//被叫号码 		留空	
    private String allotIp;			//分配IP		私网IP
    private String actionType;		//动作类型		02(上线)  03(下线)
    private String ssid;			//国际移动用户标识号	WIFI的SSID，即WIFI网络标识
    private String imei;			//设备号		无线系统为移动设备号（G网IMEI，C网ESN或MEID）
    private String bsNum;			//基站号/AP编号
    private String localAgent;		//本地代理		PCF IP地址、移动的SGSN IP地址、WIFI:AP信息复用此字段
    private String proxyGateway;	//代理网关		PDSN IP地址、移动的GGSN IP地址、WIFI:AC信息复用此字段
    private String captureTime;		//截获时间		
    private String callingLocation;	//主叫位置		留空
    private String terMac;			//客户端MAC地址
    private String makerOrgCode;	//专用产品厂家组织机构代码		留空
    private String makerOrgName;	//专用专用产品厂家组织机构名称	留空
    private String operatorFlag;	//运营商标识	电信(01) 移动(06) 联通(03)
    private String uplinkTunnelNo;	//上行隧道号	无线系统隧道号，上、下行隧道号在同一条认证日志中
    private String downlinkTunnelNo;	//下行隧道号	无线系统隧道号，上、下行隧道号在同一条认证日志中。
    private String collectSite;	//采集地		330100(杭州) 330200(宁波)330300(温州) 330400(嘉兴)330500(湖州) 330600(绍兴)330700(金华) 330800(衢州)330900(舟山) 331000(台州)331100(丽水) 通过IP转成对应的地市编码
    private String firstCollectTime;	//首次采集时间		从1970年1月1日0:0:0开始到结束时间的绝对秒数
    private String latelyCollectTime;	//最近采集时间
    private String dataSourceName;		//数据来源名称		139(WIFI)
    private String sensitivityLevel;	//敏感级别
    private String oldDiscoverDays;		//累计发现天数		填写默认值1
    private String newDiscoverDays;		//新增发现天数		填写默认值1
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	public String getAuthId1() {
		return authId1;
	}
	public void setAuthId1(String authId1) {
		this.authId1 = authId1;
	}
	public String getAuthId2() {
		return authId2;
	}
	public void setAuthId2(String authId2) {
		this.authId2 = authId2;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getCallingNum() {
		return callingNum;
	}
	public void setCallingNum(String callingNum) {
		this.callingNum = callingNum;
	}
	public String getCalledNum() {
		return calledNum;
	}
	public void setCalledNum(String calledNum) {
		this.calledNum = calledNum;
	}
	public String getAllotIp() {
		return allotIp;
	}
	public void setAllotIp(String allotIp) {
		this.allotIp = allotIp;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getBsNum() {
		return bsNum;
	}
	public void setBsNum(String bsNum) {
		this.bsNum = bsNum;
	}
	public String getLocalAgent() {
		return localAgent;
	}
	public void setLocalAgent(String localAgent) {
		this.localAgent = localAgent;
	}
	public String getProxyGateway() {
		return proxyGateway;
	}
	public void setProxyGateway(String proxyGateway) {
		this.proxyGateway = proxyGateway;
	}
	public String getCaptureTime() {
		return captureTime;
	}
	public void setCaptureTime(String captureTime) {
		this.captureTime = captureTime;
	}
	public String getCallingLocation() {
		return callingLocation;
	}
	public void setCallingLocation(String callingLocation) {
		this.callingLocation = callingLocation;
	}
	public String getTerMac() {
		return terMac;
	}
	public void setTerMac(String terMac) {
		this.terMac = terMac;
	}
	public String getMakerOrgCode() {
		return makerOrgCode;
	}
	public void setMakerOrgCode(String makerOrgCode) {
		this.makerOrgCode = makerOrgCode;
	}
	public String getMakerOrgName() {
		return makerOrgName;
	}
	public void setMakerOrgName(String makerOrgName) {
		this.makerOrgName = makerOrgName;
	}
	public String getOperatorFlag() {
		return operatorFlag;
	}
	public void setOperatorFlag(String operatorFlag) {
		this.operatorFlag = operatorFlag;
	}
	public String getUplinkTunnelNo() {
		return uplinkTunnelNo;
	}
	public void setUplinkTunnelNo(String uplinkTunnelNo) {
		this.uplinkTunnelNo = uplinkTunnelNo;
	}
	public String getDownlinkTunnelNo() {
		return downlinkTunnelNo;
	}
	public void setDownlinkTunnelNo(String downlinkTunnelNo) {
		this.downlinkTunnelNo = downlinkTunnelNo;
	}
	public String getCollectSite() {
		return collectSite;
	}
	public void setCollectSite(String collectSite) {
		this.collectSite = collectSite;
	}
	public String getFirstCollectTime() {
		return firstCollectTime;
	}
	public void setFirstCollectTime(String firstCollectTime) {
		this.firstCollectTime = firstCollectTime;
	}
	public String getLatelyCollectTime() {
		return latelyCollectTime;
	}
	public void setLatelyCollectTime(String latelyCollectTime) {
		this.latelyCollectTime = latelyCollectTime;
	}
	public String getDataSourceName() {
		return dataSourceName;
	}
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
	public String getSensitivityLevel() {
		return sensitivityLevel;
	}
	public void setSensitivityLevel(String sensitivityLevel) {
		this.sensitivityLevel = sensitivityLevel;
	}
	public String getOldDiscoverDays() {
		return oldDiscoverDays;
	}
	public void setOldDiscoverDays(String oldDiscoverDays) {
		this.oldDiscoverDays = oldDiscoverDays;
	}
	public String getNewDiscoverDays() {
		return newDiscoverDays;
	}
	public void setNewDiscoverDays(String newDiscoverDays) {
		this.newDiscoverDays = newDiscoverDays;
	}

}
