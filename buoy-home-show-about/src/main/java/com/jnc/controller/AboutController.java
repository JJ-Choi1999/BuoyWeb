package com.jnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.dao.FristViewPagerRepositoryQueryAnnotation;
import com.jnc.pojo.FristViewPager;





/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class AboutController {
	
	//FristViewPager的JPA增删查改模型
	@Autowired
	private FristViewPagerRepositoryQueryAnnotation fristViewPagerRepositoryQueryAnnotation;
	
	@RequestMapping("/{page}")
	public String myController(@PathVariable String page,Model model) {
		
		FristViewPager fristViewPager = 
				this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
			
		model.addAttribute("fristViewPagerTitle", fristViewPager.getTitle());
		
		return page;
	}

}
