package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 注册视图
 * 功能描述: 输入用户名、密码、确认密码,并跳转注册服务
 * 关联实体:
 * (1)无
 * 
 * 跳入模块URL: http://localhost:8121/index
 * 模块自身URL: http://localhost:8100/register
 * 模块跳出URL: http://localhost:8300/RegisterServer
 * 
 * 
 * 异常:
 * (1)用户名输入格式错误(未实际完成)
 * (2)密码输入格式错误(未实际完成)
 * (3)用户名已存在
 * (4)二次密码输入不一致
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyRegisterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyRegisterApplication.class, args);
	}

}
