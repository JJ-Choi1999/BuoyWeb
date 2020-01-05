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

import com.jnc.dao.*;
import com.jnc.pojo.*;

/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class UndataController {
	
	@Autowired
	private FristViewPagerRepositoryCrudRepository fristViewPagerRepositoryCrudRepository;
	
	@Autowired
	private ViewPagerRepositoryCrudRepository viewPagerRepositoryCrudRepository;
	
	@Autowired
	private NewsHorizonRepositoryCrudRepository newsHorizonRepositoryCrudRepository;
	
	@Autowired
	private NewsAbilityRepositoryCrudRepository newsAbilityRepositoryCrudRepository;
	
	@Autowired
	private NewsSocialRepositoryCrudRepository newsSocialRepositoryCrudRepository;
	
	@Autowired
	private NewsBusinessRepositoryCrudRepository newsBusinessRepositoryCrudRepository;
	
	@Autowired
	private NewsScienceRepositoryCrudRepository newsScienceRepositoryCrudRepository;
	
	@Autowired
	private MsgHorizonRepositoryCrudRepository msgHorizonRepositoryCrudRepository;
	
	@Autowired
	private MsgAbilityRepositoryCrudRepository msgAbilityRepositoryCrudRepository;
	
	@Autowired
	private MsgSocialRepositoryCrudRepository msgSocialRepositoryCrudRepository;
	
	@Autowired
	private MsgBusinessRepositoryCrudRepository msgBusinessRepositoryCrudRepository;
	
	@Autowired
	private MsgScienceRepositoryCrudRepository msgScienceRepositoryCrudRepository;
				
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,String method,
			String value,String id,String exception,Model model) {
		
		model.addAttribute("exception", exception);
		
		Integer intId = Integer.valueOf(id);
		
		String key=method+"_"+value;
		
		model.addAttribute("key", mySwitch(key)); //更新凭据
		
		model.addAttribute("id", id); //更新凭据
		model.addAttribute("method", method); //更新凭据
		model.addAttribute("value", value); //更新凭据
		
		switch(key) {
		
			case "viewpager_frist_viewpager":
				
				FristViewPager fristViewPager = this.fristViewPagerRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", fristViewPager.getTitle());
				model.addAttribute("context", fristViewPager.getContext());
				//model.addAttribute("img", fristViewPager.getImg());
				
			break;
			
			case "viewpager_edit":
				
				ViewPager viewPager = this.viewPagerRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", viewPager.getTitle());
				model.addAttribute("context", viewPager.getContext());
				//model.addAttribute("img", viewPager.getImg());
				
			break;
			
			
			case "news_horizon":
				
				NewsHorizon newsHorizon = this.newsHorizonRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", newsHorizon.getTitle());
				model.addAttribute("context", newsHorizon.getContext());
				//model.addAttribute("img", newsHorizon.getImg());
				
			break;
	
			case "news_ability":
				
				NewsAbility newsAbility = this.newsAbilityRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", newsAbility.getTitle());
				model.addAttribute("context", newsAbility.getContext());
				//model.addAttribute("img", newsAbility.getImg());
				
			break;
			
			case "news_social":
				
				NewsSocial newsSocial = this.newsSocialRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", newsSocial.getTitle());
				model.addAttribute("context", newsSocial.getContext());
				//model.addAttribute("img", newsSocial.getImg());
				
			break;
			
			case "news_business":
				
				NewsBusiness newsBusiness = this.newsBusinessRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", newsBusiness.getTitle());
				model.addAttribute("context", newsBusiness.getContext());
				//model.addAttribute("img", newsBusiness.getImg());
				
			break;
			
			case "news_science":
				
				NewsScience newsScience = this.newsScienceRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", newsScience.getTitle());
				model.addAttribute("context", newsScience.getContext());
				//model.addAttribute("img", newsScience.getImg());
				
			break;
			
			
			case "msg_horizon":
				
				MsgHorizon msgHorizon = this.msgHorizonRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", msgHorizon.getTitle());
				model.addAttribute("context", msgHorizon.getContext());
				//model.addAttribute("img", msgHorizon.getImg());
				
			break;
	
			case "msg_ability":
				
				MsgAbility msgAbility = this.msgAbilityRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", msgAbility.getTitle());
				model.addAttribute("context", msgAbility.getContext());
				//model.addAttribute("img", msgAbility.getImg());
				
			break;
			
			case "msg_social":
				
				MsgSocial msgSocial = this.msgSocialRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", msgSocial.getTitle());
				model.addAttribute("context", msgSocial.getContext());
				//model.addAttribute("img", msgSocial.getImg());
				
			break;
			
			case "msg_business":
				
				MsgBusiness msgBusiness = this.msgBusinessRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", msgBusiness.getTitle());
				model.addAttribute("context", msgBusiness.getContext());
				//model.addAttribute("img", msgBusiness.getImg());
				
			break;
			
			case "msg_science":
				
				MsgScience msgScience = this.msgScienceRepositoryCrudRepository.findOne(intId);
				
				model.addAttribute("title", msgScience.getTitle());
				model.addAttribute("context", msgScience.getContext());
				//model.addAttribute("img", msgScience.getImg());
				
			break;
		}
		
		return page;
	}
	
	private String mySwitch(String key) {
		
		String str = null;
		
		switch(key) {
		
			case "viewpager_frist_viewpager":

				str = "首张轮播图";
				
			break;
			
			case "viewpager_edit":
				
				str = "轮播图";
				
			break;
			
			
			case "news_horizon":

				str = "视野港新闻";
				
			break;
	
			case "news_ability":
				
				str = "能力港新闻";
				
			break;
			
			case "news_social":

				str = "社科人文港新闻";
				
			break;
			
			case "news_business":
				
				str = "商业港新闻";
				
			break;
			
			case "news_science":
				
				str = "科学港新闻";
				
			break;
			
			
			case "msg_horizon":
				
				str = "视野港信息";
				
			break;
	
			case "msg_ability":
				
				str = "能力港信息";
				
			break;
			
			case "msg_social":

				str = "社科人文港信息";
				
			break;
			
			case "msg_business":
				
				str = "商业港信息";
				
			break;
			
			case "msg_science":
				
				str = "科学港信息";
				
			break;
		}
		
		return str;
	}
	

}
