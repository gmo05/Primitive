package com.gmo.core.constant;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmo.core.util.DateUtil;
import com.gmo.core.util.PropertiesUtil;
import com.gmo.core.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 类HttpRequest.java的实现描述：
 * http 请求工具类 
 */
public class HttpRequest {
    private static Logger logger = LoggerFactory.getLogger(HttpRequest.class);
    private static int CONN_TIMEOUT = 5 * 1000; //连接延时
    private static String ENCODE_UTF8 = "UTF-8";
    
	/**
	 * Post请求
	 * @param path
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static boolean sendRequest(String requestMethod, String path, Map<String, String> params) throws Exception {
	    InputStream inputStream = null;
	    if(StringUtils.isBlank(requestMethod)){
	        logger.warn("request method is not null.({})", requestMethod);
	        return false;
	    }else if( "post".equals(requestMethod.toLowerCase()) ){
	        inputStream = sendPostRequest(path, params);
	    }else if( "get".equals(requestMethod.toLowerCase()) ){
//            inputStream = sendGetRequest(path, params);
        }else{
            logger.warn("request method must equal (post or get). but it's ({})", requestMethod);
            return false;
        }
		if (inputStream != null) {
		    ByteBuffer buff = parseInputStream(inputStream);
		    if(logger.isDebugEnabled()){
		        logger.debug(new String(buff.array(), ENCODE_UTF8));
		    }
			return true;
		}
		return false;
	}
	
	public static InputStream sendPostRequest(String path, Map<String, String> params) throws IOException{
	    //拼装请求参数
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append('=').append(
//                      URLEncoder.encode(entry.getValue(), ENCODE_UTF8)).append('&');
            		URLEncoder.encode(entry.getValue()== null ? StringUtils.EMPTY : entry.getValue(), ENCODE_UTF8)).append('&');
        }
        int idx = path.indexOf("?");
        if( idx > -1){
        	sb.append(path.substring(idx+1));
        	path = path.substring(0,idx);
        }
//        if(sb.length() > 0){
//        	sb.deleteCharAt(sb.length() - 1);
//        }
        
        byte[] entityData = sb.toString().getBytes();
        logger.debug("http post send, url({}), params({})", path, sb);
        return sendPostRequest(path, entityData);
	}
	
	public static InputStream sendPostRequest(String path, byte[] body) throws IOException{
	    URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(body.length));
        conn.setConnectTimeout(CONN_TIMEOUT);
        
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(body);
        outputStream.flush();
        outputStream.close();
        
        logger.debug("http response code ({})...", conn.getResponseCode());
        if (conn.getResponseCode() == 200) {
            return conn.getInputStream();
        }else{
            ByteBuffer buff = parseInputStream(conn.getErrorStream());
            logger.error("http request error. {}", new String(buff.array(), ENCODE_UTF8));
        }
        return null;
	}
	
	/**
	 * 将inputStream 读取 成 ByteBuffer。
	 * @param inputStream
	 * @throws IOException 
	 */
	public static ByteBuffer parseInputStream(InputStream inputStream) throws IOException{
	    DataInputStream inStream = new DataInputStream(inputStream);
	    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] byts = new byte[1024];
        int len = 0;
        while ( (len = inStream.read(byts)) >= 0 ) {
        	outStream.write(byts, 0, len);
        }
        inStream.close();
        return ByteBuffer.wrap(outStream.toByteArray());
	}
	
	/**
     * 客户端用Get方法向服务器提交请求,并获取服务器响应信息
     * @param path
     * @param params
     */
    public static ByteBuffer sendGetRequest(String path, Map<String, String> params) {
        try {
            StringBuilder sb = new StringBuilder();
            if(params != null && params.size() > 0){
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    sb.append(entry.getKey()).append('=').append(
                              URLEncoder.encode(entry.getValue(), ENCODE_UTF8)).append('&');
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            URL url = (path.indexOf("?") > -1) ? new URL(path + "&" + sb.toString())
            						: new URL(path + "?" + sb.toString());
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            // 默认情况下是false;
            httpUrlConn.setDoOutput(false);
            // 设置是否从httpUrlConnection读入，默认情况下是true
            httpUrlConn.setDoInput(true);
            // Get 请求不能使用缓存
            httpUrlConn.setUseCaches(false);
            // 设定请求的方法为"GET"，默认是GET
            httpUrlConn.setRequestMethod("GET");
            return parseInputStream(httpUrlConn.getInputStream());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
	
    /**
     * 从输入流中读入数据
     * @param in
     */
    public static String readBuffer(InputStreamReader in) {
        BufferedReader reader = new BufferedReader(in);
        try {
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return StringUtils.trimToEmpty(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }finally{
            try {
                reader.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return "";
    }
    
    public static Map<String, Object> createOrUpdateRadiusUser(String username, String password) throws Exception{
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> radiusParam = new HashMap<String, String>();
		String authId =  DateUtil.formatToString(new Date(), DateUtil.YYYYMMDDHHMMSS).substring(4, 12)
                + UUID.randomUUID().toString().replace("-", "").substring(0, 3).toUpperCase();
		
		String radiusServer = PropertiesUtil.get("radius.server");
		String radiusPath = PropertiesUtil.get("radius.createRadiusUser");
		String radiusCreateOrUpdateUserParam = "command=" + URLEncoder.encode("CreateOrUpdateUser", "UTF-8"); 
		radiusCreateOrUpdateUserParam += "&username=" + URLEncoder.encode(username, "UTF-8");
        radiusCreateOrUpdateUserParam += "&password=" + URLEncoder.encode(password, "UTF-8");
        
        radiusCreateOrUpdateUserParam += "\r\n.\r\n";
        byte[] entryData = radiusCreateOrUpdateUserParam.getBytes();
        String path = radiusServer+radiusPath;
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(entryData.length));
        conn.setConnectTimeout(CONN_TIMEOUT);
        
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(entryData);
        outputStream.flush();
        outputStream.close();
        BufferedReader rd = null;
        String returnMessage = null;
        if (conn.getResponseCode() == 200) {
        	rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                returnMessage += line;
            }
        }else{
            ByteBuffer buff = HttpRequest.parseInputStream(conn.getErrorStream());
        }
      return resultMap = new Gson().fromJson(returnMessage, new TypeToken<Map<String, String>>(){}.getType());

    }
    
}
