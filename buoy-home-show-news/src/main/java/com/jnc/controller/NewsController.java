package com.jnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.FristViewPagerRepositoryQueryAnnotation;
import com.jnc.dao.NewsAbilityRepositoryQueryAnnotation;
import com.jnc.dao.NewsBusinessRepositoryQueryAnnotation;
import com.jnc.dao.NewsHorizonRepositoryQueryAnnotation;
import com.jnc.dao.NewsScienceRepositoryQueryAnnotation;
import com.jnc.dao.NewsSocialRepositoryQueryAnnotation;
import com.jnc.dao.ViewPagerRepositoryQueryAnnotation;
import com.jnc.pojo.FristViewPager;
import com.jnc.pojo.NewsAbility;
import com.jnc.pojo.NewsBusiness;
import com.jnc.pojo.NewsHorizon;
import com.jnc.pojo.NewsScience;
import com.jnc.pojo.NewsSocial;
import com.jnc.pojo.ViewPager;



/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class NewsController {

	
	@Autowired
	private FristViewPagerRepositoryQueryAnnotation fristViewPagerRepositoryQueryAnnotation;
	
	@Autowired
	private ViewPagerRepositoryQueryAnnotation viewPagerRepositoryQueryAnnotation;
	
	@Autowired
	private NewsHorizonRepositoryQueryAnnotation newsHorizonRepositoryQueryAnnotation;
	
	@Autowired
	private NewsAbilityRepositoryQueryAnnotation newsAbilityRepositoryQueryAnnotation;
	
	@Autowired
	private NewsSocialRepositoryQueryAnnotation newsSocialRepositoryQueryAnnotation;
	
	@Autowired
	private NewsBusinessRepositoryQueryAnnotation newsBusinessRepositoryQueryAnnotation;
	
	@Autowired
	private NewsScienceRepositoryQueryAnnotation newsScienceRepositoryQueryAnnotation;
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,String method,
			String value,String title,Model model) {
		
		//左侧标题
		model.addAttribute("FristViewPagerTitle", seekFristViewPager().getTitle());
		model.addAttribute("ViewPagerList", seekViewPager());
		model.addAttribute("NewsHorizonList", seekNewsHorizon());
		model.addAttribute("NewsAbilityList", seekNewsAbility());
		model.addAttribute("NewsSocialList", seekNewsSocial());
		model.addAttribute("NewsBusinessList", seekNewsBusiness());
		model.addAttribute("NewsScienceList", seekNewsScience());
		
		String tmp = mySwicthPojo(method,value,title);
		
		String []cut = tmp.split("_");
		model.addAttribute("key", method + "_" + value);
		model.addAttribute("method", method);
		model.addAttribute("value", value);
		model.addAttribute("title", cut[0]);
		model.addAttribute("context", cut[1]);
		
		/*
		String img = "https://www.layoutit.com/img/"+"sports-q-c-140-140-3.jpg";
		model.addAttribute("usersname", usersname);
		model.addAttribute("img", img);
		
		try {
			
			this.messageSender.sendMessage("news_focus"+","+usersname+","+"1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		
		return page;
	}
	
	private FristViewPager seekFristViewPager() {
		return this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
	}
	
	private List<ViewPager> seekViewPager() {
		return this.viewPagerRepositoryQueryAnnotation.queryByViewPagerUseSQL();
	}
	
	private List<NewsHorizon> seekNewsHorizon() {
		return this.newsHorizonRepositoryQueryAnnotation.queryByNewsHorizonUseSQL();
	}
	
	private List<NewsAbility> seekNewsAbility() {
		return this.newsAbilityRepositoryQueryAnnotation.queryByNewsAbilityUseSQL();
	}
	
	private List<NewsSocial> seekNewsSocial() {
		return this.newsSocialRepositoryQueryAnnotation.queryByNewsSocialUseSQL();
	}
	
	private List<NewsBusiness> seekNewsBusiness() {
		return this.newsBusinessRepositoryQueryAnnotation.queryByNewsBusinessUseSQL();
	}
	
	private List<NewsScience> seekNewsScience() {
		return this.newsScienceRepositoryQueryAnnotation.queryByNewsScienceUseSQL();
	}
	
	private String mySwicthPojo(String method,String value,String title) {
		
		String str = method + "_" + value;
		
		String tmp = null;
		
		switch(str) {
			
			case "viewpager_frist_viewpager":
				
				FristViewPager fristViewPager = 
					this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerTitleUseSQL(title);
				
				tmp = fristViewPager.getTitle() + "_" + fristViewPager.getContext(); 
				
			break;
			
			case "viewpager_edit":
				
				ViewPager viewPager = 
					this.viewPagerRepositoryQueryAnnotation.queryByViewPagerTitleUseSQL(title);
				
				tmp = viewPager.getTitle() + "_" + viewPager.getContext(); 
				
			break;
			
			
			case "news_horizon":
				
				NewsHorizon newsHorizon = 
					this.newsHorizonRepositoryQueryAnnotation.queryByHorizonTitleUseSQL(title);
				
				tmp = newsHorizon.getTitle() + "_" + newsHorizon.getContext(); 
				
			break;
	
			case "news_ability":
				
				NewsAbility newsAbility = 
					this.newsAbilityRepositoryQueryAnnotation.queryByAbilityTitleUseSQL(title);
				
				tmp = newsAbility.getTitle() + "_" + newsAbility.getContext(); 
				
			break;
			
			case "news_social":
				
				NewsSocial newsSocial = 
					this.newsSocialRepositoryQueryAnnotation.queryBySocialTitleUseSQL(title);
				
				tmp = newsSocial.getTitle() + "_" + newsSocial.getContext(); 
				
			break;
			
			case "news_business":

				NewsBusiness newsBusiness = 
					this.newsBusinessRepositoryQueryAnnotation.queryByBusinessTitleUseSQL(title);
				
				tmp = newsBusiness.getTitle() + "_" + newsBusiness.getContext(); 
					
				
			break;
			
			case "news_science":
				
				NewsScience newsScience = 
					this.newsScienceRepositoryQueryAnnotation.queryByScienceTitleUseSQL(title);
				
				tmp = newsScience.getTitle() + "_" + newsScience.getContext(); 

				
			break;
		
		}
		
		return tmp;
		
	}
}
