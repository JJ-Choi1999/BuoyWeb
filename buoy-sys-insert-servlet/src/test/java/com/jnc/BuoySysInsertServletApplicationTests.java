package com.jnc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BuoySysInsertServletApplication.class)
public class BuoySysInsertServletApplicationTests {

	@Test
	public void contextLoads() {
		
		System.out.println(mySwitch("编辑首张"));
		System.out.println(mySwitch("编辑"));
		System.out.println(mySwitch("视野港"));
		System.out.println(mySwitch("能力港"));
		System.out.println(mySwitch("人文社科港"));
		System.out.println(mySwitch("商业港"));
		System.out.println(mySwitch("科学港"));
		
	}
	
	
	public String mySwitch(String key) {
		
		String str=null;
		
		switch(key) {
			
			case "编辑首张":
				str="frist_viewpager";
			break;
			
			case "编辑":
				str="viewpager";
			break;
			
			case "视野港":
				str="horizon";
			break;
	
			case "能力港":
				str="ability";
			break;
			
			case "人文社科港":
				str="social";
			break;
			
			case "商业港":
				str="business";
			break;
			
			case "科学港":
				str="science";
			break;
			
		}
		
		return str;
	}
}
