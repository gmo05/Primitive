package com.gmo.util.macTest;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gmo.core.constant.HttpRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class macTest {
	
	@Test
	public void macAuthTest(){
		String url = "http://localhost:8080/bas/loginmac.htm";
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_ip", "60.176.142.184");
		map.put("auth_id", "18042000643");
		map.put("ac_name", "AC-HZ-115-9");
		map.put("auth_type", "macauth");
		map.put("site_id", "1234");
		map.put("mac", "28D244D8514B");//新华  ：28D244D8514B
		map.put("dev_id", "RADIUS-RADIUS-20141022-86ead3d2");
		map.put("getResultRequest", "1234");
		
		ByteBuffer receiveMsg = HttpRequest.sendGetRequest(url, map);
		
		System.err.println("-----------------------:"+ receiveMsg);
	}
}
