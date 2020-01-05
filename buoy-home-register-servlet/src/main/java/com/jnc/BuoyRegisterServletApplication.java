package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 注册服务
 * 功能描述: 判断用户名、密码、确认密码输入形式是否正确并将信息写入注册队列
 * 关联实体:
 * (1)Users
 * 
 * 
 * 跳入模块URL: http://localhost:8100/register
 * 模块自身URL: http://localhost:8300/RegisterServer
 * 模块跳出URL: 
 * (1)已登陆首页: http://localhost:8131/index?usersname=${usersname}
 * (2)注册队列: http://localhost:8500/
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyRegisterServletApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyRegisterServletApplication.class, args);
	}

}
