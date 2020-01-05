package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统添加视图
 * 模块功能: 显示浮标后台管理系统添加视图,点击添加按钮链接到浮标后台管理系统添加服务器
 * 模块关联实体: 无
 * 
 * 跳入模块URL: http://localhost:8431/LoginServler
 * 模块自身URL: http://localhost:8241/insert?method=大模块&value=小模块
 * 模块跳出URL: http://localhost:8441/InsertServlet
 * 
 * 模块定义异常:
 * (1)标题为空
 * (2)内容为空
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoySysInsertApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoySysInsertApplication.class, args);
	}

}
