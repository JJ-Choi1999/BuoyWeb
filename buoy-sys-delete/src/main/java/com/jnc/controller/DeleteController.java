package com.jnc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class DeleteController {
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,String method,
			String value,String title,String id,Model model) {
		
		model.addAttribute("title", title);
		model.addAttribute("id", id);
		//System.out.println("title="+title);
		
		String str=method+"_"+value;
		
		/**
		 * 自定义选择器
		 */
		switch(str) {
		
			case "viewpager_frist_viewpager":
				
				model.addAttribute("key", "首张轮播图"); 
				model.addAttribute("method", "viewpager"); 
				model.addAttribute("value", "frist_viewpager"); 
				
				break;
			
			case "viewpager_edit":
				
				model.addAttribute("key", "轮播图编辑"); 
				model.addAttribute("method", "viewpager"); 
				model.addAttribute("value", "edit"); 
				
				break;
			
			
			case "news_horizon":
				
				model.addAttribute("key", "视野港新闻"); 
				model.addAttribute("method", "news"); 
				model.addAttribute("value", "horizon"); 
				
				break;
			
			case "news_ability":
				
				model.addAttribute("key", "能力港新闻"); 
				model.addAttribute("method", "news"); 
				model.addAttribute("value", "ability"); 
				
				break;
				
			case "news_social":
				
				model.addAttribute("key", "人文社科港新闻"); 
				model.addAttribute("method", "news"); 
				model.addAttribute("value", "social"); 
				
				break;
				
			case "news_business":
				
				model.addAttribute("key", "商业港新闻"); 
				model.addAttribute("method", "news"); 
				model.addAttribute("value", "business"); 
				
				break;
				
			case "news_science":
				
				model.addAttribute("key", "科学港新闻"); 
				model.addAttribute("method", "news"); 
				model.addAttribute("value", "science"); 
				
				break;
					
				
			case "msg_horizon":
				
				model.addAttribute("key", "视野港信息"); 
				model.addAttribute("method", "msg"); 
				model.addAttribute("value", "horizon"); 
				
				break;
			
			case "msg_ability":
				
				model.addAttribute("key", "能力港信息"); 
				model.addAttribute("method", "msg"); 
				model.addAttribute("value", "ability"); 
				
				break;
				
			case "msg_social":
				
				model.addAttribute("key", "人文社科港信息"); 
				model.addAttribute("method", "msg"); 
				model.addAttribute("value", "social"); 
				
				break;
				
			case "msg_business":
				
				model.addAttribute("key", "商业港信息"); 
				model.addAttribute("method", "msg"); 
				model.addAttribute("value", "business"); 
				
				break;
				
			case "msg_science":
				
				model.addAttribute("key", "科学港信息"); 
				model.addAttribute("method", "msg"); 
				model.addAttribute("value", "science"); 
				
				break;
				
		}		
		return page;
	}

}
