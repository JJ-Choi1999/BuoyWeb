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
public class IndexController {
	
	//ViewPager的JPA增删查改模型
	@Autowired
	private ViewPagerRepositoryPagingAndSortingRepository viewPagerRepositoryPagingAndSortingRepository;
	
	//FristViewPager的JPA增删查改模型
	@Autowired
	private FristViewPagerRepositoryQueryAnnotation fristViewPagerRepositoryQueryAnnotation;
	
	//Users的JPA增删查改模型
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,
			String usersname,Model model) {
		
		model.addAttribute("usersname", usersname);

//--------------------------------------------------------------------------------------------------------------------//
		
		List<Users> usersList=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
		
		model.addAttribute("nickname", usersList.get(0).getNickname());
		
		String img = "http://192.168.134.213:8401/img/" + usersList.get(0).getImg(); 
		
		model.addAttribute("usersImg", img);
		
//--------------------------------------------------------------------------------------------------------------------//		
		
		FristViewPager fristViewPager = 
				this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
			
		model.addAttribute("fristViewPagerTitle", fristViewPager.getTitle());
		model.addAttribute("fristViewPagerContext", fristViewPager.getContext());
		model.addAttribute("fristViewPagerImg", fristViewPager.getImg());
		
		
//--------------------------------------------------------------------------------------------------------------------//		
		
		Order order=new Order(Direction.DESC, "id");
		List<ViewPager> list=
				(List<ViewPager>) this.viewPagerRepositoryPagingAndSortingRepository.findAll(new Sort(order));
		System.out.println("总条数="+list.size());
		if(list.size()<=5) {
			model.addAttribute("list", list);
		}else if(list.size()>5) {
			List<ViewPager> list01 = new ArrayList();
			for(int i=0;i<5;i++) {
				list01.add(list.get(i));
			}
			model.addAttribute("list", list01);
		}
		
		return page;
	}

}
