package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 模块名称: 新闻视图
 * 功能说明: 显示相关信息并显示
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)NewsHorizon
 * (4)NewsAbility
 * (5)NewsSocial
 * (6)NewsBusiness
 * (7)NewsScience
 * (8)Users
 * 
 * 
 * 跳入模块URL: http://localhost:8131/index?usersname=${usersname}
 * 模块自身URL: http://localhost:8191/news?usersname=${usersname}&method=${method}&value=${value}&title=${title}
 * 模块跳出URL: 
 * (1)上一篇、下一篇: http://localhost:8391/NewsServlet?usersname=${usersname}&method=${method}&value=${value}&title=${title}&action=${action}
 * (2)左侧对应新闻条目: http://localhost:8191/news?usersname=${usersname}&method=${method}&value=${value}&title=${title}
 * (3)菜单: http://localhost:8131/index?usersname=${usersname}
 * (4)我的设置: http://localhost:8201/set?usersname=${usersname}
 * (5)启航: http://localhost:8141/go?usersname=${usersname}
 * (6)浮标: http://localhost:8161/buoy?usersname=${usersname}
 * (7)新闻: http://localhost:8191/news?usersname=${usersname}&method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (8)关于我们: http://localhost:8221/about?usersname=${usersname}
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
public class BuoyNewsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyNewsApplication.class, args);
	}

}
