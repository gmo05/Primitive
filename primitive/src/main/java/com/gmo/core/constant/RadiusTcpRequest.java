package com.gmo.core.constant;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmo.core.util.PropertiesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RadiusTcpRequest implements Callable<Map<String, Object>>{
	private String username;
	private String password;
	public RadiusTcpRequest(String username, String password){
		this.username = username;
		this.password = password;
	}
	public static Map<String, Object> createOrUpdateRadiusUser(String username, String password){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Socket socket = new Socket();
		String reqData = StringUtils.EMPTY;
//		String reqCharset = StringUtils.EMPTY; 	字符编码
		OutputStream out = null;      //写
		InputStream in = null;        //读
		try {
			
			socket.setTcpNoDelay(true);
			socket.setReuseAddress(true);
			socket.setSoTimeout(30000);
			socket.setSoLinger(true, 5);
			socket.setSendBufferSize(1024);
			socket.setReceiveBufferSize(1024);
			socket.setKeepAlive(true);
			String ip = PropertiesUtil.get("radius.server.ip");
			String port = PropertiesUtil.get("radius.server.port");
			
			socket.connect(new InetSocketAddress(ip, Integer.parseInt(port)), 30000);
			String localPort = String.valueOf(socket.getLocalPort());
			
			// 发送http请求
			out = socket.getOutputStream();
			Map<String, String> param = new HashMap<String, String>();
			param.put("command", "CreateOrUpdateUser");
			param.put("username", username);
			param.put("password", password);
			reqData = new Gson().toJson(param);
			reqData +="\r\n.\r\n";
			out.write(reqData.getBytes());
			
			// 接受http响应
			in = socket.getInputStream();
			BufferedReader rd = null;
			rd = new BufferedReader(new InputStreamReader(in));
			String line;
			String returnMessage = StringUtils.EMPTY;
			while ((line=rd.readLine())!=null){
				returnMessage+=line;
			}
			//returnMessage = returnMessage.replace("\r\n.\r\n", "");
			returnMessage = returnMessage.replace(".", "");
			//returnMessage = returnMessage.substring(0, returnMessage.indexOf("}")+1);
			
			System.out.println(returnMessage);
			resultMap = new Gson().fromJson(returnMessage, new TypeToken<Map<String, Object>>(){}.getType());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return resultMap;
	}
	
	public static Map<String, Object> createOrUpdateRadiusUser(String username, String password, String seconds){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Socket socket = new Socket();
		String reqData = StringUtils.EMPTY;
//		String reqCharset = StringUtils.EMPTY; 	字符编码
		OutputStream out = null;      //写
		InputStream in = null;        //读
		try {
			
			socket.setTcpNoDelay(true);
			socket.setReuseAddress(true);
			socket.setSoTimeout(30000);
			socket.setSoLinger(true, 5);
			socket.setSendBufferSize(1024);
			socket.setReceiveBufferSize(1024);
			socket.setKeepAlive(true);
			String ip = PropertiesUtil.get("radius.server.ip");
			String port = PropertiesUtil.get("radius.server.port");
			
			socket.connect(new InetSocketAddress(ip, Integer.parseInt(port)), 30000);
			String localPort = String.valueOf(socket.getLocalPort());
			
			// 发送http请求
			out = socket.getOutputStream();
			Map<String, String> param = new HashMap<String, String>();
			param.put("command", "CreateOrUpdateUser");
			param.put("username", username);
			param.put("password", password);
			param.put("expTime", seconds);
			reqData = new Gson().toJson(param);
			reqData +="\r\n.\r\n";
			out.write(reqData.getBytes());
			
			// 接受http响应
			in = socket.getInputStream();
			BufferedReader rd = null;
			rd = new BufferedReader(new InputStreamReader(in));
			String line;
			String returnMessage = StringUtils.EMPTY;
			while ((line=rd.readLine())!=null){
				returnMessage+=line;
			}
			//returnMessage = returnMessage.replace("\r\n.\r\n", "");
			returnMessage = returnMessage.replace(".", "");
			//returnMessage = returnMessage.substring(0, returnMessage.indexOf("}")+1);
			
			System.out.println(returnMessage);
			resultMap = new Gson().fromJson(returnMessage, new TypeToken<Map<String, Object>>(){}.getType());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return resultMap;
	}
	
	public static void main(String args[]){
		createOrUpdateRadiusUser("wang","wang");
	}

	@Override
	public Map<String, Object> call() throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap= createOrUpdateRadiusUser(username,password);
		return resultMap;
	}
}
