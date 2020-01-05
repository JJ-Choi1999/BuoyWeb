package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 已登陆启航详情服务
 * 功能说明: 获取相应信息并发送至已登陆启航详情队列
 * 模块关联实体: 
 * (1)无
 * 
 * 
 * 跳入模块URL: http://localhost:8171/detail?usersname=${usersname}&method=${method}&value=${value}
 * 模块自身URL: http://localhost:8371/GoDetailServler?usersname=${usersname}&method=${method}&value=${value}&title=${title}&option=${option}
 * 模块跳出URL: http://localhost:8571/
 * 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyGoDetailServletApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyGoDetailServletApplication.class, args);
	}

}
