package com.jnc.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jnc.BuoyMessageSender;


/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class UpdataServletController {
	
	//RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
	
	@RequestMapping("/UpdataServlet")
	public void myController(MultipartFile img,HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String method = request.getParameter("method");
		String value = request.getParameter("value");
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		
		if(isTitleEmpty(title)&&isContextEmpty(context)) {
			
			if(img.isEmpty()==false) {
				//文件的保存new File("绝对路径指向该文件resources/static/img/")
				//[待优化]:以URL代替路径名--》建立信道
				img.transferTo(new File("D:/BuoyWeb/buoy-sys-insert-servlet/src/main/resources/static/img/"+img.getOriginalFilename()));
				
				try {
					this.messageSender.sendMessage(method+"_"+value+","+id+","+title+","+context+","+img.getOriginalFilename()+","+new Date().getTime());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(img.isEmpty()) {
				try {
					this.messageSender.sendMessage(method+"_"+value+","+id+","+title+","+context+","+"Empty"+","+new Date().getTime());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			response.sendRedirect("http://localhost:8251/select?method="+method+
					"&value="+value+"&pageNum=1");
			
			
		}else if(isTitleEmpty(title)==false) {
			
			response.sendRedirect("http://localhost:8261/updata?method="+method+
					"&value="+value+"&id="+id+"&exception=isTitleEmpty");
			
		}else if(isContextEmpty(context)==false) {
			
			response.sendRedirect("http://localhost:8261/updata?method="+method+
					"&value="+value+"&id="+id+"&exception=isContextEmpty");
		
			
		}
		
		
	}
	
	/**
	 * 判断题目是否为空
	 * @param title 题目
	 * @return 为空返回false,不为空返回true
	 */
	private Boolean isTitleEmpty(String title) {
		
		if(title.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 判断内容是否为空
	 * @param context 内容
	 * @return 为空返回false,不为空返回true
	 */
	private Boolean isContextEmpty(String context) {
		
		if(context.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
}
