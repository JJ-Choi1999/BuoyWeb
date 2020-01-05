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

import com.jnc.dao.*;
import com.jnc.pojo.*;




/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class GoDetailController {
	
	//FristViewPager的JPA增删查改模型
	@Autowired
	private FristViewPagerRepositoryQueryAnnotation fristViewPagerRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@Autowired
	private MsgHorizonRepositoryQueryAnnotation msgHorizonRepositoryQueryAnnotation;
	
	@Autowired
	private MsgAbilityRepositoryQueryAnnotation msgAbilityRepositoryQueryAnnotation;
	
	@Autowired
	private MsgSocialRepositoryQueryAnnotation msgSocialRepositoryQueryAnnotation;
	
	@Autowired
	private MsgBusinessRepositoryQueryAnnotation msgBusinessRepositoryQueryAnnotation;
	
	@Autowired
	private MsgScienceRepositoryQueryAnnotation msgScienceRepositoryQueryAnnotation;
	
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,
			String usersname,String method,String value,Model model) {
		
		model.addAttribute("usersname", usersname);
		
//--------------------------------------------------------------------------------------------------------------------//		
		
		FristViewPager fristViewPager = 
			this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
		
		model.addAttribute("fristViewPagerTitle", fristViewPager.getTitle());
		
//-----------------------------------------------------------------------------------------------//		
		
		List<Users> list=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		String img = "http://localhost:8401/img/" + list.get(0).getImg(); 
				
		model.addAttribute("nickname", list.get(0).getNickname());
		
		model.addAttribute("img", img);
		
//-----------------------------------------------------------------------------------------------//		
		
		model.addAttribute("method", method);
		
		model.addAttribute("value", value);
		
		String key = method + "_" + value;
		
		switch(key) {
			
			case "msg_horizon":
				
				model.addAttribute("key", "视野港");
				MsgHorizon msgHorizon = this.msgHorizonRepositoryQueryAnnotation.queryRandHorizon();
				model.addAttribute("title", msgHorizon.getTitle());
				model.addAttribute("context", msgHorizon.getContext());
				
			break;
	
			case "msg_ability":
				
				model.addAttribute("key", "能力港");
				MsgAbility msgAbility = this.msgAbilityRepositoryQueryAnnotation.queryRandAbility();
				model.addAttribute("title", msgAbility.getTitle());
				model.addAttribute("context", msgAbility.getContext());
				
			break;
			
			case "msg_social":
				
				model.addAttribute("key", "社交港");
				MsgSocial msgSocial = this.msgSocialRepositoryQueryAnnotation.queryRandSocial();
				model.addAttribute("title", msgSocial.getTitle());
				model.addAttribute("context", msgSocial.getContext());
				
			break;
			
			case "msg_business":
				
				model.addAttribute("key", "商业港");
				MsgBusiness msgBusiness = this.msgBusinessRepositoryQueryAnnotation.queryRandBusiness();
				model.addAttribute("title", msgBusiness.getTitle());
				model.addAttribute("context", msgBusiness.getContext());
				
			break;
			
			case "msg_science":
				
				model.addAttribute("key", "科学港");
				MsgScience msgScience = this.msgScienceRepositoryQueryAnnotation.queryRandScience();
				model.addAttribute("title", msgScience.getTitle());
				model.addAttribute("context", msgScience.getContext());
				
			break;
			
		}
		
		
		return page;
	}
	
	
	
}
