package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 首页调节器
 * 功能描述: 根据物理地址判断用户是否在该台设备上登陆过,以此为根据调配已登陆首页和未登陆首页
 * 
 * 跳入模块URL: 无
 * 模块自身URL: http://localhost:8000/Regulator
 * 模块跳出URL: 
 * (1)未登录首页: http://localhost:8121/index
 * (2)已登陆首页: http://localhost:8131/index
 * 
 * @author 590
 *
 */
@SpringBootApplication
public class BuoyRegulatorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyRegulatorApplication.class, args);
	}

}
