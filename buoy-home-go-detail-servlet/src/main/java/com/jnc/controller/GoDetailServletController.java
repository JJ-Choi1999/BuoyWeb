package com.jnc.controller;

import java.util.Date;

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
public class GoDetailServletController {
	
	// RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
	
	@RequestMapping("/GoDetailServler")
	public void myController(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String usersname = request.getParameter("usersname");
		
		String method = request.getParameter("method");
		
		String value = request.getParameter("value");
		
		String title = request.getParameter("title");
		
		String date = new Date().getTime()+"";
		
		String option = request.getParameter("option");
		
		
		try {
			
			this.messageSender.sendMessage("go_detail" + "," + usersname + "," + method
					+ "," + value + "," + title + "," + date + "," + option);

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("http://localhost:8172/detail?usersname="+ usersname + "&method=" + method + "&value=" + value);
		
	}
	
	
	
}
