package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 已登陆首页视图
 * 功能说明: 显示相关联模块链接并显示轮播图及用户头像及昵称
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * (3)Users
 * 
 * 
 * 跳入模块URL: http://localhost:8000/Regulator
 * 模块自身URL: http://localhost:8131/index?usersname=${usersname}
 * 模块跳出URL: 
 * (1)菜单: http://localhost:8131/index?usersname=${usersname}
 * (2)我的设置: http://localhost:8201/set?usersname=${usersname}
 * (3)启航: http://localhost:8141/go?usersname=${usersname}
 * (4)浮标: http://localhost:8161/buoy?usersname=${usersname}
 * (5)新闻: http://localhost:8191/news?usersname=${usersname}&method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (6)关于我们: http://localhost:8221/about?usersname=${usersname}
 * (7)首张轮播图: http://localhost:8191/news?usersname=${usersname}&method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (8)轮播图: http://localhost:8191/news?usersname=${usersname}&method=viewpager&value=edit&title=${v.title}
 * 
 * 
 * 
 * @author JNC
 *
 */
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyIndexApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyIndexApplication.class, args);
	}

}
