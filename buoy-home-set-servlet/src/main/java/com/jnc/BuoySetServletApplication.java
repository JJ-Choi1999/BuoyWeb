package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 我的设置服务
 * 功能说明: 获取相关信息并储存
 * 模块关联实体: 
 * (1)Users
 * 
 * 
 * 跳入模块URL: http://localhost:8201/set?usersname=${usersname}
 * 模块自身URL: http://localhost:8401/SetServlet
 * 模块跳出URL: http://localhost:8131/index?usersname=${usersname} 
 * 
 * 
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
public class BuoySetServletApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoySetServletApplication.class, args);
	}

}
