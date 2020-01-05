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
public class InsertServletController {
	
	//RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
	
	@RequestMapping("/InsertServlet")
	public void myController(MultipartFile img,HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String method = request.getParameter("method");
		
		String value = request.getParameter("value");
		
		String title = request.getParameter("title");
		
		String context = request.getParameter("context");
		
		if(isTitleEmpty(title)&&isContextEmpty(context)) {
			
			if(img.isEmpty()==false) {
				//文件的保存new File("绝对路径指向该文件resources/static/img/")
				img.transferTo(new File("D:/BuoyWeb/buoy-sys-insert-servlet/src/main/resources/static/img/"+img.getOriginalFilename()));
			}
			
			try {
				this.messageSender.sendMessage(mySwitchMethod(method)+"_"+mySwitchValue(value)+","+title+","+context+","+img.getOriginalFilename()+","+new Date().getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("http://localhost:8251/select?method="+
					mySwitchMethod(method)+"&value="+mySwitchValue(value)+"&pageNum=1");
			
		}else if(isTitleEmpty(title)==false) {
			
			response.sendRedirect("http://localhost:8241/insert?method="+mySwitchMethod(method)
				+"&value="+mySwitchValue(value)+"&exception=isTitleEmpty");
			
		}else if(isContextEmpty(context)==false) {
			
			response.sendRedirect("http://localhost:8241/insert?method="+mySwitchMethod(method)
				+"&value="+mySwitchValue(value)+"&exception=isContextEmpty");
		
			
		}
	}
	
	/**
	 * method字符选择器
	 * @param method 字符
	 * @return
	 */
	private String mySwitchMethod(String method) {
		
		String str=null;
		
		switch(method) {
			
			case "轮播图":
				
				str="viewpager";
				
				break;
			case "新闻":
				
				str="news";
				
				break;
			case "信息":
	
				str="msg";
	
				break;
	
		}
		
		return str;
	}
	
	/**
	 * value字符选择器
	 * @param value 字符
	 * @return
	 */
	private String mySwitchValue(String value) {
		
		String str=null;
		
		switch(value) {
			
			case "编辑首张":
				str="frist_viewpager";
			break;
			
			case "编辑":
				str="edit";
			break;
				
			case "视野港":
				str="horizon";
			break;
	
			case "能力港":
				str="ability";
			break;
			
			case "人文社科港":
				str="social";
			break;
			
			case "商业港":
				str="business";
			break;
			
			case "科学港":
				str="science";
			break;
			
		}
		
		return str;
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
