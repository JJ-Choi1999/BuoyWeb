package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 注册队列
 * 功能描述: 获得注册服务传输的信息并写入SQL
 * 关联实体:
 * (1)Users
 * (2)Focus
 * 
 * 跳入模块URL: http://localhost:8300/RegisterServer
 * 模块自身URL: http://localhost:8500/
 * 模块跳出URL: 无
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
