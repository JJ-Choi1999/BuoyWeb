package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 模块名称: 未登陆新闻服务
 * 功能说明: 获取相关实体信息,并判断所需操作最后进行URL跳转
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)NewsHorizon
 * (4)NewsAbility
 * (5)NewsSocial
 * (6)NewsBusiness
 * (7)NewsScience
 * 
 * 跳入模块URL: http://localhost:8192/news?method=${method}&value=${value}&title=${title}
 * 模块自身URL: http://localhost:8392/NewsServlet?usersname=${usersname}&method=${method}&value=${value}&title=${title}&action=${action}
 * 模块跳出URL: http://localhost:8192/news?method=${method}&value=${value}&title=${title}
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
public class BuoyNewsServletApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyNewsServletApplication.class, args);
	}

}
