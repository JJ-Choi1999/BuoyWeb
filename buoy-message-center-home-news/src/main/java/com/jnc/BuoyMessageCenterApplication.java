package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 新闻队列
 * 功能说明: 记录点击信息,并存入SQL
 * 模块关联实体: 
 * (1)Focus
 * 
 * 
 * 跳入模块URL: http://localhost:8391/NewsServlet?usersname=${usersname}&method=${method}&value=${value}&title=${title}&action=${action}
 * 模块自身URL: http://localhost:8591/
 * 模块跳出URL: 无
 * 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyMessageCenterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyMessageCenterApplication.class, args);
	}

}
