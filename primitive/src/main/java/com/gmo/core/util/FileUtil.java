package com.gmo.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gmo.core.util.rules.Rule;
 
/**
 *
 * @类名: FileUtil
 * @作用: yexq
 * @日期: 2015-5-18 16:43:31
 */
 
public class FileUtil {
	  //写文件，支持中文字符，在linux redhad下测试过
    public static void writeLog(String str,String path,boolean type)
    {
        try
        {
        File file=new File(path);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,type); //如果追加方式用true        
        StringBuffer sb=new StringBuffer();
        sb.append(str+"\n");
        out.write(sb.toString().getBytes("utf-8"));//注意需要转换对应的字符集
        out.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }    
    public static String readLog()
    {
        StringBuffer sb=new StringBuffer();
        String tempstr=null;
        try
        {
            String path="/root/test/testfilelog.log";
            File file=new File(path);
            if(!file.exists())
                throw new FileNotFoundException();            
//            BufferedReader br=new BufferedReader(new FileReader(file));            
//            while((tempstr=br.readLine())!=null)
//                sb.append(tempstr);    
            //另一种读取方式
            FileInputStream fis=new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            while((tempstr=br.readLine())!=null)
                sb.append(tempstr);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }
    
    /** *//**
	   * 读取源文件内容
	   * @param filename String 文件路径
	   * @throws IOException
	   * @return byte[] 文件内容
	   */
	public static byte[] readFile(String filename) throws IOException {

	    File file =new File(filename);
	    if(filename==null || filename.equals("")){
	      throw new NullPointerException("无效的文件路径");
	    }
	    long len = file.length();
	    byte[] bytes = new byte[(int)len];

	    BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
	    int r = bufferedInputStream.read( bytes );
	    if (r != len)
	      throw new IOException("读取文件不正确");
	    bufferedInputStream.close();

	    return bytes;

	}
	
	/**
	 * 写文件模版
	 * @param list
	 * @return
	 */
	public static String writemodel1(List<String> list) {
		String str=new String();
		for(int i=0;i<list.size();i++) {
			str =str+"["+list.get(i)+"]";
		}
		return str;
	}
	public static String writemodel2(String userip,String usermac,String devId,String apmac) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LinkedHashMap<String, String> infoMap = new LinkedHashMap<String, String>();
		infoMap.put("date", sdf.format(new Date()));
        infoMap.put("userip", userip == null?"":userip);
        infoMap.put("usermac", usermac == null?"":usermac);
        infoMap.put("devId", devId == null?"":devId);
        infoMap.put("apmac", apmac== null?"":apmac);
		String str = writeModelByMap(infoMap);
		return str;
	}
	
	/**
	 * 写文件模版
	 * @param infoMap
	 * @return
	 */
	public static String writeModelByMap(LinkedHashMap<String, String> infoMap) {
		String str=new String();
		for (Entry<String, String> entry : infoMap.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    str =str+key+"="+value;
		}
//		str=str.substring(0,str.length()-2);
		return str;
	}
	

	public static void recordUserinfo(String path,String userip,String usermac,String devId,String apmac) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LinkedHashMap<String, String> infoMap = new LinkedHashMap<String, String>();
		infoMap.put("date", sdf.format(new Date()));
        infoMap.put("userip", userip == null?"":userip);
        infoMap.put("usermac", usermac == null?"":usermac);
        infoMap.put("devId", devId == null?"":devId);
        infoMap.put("apmac", apmac== null?"":apmac);
		String str = writeModelByMap(infoMap);
		writeLog(str,path,true);
	}
	
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	String path="C:\\Users\\Administrator\\Desktop\\testfilelog.log";
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 String ip = "192.168.10.105";
    	/* List<String> list = new ArrayList<String>();
    	 list.add(sdf.format(new Date()));
    	 list.add(ip);
    	 String str = writemodel1(list);
        writeLog(str,path,true);*/
       recordUserinfo(path,ip,"123456DC4C1E","1",null);
    }
}