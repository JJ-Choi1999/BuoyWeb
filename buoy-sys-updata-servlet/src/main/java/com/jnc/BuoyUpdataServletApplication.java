package com.jnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 模块名称: 浮标后台管理系统更新服务
 * 模块功能: 获取关联信息并发送至队列同时若有图片则将图片存储至
 * 绝对路径D:/BuoyWeb/buoy-sys-insert-servlet/src/main/resources/static/img/下
 * 
 * 模块关联实体: 
 * (1)MultipartFile //图像存储类
 * 
 * 跳入模块URL: http://localhost:8261/updata?method=${method}&value=${value}&id=${id}
 * 模块自身URL: http://localhost:8461/UpdataServlet
 * 模块跳出URL: 
 * (1)正常情况下: http://localhost:8251/select?method=${method}&value=${value}&pageNum=1
 * (2)标题为空: http://localhost:8261/updata?method=${method}&value=${value}&id=${id}&exception=isTitleEmpty
 * (3)内容为空: http://localhost:8261/updata?method=${method}&value=${value}&id=${id}&exception=isContextEmpty
 * 
 * @author JNC
 *
 */
@SpringBootApplication
public class BuoyUpdataServletApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuoyUpdataServletApplication.class, args);
	}

}
