package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆浮标视图
 * 功能说明: 显示相关信息视图并将点击焦点发送至已登陆浮标队列
 * 模块关联实体: 
 * (1)Users
 * (2)FristViewPager
 * 
 * 
 * 跳入模块URL: http://localhost:8131/index?usersname=${usersname}
 * 模块自身URL: http://localhost:8161/buoy?usersname=${usersname} 
 * 模块跳出URL: 
 * (1)已登陆浮标队列: http://localhost:8561/
 * (2)相应报表: http://localhost:8171/detail?usersname=${usersname}&action=${action}
 * 
 * 
 * @author JNC
 *
 */


@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyApplication.class, args);
	}

}
