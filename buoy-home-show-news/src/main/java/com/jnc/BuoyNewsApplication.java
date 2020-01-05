package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 模块名称: 未登陆新闻视图
 * 功能说明: 显示相关实体信息
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)NewsHorizon
 * (4)NewsAbility
 * (5)NewsSocial
 * (6)NewsBusiness
 * (7)NewsScience
 * 
 * 跳入模块URL: http://localhost:8121/index
 * 模块自身URL: http://localhost:8192/news?method=${method}&value=${value}&title=${title}
 * 模块跳出URL: 
 * (1)上一篇、下一篇: http://localhost:8392/NewsServlet?usersname=${usersname}&method=${method}&value=${value}&title=${title}&action=${action}
 * (2)相应新闻选项条目: http://localhost:8192/news?method=${method}&value=${value}&title=${title}
 * (3)菜单: http://localhost:8121/index
 * (4)登陆: http://localhost:8111/login
 * (5)注册: http://localhost:8100/register
 * (6)新闻: http://localhost:8192/news?method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (7)关于我们: http://localhost:8222/about
 * 
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
public class BuoyNewsApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyNewsApplication.class, args);
	}

}
