package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 登陆服务
 * 功能说明: 获得用户名和密码,携带相应信息进入登陆队列
 * 模块关联实体: 
 * (1)Users
 * 
 * 跳入模块URL: http://localhost:8111/login
 * 模块自身URL: http://localhost:8311/LoginServer
 * 模块跳出URL: 
 * (1)已登陆首页: http://localhost:8131/index?usersname=${usersname}
 * (2)登陆队列: http://localhost:8511/
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyLoginServletApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyLoginServletApplication.class, args);
	}

}
