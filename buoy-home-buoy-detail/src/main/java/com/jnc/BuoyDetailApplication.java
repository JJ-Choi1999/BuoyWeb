package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 已登陆浮标服务
 * 功能说明: 显示相关信息
 * 模块关联实体: 
 * (1)MsgHorizon
 * (2)MsgAbility
 * (3)MsgSocial
 * (4)MsgBusiness
 * (5)MsgScience
 * (6)Users
 * (7)FristViewPager
 * 
 * 
 * 跳入模块URL: http://localhost:8161/buoy?usersname=${usersname}
 * 模块自身URL: http://localhost:8171/detail?usersname=${usersname}&action=${action} 
 * 模块跳出URL: 无 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyDetailApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyDetailApplication.class, args);
	}

}
