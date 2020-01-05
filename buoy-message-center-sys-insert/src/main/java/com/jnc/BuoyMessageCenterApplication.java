package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统添加消息队列
 * 模块功能: 获取消息队列信息,添加到相应数据表
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
 * 模块自身URL: http://localhost:8641/
 * 模块跳出URL: 无
 * 
 * 模块定义异常:
 * (1)无
 *
 * @author JNC
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyMessageCenterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyMessageCenterApplication.class, args);
	}

}
