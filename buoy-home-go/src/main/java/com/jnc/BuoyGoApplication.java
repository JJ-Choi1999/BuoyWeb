package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆启航视图
 * 功能说明: 显示相关信息并发送焦点去已登陆启航队列
 * 模块关联实体: 
 * (1)Users
 * (2)FristViewPager
 * 
 * 
 * 跳入模块URL: http://localhost:8131/index?usersname=${usersname}
 * 模块自身URL: http://localhost:8141/go?usersname=${usersname} 
 * 模块跳出URL: 
 * (1)已登陆启航队列: http://localhost:8541/
 * (2)视野港: http://localhost:8171/detail?usersname=${usersname}&method=msg&value=horizon
 * (3)能力港: http://localhost:8171/detail?usersname=${usersname}&method=msg&value=ability
 * (4)人文社科港: http://localhost:8171/detail?usersname=${usersname}&method=msg&value=social
 * (5)商学港: http://localhost:8171/detail?usersname=${usersname}&method=msg&value=business
 * (6)科学港: http://localhost:8171/detail?usersname=${usersname}&method=msg&value=science
 * 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyGoApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyGoApplication.class, args);
	}

}
