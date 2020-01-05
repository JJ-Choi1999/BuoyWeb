package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 登陆视图
 * 功能说明: 输入用户名和密码,携带相应信息进入登陆服务
 * 模块关联实体: 
 * (1)无
 * 
 * 跳入模块URL: http://localhost:8121/index
 * 模块自身URL: http://localhost:8111/login
 * 模块跳出URL: http://localhost:8311/LoginServer
 * 
 * 异常:
 * (1)用户名或密码不一致: http://localhost:8111/login?exception=usersIoException
 * (2)用户名不存在: http://localhost:8111/login?exception=usersEmtryException
 * 
 * 
 * 
 * @author JNC
 *
 */

@SpringBootApplication
@ServletComponentScan	//添加 servlet组件扫描注解（作用：实例化此类为servlet类）
public class BuoyLoginApplication {
	/**
	 * RabbitMQ必需同时具有交换器,进入队列和错误队列 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BuoyLoginApplication.class, args);
	}

}
