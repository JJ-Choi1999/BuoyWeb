package com.jnc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuoyNewsServletApplication.class)
public class BuoyNewsServletApplicationTests {

	@Test
	public void contextLoads() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");//设置日期格式
		//new Date().getTime(); 获取时间戳
		String date = df.format(new Date().getTime());// new Date()为获取当前系统时间，也可使用当前时间戳
		String date01=new Date().getTime()+"";
		System.out.println("格式化形式:"+date+"\n时间戳形式:"+date01);
	}

}
