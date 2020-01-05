package com.jnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
public class SelectController {
	
	@Autowired
	private FristViewPagerRepositoryPagingAndSortingRepository fristViewPagerRepositoryPagingAndSortingRepository;
	
	@Autowired
	private ViewPagerRepositoryPagingAndSortingRepository viewPagerRepositoryPagingAndSortingRepository;
	
	
	@Autowired
	private NewsHorizonRepositoryPagingAndSortingRepository newsHorizonRepositoryPagingAndSortingRepository;
	
	@Autowired
	private NewsAbilityRepositoryPagingAndSortingRepository newsAbilityRepositoryPagingAndSortingRepository;
	
	@Autowired
	private NewsSocialRepositoryPagingAndSortingRepository newsSocialRepositoryPagingAndSortingRepository;
	
	@Autowired
	private NewsBusinessRepositoryPagingAndSortingRepository newsBusinessRepositoryPagingAndSortingRepository;
	
	@Autowired
	private NewsScienceRepositoryPagingAndSortingRepository newsScienceRepositoryPagingAndSortingRepository;
	
	
	@Autowired
	private MsgHorizonRepositoryPagingAndSortingRepository msgHorizonRepositoryPagingAndSortingRepository;
	
	@Autowired
	private MsgAbilityRepositoryPagingAndSortingRepository msgAbilityRepositoryPagingAndSortingRepository;
	
	@Autowired
	private MsgSocialRepositoryPagingAndSortingRepository msgSocialRepositoryPagingAndSortingRepository;
	
	@Autowired
	private MsgBusinessRepositoryPagingAndSortingRepository msgBusinessRepositoryPagingAndSortingRepository;
	
	@Autowired
	private MsgScienceRepositoryPagingAndSortingRepository msgScienceRepositoryPagingAndSortingRepository;
	
	
	@RequestMapping("/{html}")
	public String myController(@PathVariable String html,
			String method,String value,String pageNum,Model model) {
		
		String str=method+"_"+value;
		
		Order order=new Order(Direction.DESC, "date"); //排序依据
		Sort sort=new Sort(order); //排序规则
		Integer start=Integer.valueOf(pageNum)-1; //开始页码
		Pageable pageable=new PageRequest(start, 15,sort); //开始页码、每页条目、排序规则
		
		/**
		 * 自定义选择器
		 */
		switch(str) {
		
			case "viewpager_frist_viewpager":
				
				
				Page<FristViewPager> page= this.fristViewPagerRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<FristViewPager> list=page.getContent();//封装
				
				model.addAttribute("key", "首张轮播图"); //查询列表判断依据
				model.addAttribute("method", "viewpager"); //更新条目判断依据
				model.addAttribute("value", "frist_viewpager"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page.getTotalPages()); //总页数				
				model.addAttribute("list", list); //对象封装
				
				break;
			
			case "viewpager_edit":
				
				Page<ViewPager> page01= this.viewPagerRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<ViewPager> list01=page01.getContent();//封装
				
				model.addAttribute("key", "轮播图编辑"); //查询列表判断依据
				model.addAttribute("method", "viewpager"); //更新条目判断依据
				model.addAttribute("value", "edit"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page01.getTotalPages()); //总页数				
				model.addAttribute("list", list01); //对象封装
				
				break;
			
			
			case "news_horizon":
				
				Page<NewsHorizon> page02= this.newsHorizonRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<NewsHorizon> list02=page02.getContent();//封装
				
				model.addAttribute("key", "视野港新闻"); //查询列表判断依据
				model.addAttribute("method", "news"); //更新条目判断依据
				model.addAttribute("value", "horizon"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page02.getTotalPages()); //总页数				
				model.addAttribute("list", list02); //对象封装
				
				break;
			
			case "news_ability":
				
				Page<NewsAbility> page03= this.newsAbilityRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<NewsAbility> list03=page03.getContent();//封装
				
				model.addAttribute("key", "能力港新闻"); //查询列表判断依据
				model.addAttribute("method", "news"); //更新条目判断依据
				model.addAttribute("value", "ability"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page03.getTotalPages()); //总页数				
				model.addAttribute("list", list03); //对象封装
				
				break;
				
			case "news_social":
				
				Page<NewsSocial> page04= this.newsSocialRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<NewsSocial> list04=page04.getContent();//封装
				
				model.addAttribute("key", "人文社科港新闻"); //查询列表判断依据
				model.addAttribute("method", "news"); //更新条目判断依据
				model.addAttribute("value", "social"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page04.getTotalPages()); //总页数				
				model.addAttribute("list", list04); //对象封装
				
				break;
				
			case "news_business":
				
				Page<NewsBusiness> page05= this.newsBusinessRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<NewsBusiness> list05=page05.getContent();//封装
				
				model.addAttribute("key", "商业港新闻"); //查询列表判断依据
				model.addAttribute("method", "news"); //更新条目判断依据
				model.addAttribute("value", "business"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page05.getTotalPages()); //总页数				
				model.addAttribute("list", list05); //对象封装
				
				break;
				
			case "news_science":
				
				Page<NewsScience> page06= this.newsScienceRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<NewsScience> list06=page06.getContent();//封装
				
				model.addAttribute("key", "科学港新闻"); //查询列表判断依据
				model.addAttribute("method", "news"); //更新条目判断依据
				model.addAttribute("value", "science"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page06.getTotalPages()); //总页数				
				model.addAttribute("list", list06); //对象封装
				
				break;
					
				
			case "msg_horizon":
				
				Page<MsgHorizon> page07= this.msgHorizonRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<MsgHorizon> list07=page07.getContent();//封装
				
				model.addAttribute("key", "视野港信息"); //查询列表判断依据
				model.addAttribute("method", "msg"); //更新条目判断依据
				model.addAttribute("value", "horizon"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page07.getTotalPages()); //总页数				
				model.addAttribute("list", list07); //对象封装
				
				break;
			
			case "msg_ability":
				
				Page<MsgAbility> page08= this.msgAbilityRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<MsgAbility> list08=page08.getContent();//封装
				
				model.addAttribute("key", "能力港信息"); //查询列表判断依据
				model.addAttribute("method", "msg"); //更新条目判断依据
				model.addAttribute("value", "ability"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page08.getTotalPages()); //总页数				
				model.addAttribute("list", list08); //对象封装
				
				break;
				
			case "msg_social":
				
				Page<MsgSocial> page09= this.msgSocialRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<MsgSocial> list09=page09.getContent();//封装
				
				model.addAttribute("key", "人文社科港信息"); //查询列表判断依据
				model.addAttribute("method", "msg"); //更新条目判断依据
				model.addAttribute("value", "social"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page09.getTotalPages()); //总页数				
				model.addAttribute("list", list09); //对象封装
				
				break;
				
			case "msg_business":
				
				Page<MsgBusiness> page10= this.msgBusinessRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<MsgBusiness> list10=page10.getContent();//封装
				
				model.addAttribute("key", "商业港信息"); //查询列表判断依据
				model.addAttribute("method", "msg"); //更新条目判断依据
				model.addAttribute("value", "business"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page10.getTotalPages()); //总页数				
				model.addAttribute("list", list10); //对象封装
				
				break;
				
			case "msg_science":
				
				Page<MsgScience> page11= this.msgScienceRepositoryPagingAndSortingRepository.findAll(pageable); //按排序和分页规则查找
				List<MsgScience> list11=page11.getContent();//封装
				
				model.addAttribute("key", "科学港信息"); //查询列表判断依据
				model.addAttribute("method", "msg"); //更新条目判断依据
				model.addAttribute("value", "science"); //更新条目判断依据
				model.addAttribute("pageNum", pageNum); //当前页数
				model.addAttribute("totalPages", page11.getTotalPages()); //总页数				
				model.addAttribute("list", list11); //对象封装
				
				break;
							
				
				
				
		}
		
		return html;
	}
	
	
}
