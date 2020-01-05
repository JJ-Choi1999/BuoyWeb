package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆浮标队列
 * 功能说明: 捕捉焦点写入SQL
 * 模块关联实体: 
 * (1)Focus
 * 
 * 
 * 跳入模块URL: http://localhost:8161/buoy?usersname=${usersname} 
 * 模块自身URL: http://localhost:8561/
 * 模块跳出URL: 无
 * 
 * 
 * 
 * @author JNC
 *
 */


@SpringBootApplication
public class BuoyMessageCenterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyMessageCenterApplication.class, args);
	}

}
