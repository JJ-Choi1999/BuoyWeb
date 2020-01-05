package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统更新视图
 * 模块功能: 获取关联实体并显示
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
 * 跳入模块URL: http://localhost:8251/select?method=${method}&value=${value}&pageNum=1
 * 模块自身URL: http://localhost:8261/updata?method=${method}&value=${value}&id=${id}
 * 模块跳出URL: http://localhost:8461/UpdataServlet
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyUpdataApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyUpdataApplication.class, args);
	}

}
