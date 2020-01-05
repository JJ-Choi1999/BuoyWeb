package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * 模块名称: 未登陆关于我们视图
 * 功能说明: 显示相关信息
 * 模块关联实体: 
 * (1)FristViewPager
 * 
 * 跳入模块URL: http://localhost:8121/index
 * 模块自身URL: http://localhost:8222/about
 * 模块跳出URL: 
 * (1)菜单: http://localhost:8121/index
 * (2)登陆: http://localhost:8111/login
 * (3)注册: http://localhost:8100/register
 * (4)新闻: http://localhost:8192/news?method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (5)关于我们: http://localhost:8222/about
 * 
 * 
 * 
 * 
 * @author JNC
 *
 */
//图片不能动态指定
@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyAboutApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyAboutApplication.class, args);
	}

}
