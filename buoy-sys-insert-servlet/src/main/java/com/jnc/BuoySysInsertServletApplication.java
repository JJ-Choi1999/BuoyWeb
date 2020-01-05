package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统添加服务
 * 模块功能: 获得title,context,img(可选)并通过method和value异步发送相应消息队列,并跳转至后台管理查询页面;
 * 其中img直接在该服务内存入static/img/文件夹
 * 模块关联实体: 无
 * 
 * 跳入模块URL: http://localhost:8241/insert?method=大模块&value=小模块
 * 模块自身URL: http://localhost:8441/InsertServlet
 * 模块跳出URL: 
 * (1)后台查询模块: http://localhost:8251/select?method=viewpager&value=value&pageNum=1 
 * (2)信息添加队列: http://localhost:8641/
 * 
 * 模块定义异常:
 * (1)无
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
public class BuoySysInsertServletApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoySysInsertServletApplication.class, args);
	}

}
