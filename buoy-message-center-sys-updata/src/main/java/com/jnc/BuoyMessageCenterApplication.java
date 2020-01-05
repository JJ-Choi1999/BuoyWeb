package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 浮标后台管理系统更新队列
 * 模块功能: 获取关联信息并存储至MSSQL
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
 * 跳入模块URL: http://localhost:8461/UpdataServlet
 * 模块自身URL: http://localhost:8661/
 * 模块跳出URL: 无
 * 
 * @author JNC
 *
 */
@SpringBootApplication
//@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyMessageCenterApplication {
	
	/**
	 * 更改Redis默认库,编写定时器储存
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyMessageCenterApplication.class, args);
	}

}
