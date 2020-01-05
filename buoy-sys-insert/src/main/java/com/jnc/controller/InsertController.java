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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
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
public class InsertController {
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,
			String method,String value,String exception,Model model) {
		
		model.addAttribute("exception", exception);
		
		switch(value){
			
			case "frist_viewpager":
				model.addAttribute("value", "编辑首张");
				System.out.println("value="+value);
			break;
			
			case "edit":
				model.addAttribute("value", "编辑");
				System.out.println("value="+value);
			break;
			
			case "horizon":
				model.addAttribute("value", "视野港");
				System.out.println("value="+value);
			break;
	
			case "ability":
				model.addAttribute("value", "能力港");
				System.out.println("value="+value);
			break;
			
			case "social":
				model.addAttribute("value", "人文社科港");
				System.out.println("value="+value);
			break;
			
			case "business":
				model.addAttribute("value", "商业港");
				System.out.println("value="+value);
			break;
			
			case "science":
				model.addAttribute("value", "科学港");
				System.out.println("value="+value);
			break;
			
		}
		
		
		switch(method) {
			case "viewpager":
				model.addAttribute("method", "轮播图");
				System.out.println("method="+method);

				break;
			
			case "news":
				model.addAttribute("method", "新闻");
				System.out.println("method="+method);
				
				break;
				
			case "msg":
				model.addAttribute("method", "信息");
				System.out.println("method="+method);

				break;
		}
		
		
		return page;
	}

}
