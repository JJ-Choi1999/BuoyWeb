package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 未登陆首页视图
 * 功能说明: 显示相关联模块链接并显示轮播图
 * 模块关联实体: 
 * (1)FristViewPager
 * (2)ViewPager
 * 
 * 跳入模块URL: http://localhost:8000/Regulator
 * 模块自身URL: http://localhost:8121/index
 * 模块跳出URL: 
 * (1)菜单: http://localhost:8121/index
 * (2)登陆: http://localhost:8111/login
 * (3)注册: http://localhost:8100/register
 * (4)新闻: http://localhost:8192/news?method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (5)关于我们: http://localhost:8222/about
 * (6)首张轮播图: http://localhost:8192/news?method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (7)轮播图: http://localhost:8192/news?method=viewpager&value=edit&title=${title}
 * (8)启航: http://localhost:8111/login
 * (9)浮标: http://localhost:8111/login
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
