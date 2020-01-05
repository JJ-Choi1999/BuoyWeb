package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统查看视图
 * 模块功能: 获取关联实体,分页显示,每页15条;[每行显示字数待定]
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)NewsHorizon
 * (4)NewsAbility
 * (5)NewsSocial
 * (6)NewsBusiness
 * (7)NewsScience
 * (8)MsgHorizon
 * (9)MsgAbility
 * (10)MsgSocial
 * (11)MsgBusiness
 * (12)MsgScience
 * 
 * 跳入模块URL: http://localhost:8441/InsertServlet
 * 模块自身URL: http://localhost:8251/select?method=${method}&value=${value}&pageNum=1
 * 模块跳出URL: 
 * (1)编辑：http://localhost:8261/updata?method=${method}&value=${value}&title=${title}
 * (2)删除：http://localhost:8271/delete?method=${method}&value=${value}&title=${title}
 * 
 * 模块定义异常:
 * (1)字符字数越界
 * (2)页面访问越界
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoySelectApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(BuoySelectApplication.class, args);
	}

}
