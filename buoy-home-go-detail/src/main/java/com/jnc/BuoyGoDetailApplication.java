package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆启航详情视图
 * 功能说明: 获取相应信息并显示
 * 模块关联实体: 
 * (1)MsgHorizon
 * (2)MsgAbility
 * (3)MsgSocial
 * (4)MsgBusiness
 * (5)MsgScience
 * (6)Users
 * (7)FristViewPager
 * 
 * 
 * 跳入模块URL: http://localhost:8141/go?usersname=${usersname}
 * 模块自身URL: http://localhost:8172/detail?usersname=${usersname}&method=${method}&value=${value}
 * 模块跳出URL: 
 * (1)浮标详情服务: http://localhost:8371/GoDetailServler?usersname=${usersname}&method=${method}&value=${value}&title=${title}&option=${option}
 * (2)菜单: http://localhost:8131/index?usersname=${usersname}
 * (3)我的设置: http://localhost:8201/set?usersname=${usersname}
 * (4)启航: http://localhost:8141/go?usersname=${usersname}
 * (5)浮标: http://localhost:8161/buoy?usersname=${usersname}
 * (6)新闻: http://localhost:8191/news?usersname=${usersname}&method=viewpager&value=frist_viewpager&title=${fristViewPagerTitle}
 * (7)关于我们: http://localhost:8221/about?usersname=${usersname}
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyGoDetailApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyGoDetailApplication.class, args);
	}

}
