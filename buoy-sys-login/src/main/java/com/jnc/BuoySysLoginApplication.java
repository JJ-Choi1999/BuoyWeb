package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统登陆视图
 * 模块功能: 显示浮标后台管理系统登陆视图,点击登陆按钮链接到浮标后台管理系统登陆服务器
 * 模块关联实体: 无
 * 
 * 跳入模块URL: 无
 * 模块自身URL: http://localhost:8231/login
 * 模块跳出URL: http://localhost:8431/LoginServler
 * 
 * 模块定义异常:
 * (1)用户名输入错误
 * (2)密码输入错误
 * 
 * 备注:
 * (1)后台管理系统默认登录名=test,默认密码=123456;修改或查看密码在数据库DB_Buoy中的tb_administrators数据表中
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoySysLoginApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoySysLoginApplication.class, args);
	}

}
