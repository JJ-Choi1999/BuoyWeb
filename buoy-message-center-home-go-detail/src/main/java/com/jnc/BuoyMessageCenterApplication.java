package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆启航详情队列
 * 模块功能: 获取消息队列信息,添加到相应数据表
 * 模块关联实体: 
 * (1)BuoyHorizon
 * (2)BuoyAbility
 * (3)BuoySocial
 * (4)BuoyBusiness
 * (5)BuoyScience
 * 
 * 跳入模块URL: http://localhost:8371/GoDetailServler?usersname=${usersname}&method=${method}&value=${value}&title=${title}&option=${option}
 * 模块自身URL: http://localhost:8571/
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
