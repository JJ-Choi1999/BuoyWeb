package com.jnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnc.BuoyMessageSender;
import com.jnc.dao.FristViewPagerRepositoryQueryAnnotation;
import com.jnc.dao.UsersRepositoryQueryAnnotation;
import com.jnc.pojo.FristViewPager;
import com.jnc.pojo.Users;




/**
 * Spring Boot thymeleaf(Spring Boot推荐的视图层技术，通过特定语法与HTML绑定)的Controller
 * 
 * @author JNC
 *
 */
@Controller
public class AboutController {
	
	//RabbitMQ 生产者发送器
	@Autowired
	private BuoyMessageSender messageSender;
	
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
		
		FristViewPager fristViewPager = 
			this.fristViewPagerRepositoryQueryAnnotation.queryByFristViewPagerUseSQL();
					
		model.addAttribute("fristViewPagerTitle", fristViewPager.getTitle());
		
//--------------------------------------------------------------------------------------------------------------------//
		
		List<Users> usersList=
				this.usersRepositoryQueryAnnotation.queryByNameUseSQL(usersname);
				
		model.addAttribute("nickname", usersList.get(0).getNickname());
				
		String img = "http://localhost:8401/img/" + usersList.get(0).getImg(); 
				
		model.addAttribute("usersImg", img);
				
//--------------------------------------------------------------------------------------------------------------------//
		
		try {
			
			this.messageSender.sendMessage("about_focus"+","+usersname+","+"1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return page;
	}

}
