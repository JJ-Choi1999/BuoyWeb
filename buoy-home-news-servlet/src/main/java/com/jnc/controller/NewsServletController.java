package com.jnc.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.NewsAbilityRepositoryQueryAnnotation;
import com.jnc.dao.NewsBusinessRepositoryQueryAnnotation;
import com.jnc.dao.NewsHorizonRepositoryQueryAnnotation;
import com.jnc.dao.NewsScienceRepositoryQueryAnnotation;
import com.jnc.dao.NewsSocialRepositoryQueryAnnotation;
import com.jnc.dao.ViewPagerRepositoryQueryAnnotation;
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
public class NewsServletController {

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
	
	@RequestMapping("/NewsServlet")
	public void myController(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String usersname = request.getParameter("usersname");
		String method = request.getParameter("method");
		String value = request.getParameter("value");
		String title = request.getParameter("title");
		String action = request.getParameter("action");
		
		
		switch(action) {
			
			case "up":
				
				String upStr = up(method,value,title);
				
				//String urlStr =URLEncoder.encode("网络时空" ,"UTF-8");
				
				
				response.sendRedirect("http://localhost:8191/news?usersname="+ usersname + "&method=" + method +
						"&value=" + value + "&title=" + URLEncoder.encode(upStr ,"UTF-8"));
				
			break;
			
			case "down":
				
				String downStr = down(method,value,title);
				
				response.sendRedirect("http://localhost:8191/news?usersname="+ usersname + "&method=" + method + 
						"&value=" + value + "&title=" + URLEncoder.encode(downStr ,"UTF-8"));
				
			break;
			
		}
		
	}
	
	
	/**
	 * 上一页
	 * @param method
	 * @param value
	 * @param title
	 * @return
	 */
	private String up(String method,String value,String title) {
		
		String key = method + "_" + value;
		
		String tmp = null;
		
		switch(key) {
		
			case "viewpager_edit":
				
				List<ViewPager> viewpagerList = 
					this.viewPagerRepositoryQueryAnnotation.queryByViewPagerUseSQL();
				
				for(int i=0;i<viewpagerList.size();i++) {
					
					if(title.equals(viewpagerList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = viewpagerList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = viewpagerList.get(viewpagerList.size()-1).getTitle();
						}
					}
					
				}
				
			break;
			
			
			case "news_horizon":
				
				List<NewsHorizon> horizonList = 
					this.newsHorizonRepositoryQueryAnnotation.queryByNewsHorizonUseSQL();
			
				for(int i=0;i<horizonList.size();i++) {
					
					if(title.equals(horizonList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = horizonList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = horizonList.get(horizonList.size()-1).getTitle();
						}
					}
					
				}
					
				
			break;
	
			case "news_ability":

				List<NewsAbility> abilityList = 
					this.newsAbilityRepositoryQueryAnnotation.queryByNewsAbilityUseSQL();
			
				for(int i=0;i<abilityList.size();i++) {
					
					if(title.equals(abilityList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = abilityList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = abilityList.get(abilityList.size()-1).getTitle();
						}
					}
					
				}
				
				
			break;
			
			case "news_social":
				
				List<NewsSocial> socialList = 
					this.newsSocialRepositoryQueryAnnotation.queryByNewsSocialUseSQL();
			
				for(int i=0;i<socialList.size();i++) {
					
					if(title.equals(socialList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = socialList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = socialList.get(socialList.size()-1).getTitle();
						}
					}
					
				}
				
			break;
			
			case "news_business":
	

				List<NewsBusiness> businessList = 
					this.newsBusinessRepositoryQueryAnnotation.queryByNewsBusinessUseSQL();
			
				for(int i=0;i<businessList.size();i++) {
					
					if(title.equals(businessList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = businessList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = businessList.get(businessList.size()-1).getTitle();
						}
					}
					
				}
				
				
				
				
			break;
			
			case "news_science":
				
				List<NewsScience> scienceList = 
					this.newsScienceRepositoryQueryAnnotation.queryByNewsScienceUseSQL();
			
				for(int i=0;i<scienceList.size();i++) {
					
					if(title.equals(scienceList.get(i).getTitle())) { //找到自己所在的位置
						if(i != 0) { //不是首位
							tmp = scienceList.get(i-1).getTitle();
						}else { //首位回溯末位
							tmp = scienceList.get(scienceList.size()-1).getTitle();
						}
					}
					
				}
				
				
			break;
		}
		
		return tmp;
		
	}
	
	/**
	 * 下一页
	 * @param method
	 * @param value
	 * @param title
	 * @return
	 */
	private String down(String method,String value,String title) {
		
		String key = method + "_" + value;
		
		String tmp = null;
		
		switch(key) {
		
			case "viewpager_edit":
				
				List<ViewPager> viewpagerList = 
					this.viewPagerRepositoryQueryAnnotation.queryByViewPagerUseSQL();
				
				for(int i=0;i<viewpagerList.size();i++) {
					
					if(title.equals(viewpagerList.get(i).getTitle())) { //找到自己所在的位置
						if(i != viewpagerList.size()-1) { //不是末位
							tmp = viewpagerList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = viewpagerList.get(0).getTitle();
						}
					}
					
				}
				
			break;
			
			
			case "news_horizon":
				
				List<NewsHorizon> newsHorizonList = 
					this.newsHorizonRepositoryQueryAnnotation.queryByNewsHorizonUseSQL();
				
				for(int i=0;i<newsHorizonList.size();i++) {
					
					if(title.equals(newsHorizonList.get(i).getTitle())) { //找到自己所在的位置
						if(i != newsHorizonList.size()-1) { //不是末位
							tmp = newsHorizonList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = newsHorizonList.get(0).getTitle();
						}
					}
					
				}
				
				
				
			break;
	
			case "news_ability":
				
				List<NewsAbility> newsAbilityList = 
					this.newsAbilityRepositoryQueryAnnotation.queryByNewsAbilityUseSQL();
				
				for(int i=0;i<newsAbilityList.size();i++) {
					
					if(title.equals(newsAbilityList.get(i).getTitle())) { //找到自己所在的位置
						if(i != newsAbilityList.size()-1) { //不是末位
							tmp = newsAbilityList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = newsAbilityList.get(0).getTitle();
						}
					}
					
				}
				
				
			break;
			
			case "news_social":
				
				List<NewsSocial> newsSocialList = 
					this.newsSocialRepositoryQueryAnnotation.queryByNewsSocialUseSQL();
				
				for(int i=0;i<newsSocialList.size();i++) {
					
					if(title.equals(newsSocialList.get(i).getTitle())) { //找到自己所在的位置
						if(i != newsSocialList.size()-1) { //不是末位
							tmp = newsSocialList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = newsSocialList.get(0).getTitle();
						}
					}
					
				}
				
				
				
			break;
			
			case "news_business":
	
				List<NewsBusiness> newsBusinessList = 
					this.newsBusinessRepositoryQueryAnnotation.queryByNewsBusinessUseSQL();
				
				for(int i=0;i<newsBusinessList.size();i++) {
					
					if(title.equals(newsBusinessList.get(i).getTitle())) { //找到自己所在的位置
						if(i != newsBusinessList.size()-1) { //不是末位
							tmp = newsBusinessList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = newsBusinessList.get(0).getTitle();
						}
					}
					
				}
				
				
			break;
			
			case "news_science":
				
				List<NewsScience> newsScienceList = 
					this.newsScienceRepositoryQueryAnnotation.queryByNewsScienceUseSQL();
				
				for(int i=0;i<newsScienceList.size();i++) {
					
					if(title.equals(newsScienceList.get(i).getTitle())) { //找到自己所在的位置
						if(i != newsScienceList.size()-1) { //不是末位
							tmp = newsScienceList.get(i+1).getTitle();
						}else { //末位位回溯首位
							tmp = newsScienceList.get(0).getTitle();
						}
					}
					
				}
				
			break;
		}
		
		return tmp;
		
	}
	
	
}
