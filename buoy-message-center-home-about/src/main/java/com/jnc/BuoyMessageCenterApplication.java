package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆关于我们视图队列
 * 功能说明: 获取信息并存入相关SQL
 * 模块关联实体: 
 * (1)Focus
 * 
 * 
 * 跳入模块URL: http://localhost:8221/about?usersname=${usersname}
 * 模块自身URL: http://localhost:8521/
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
