package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆关于我们视图
 * 功能说明: 显示已登陆关于我们视图并发送点击焦点进入已登陆关于我们视图队列
 * 模块关联实体: 
 * (1)Users
 * (2)FristViewPager
 * 
 * 
 * 跳入模块URL: http://localhost:8131/index?usersname=${usersname}
 * 模块自身URL: http://localhost:8221/about?usersname=${usersname}
 * 模块跳出URL: http://localhost:8521/
 * 
 * 
 * 
 * @author JNC
 *
 */

//图片不能动态指定
@SpringBootApplication
public class BuoyAboutApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyAboutApplication.class, args);
	}

}
