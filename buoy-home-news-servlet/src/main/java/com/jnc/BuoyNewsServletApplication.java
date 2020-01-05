package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 模块名称: 新闻服务
 * 功能说明: 判断是上一篇还是下一篇,发送点击焦点至新闻队列并携带信息跳回新闻视图
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)NewsHorizon
 * (4)NewsAbility
 * (5)NewsSocial
 * (6)NewsBusiness
 * (7)NewsScience
 * 
 * 
 * 跳入模块URL: http://localhost:8191/news?usersname=${usersname}&method=${method}&value=${value}&title=${title}
 * 模块自身URL: http://localhost:8391/NewsServlet?usersname=${usersname}&method=${method}&value=${value}&title=${title}&action=${action}
 * 模块跳出URL: 
 * (1)新闻队列: http://localhost:8591/
 * (2)左侧对应新闻条目: http://localhost:8191/news?usersname=${usersname}&method=${method}&value=${value}&title=${title}
 * 
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
