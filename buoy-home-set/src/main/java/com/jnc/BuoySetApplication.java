package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 我的设置视图
 * 功能说明: 显示相关信息并显示
 * 模块关联实体: 
 * (1)Users
 * 
 * 
 * 跳入模块URL: http://localhost:8131/index?usersname=${usersname}
 * 模块自身URL: http://localhost:8201/set?usersname=${usersname}
 * 模块跳出URL:
 * (1)保存: http://localhost:8401/SetServlet 
 * (2)返回: http://localhost:8131/index?usersname=${usersname} 
 * (3)退出: http://localhost:8402/ExitServlet?usersname=${usersname}
 * 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
public class BuoySetApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoySetApplication.class, args);
	}

}
