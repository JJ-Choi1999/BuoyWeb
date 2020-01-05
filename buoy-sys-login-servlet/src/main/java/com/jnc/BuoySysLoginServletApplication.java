package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统登陆服务器
 * 模块功能: 判断用户名和密码是否输入正确,正确则跳转浮标后台管理系统添加视图,
 * 错误则回滚到浮标后台管理系统登陆视图并显示相应异常
 * 模块关联实体: Administrators
 * 
 * 跳入模块URL: http://localhost:8231/login
 * 模块自身URL: http://localhost:8431/LoginServler
 * 模块跳出URL: 
 * (1)判断用户名和密码输入正确: http://localhost:8241/insert?method=viewpager&value=viewpager //浮标后台管理系统添加视图
 * (2)判断用户名和密码输入错误:
 *  a.判断用户名输入错误: http://localhost:8231/login?exception=ioUsersnameException	//回滚到浮标后台管理系统登陆视图并显示用户名输入错误异常
 *  b.密码输入输入错误: http://localhost:8231/login?exception=ioPasswordException	//回滚到浮标后台管理系统登陆视图并显示密码输入错误异常
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoySysLoginServletApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoySysLoginServletApplication.class, args);
	}

}
