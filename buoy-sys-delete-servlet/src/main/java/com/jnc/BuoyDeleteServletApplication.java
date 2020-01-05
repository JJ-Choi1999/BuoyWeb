package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统删除服务
 * 模块功能: 获取关联信息,发送至信息队列,完成后返回查询视图
 * 模块关联实体: 
 * (1)无
 * 
 * 跳入模块URL: http://localhost:8271/delete?method=${method}&value=${value}&title=${title}
 * 模块自身URL: http://localhost:8471/DeleteServlet?method=${method}&value=${value}&title=${title} 
 * 模块跳出URL: http://localhost:8671/
 * 
 * 模块定义异常:
 * (1)无
 * 
 * 
 * 
 * @author 590
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyDeleteServletApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyDeleteServletApplication.class, args);
	}

}
