<script type="text/javascript">
	//window.location.href="${pageContext.request.contextPath}/account/login.htm";
	//window.location.href="${pageContext.request.contextPath}/account/main.htm";
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>access portal</title>
</head>
<body>
版本号：auth-3.0.004</br>
发布日期：2015.5.18 19:00</br>
发布说明：
调用短信网关增加返回值判断处理</br>
用户认证记录的创建时间更新，有验证时就更新</br>
免认证时不将登陆信息写入redis中</br>
微信短信修改（返回为json格式）</br>
bas/login中AC、BAS认证</br>
静态用户名密码resultMap空指针修正</br>
		验证日志字段保存</br>
</br>

版本号：auth-3.0.003</br>
发布日期：2015.5.13 09:25</br>
发布说明：portal协议2共享密钥默认为空</br>
</br>

版本号：auth-3.0.002</br>
发布日期：2015.5.11 15:48</br>
发布说明：微信临时放行加监控/br>
</br>

版本号：auth-3.0.002</br>
发布日期：2015.5.11 10:20</br>
发布说明：静态用户名密码登陆空指针异常以及外键关系异常修正</br>
                   微信认证图片添加， js以及配置文件wechat.auth.page路径修改</br>
</br>

版本号：auth-3.0.001</br>
发布日期：2015.5.7 16：40</br>
发布说明：静态用户认证用户查询不到问题修改</br>
</br>       
            
版本号：auth-3.0</br>
发布日期：2015.5.6 20：10</br>
发布说明：微信认证</br>
</br>
</body>
</html>