package com.jnc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jnc.BuoyNewsApplication;
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
 * Spring Data Redis 测试
 * @author JNC
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BuoyNewsApplication.class)
public class JPATest {
	
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
	
	@Test
	public void mySwicthPojoTest() {
		String str = mySwicthPojo("news","business","更改添加商业港标题03");
		System.out.println(str);
	
	}
	
	@Test
	public void myUpTest() {
		String str = upTest("viewpager","edit","轮播图标题04");
		System.out.println(str);
	
	}
	
	@Test
	public void myDownTest() {
		String str = downTest("viewpager","edit","添加轮播图标题01");
		System.out.println(str);
	
	}
	
	public String upTest(String method,String value,String title) {
		
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
	
	public String downTest(String method,String value,String title) {
		
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
	
	@Test
	public void seekFristViewPager() {
		FristViewPager fristViewPager = 
				this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
		System.out.println(fristViewPager.toString());
	}
	
	@Test
	public void seekFristViewPagerByTitle() {
		FristViewPager fristViewPager = 
				this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerTitleUseSQL("更改首张轮播图标题02");
		System.out.println(fristViewPager.getTitle());
		System.out.println(fristViewPager.getContext());
	}
	
	@Test
	public void seekViewPager() {
		List<ViewPager> list = 
				this.viewPagerRepositoryQueryAnnotation.queryByViewPagerUseSQL();
		for(ViewPager v:list) {
			System.out.println(v.toString());
		}
	}
	
	@Test
	public void seekViewPagerByTitle() {
		ViewPager viewPager = 
				this.viewPagerRepositoryQueryAnnotation.queryByViewPagerTitleUseSQL("添加轮播图标题01");
		System.out.println(viewPager.getTitle());
		System.out.println(viewPager.getContext());
	}
	
	@Test
	public void seekNewsHorizon() {
		List<NewsHorizon> list = 
				this.newsHorizonRepositoryQueryAnnotation.queryByNewsHorizonUseSQL();
		for(NewsHorizon nh:list) {
			System.out.println(nh.toString());
		}
	}
	
	@Test
	public void seekNewsAbility() {
		List<NewsAbility> list = 
				this.newsAbilityRepositoryQueryAnnotation.queryByNewsAbilityUseSQL();
		for(NewsAbility na:list) {
			System.out.println(na.toString());
		}
	}
	
	@Test
	public void seekNewsSocial() {
		List<NewsSocial> list = 
				this.newsSocialRepositoryQueryAnnotation.queryByNewsSocialUseSQL();
		for(NewsSocial ns:list) {
			System.out.println(ns.toString());
		}
	}
	
	@Test
	public void seekNewsBusiness() {
		List<NewsBusiness> list = 
				this.newsBusinessRepositoryQueryAnnotation.queryByNewsBusinessUseSQL();
		for(NewsBusiness nb:list) {
			System.out.println(nb.toString());
		}
	}
	
	@Test
	public void seekNewsScience() {
		List<NewsScience> list = 
				this.newsScienceRepositoryQueryAnnotation.queryByNewsScienceUseSQL();
		for(NewsScience nsc:list) {
			System.out.println(nsc.toString());
		}
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
