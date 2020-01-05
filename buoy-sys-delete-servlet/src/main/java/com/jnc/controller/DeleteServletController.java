package com.jnc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.BuoyMessageSender;

/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class DeleteServletController {
	
	//RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
	
	@RequestMapping("/DeleteServlet")
	public void myController(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String method = request.getParameter("method");
		String value = request.getParameter("value");
		String id = request.getParameter("id");
		
		System.out.println("method_value="+method+"_"+value);
		System.out.println("id="+id);
		
		
		try {
			this.messageSender.sendMessage(method+"_"+value+","+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8251/select?method="+method+"&value="+value+"&pageNum=1");
	}

}
